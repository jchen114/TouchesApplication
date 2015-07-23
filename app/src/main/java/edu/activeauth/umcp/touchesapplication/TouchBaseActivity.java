package edu.activeauth.umcp.touchesapplication;

import android.graphics.PointF;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;


public class TouchBaseActivity extends FragmentActivity implements View.OnTouchListener {

    private static String mLogTag = "TouchBaseActivity";
    public RelativeLayout mRelativeLayout;
    private StringBuilder toDump;
    private SparseArray<PointF> mActivePointers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(mLogTag, "On Create");
        setContentView(R.layout.activity_touch_base);
        mRelativeLayout = (RelativeLayout) getWindow().getDecorView().findViewById(R.id.root_view);
        mRelativeLayout.setOnTouchListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_touch_base, menu);
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int currentApiVersion = Build.VERSION.SDK_INT;
        if (currentApiVersion >= Build.VERSION_CODES.FROYO) {
            // Time, Motion Event, Pointer Id | X | Y
            // get pointer index from the event object
            int pointerIndex = event.getActionIndex();
            Log.i(mLogTag, "Pointer Index: " + Integer.toString(pointerIndex));
            // get pointer ID
            int pointerId = event.getPointerId(pointerIndex);
            Log.i(mLogTag, "Pointer Id: " + Integer.toString(pointerId));
            // get masked (not specific to a pointer) action
            int maskedAction = event.getActionMasked();

            switch (maskedAction) {

                case MotionEvent.ACTION_DOWN:
                    PointF pt = new PointF();
                    pt.x = event.getX();
                    pt.y = event.getY();
                    toDump = new StringBuilder();
                    toDump.append("Action Down, " + Integer.toString(pointerId) + " | " + Float.toString(pt.x) + " | " + Float.toString(pt.y));
                    mActivePointers = new SparseArray<>();
                    mActivePointers.put(pointerId, pt);
                    break;
                case MotionEvent.ACTION_POINTER_DOWN: {
                    // We have a new pointer. Lets add it to the list of pointers
                    PointF f = new PointF();
                    f.x = event.getX(pointerIndex);
                    f.y = event.getY(pointerIndex);
                    toDump = new StringBuilder();
                    toDump.append("New Pointer Down, " + Integer.toString(pointerId) + " | " + Float.toString(f.x) + " | " + Float.toString(f.y));
                    mActivePointers.put(pointerId, f);
                    break;
                }
                case MotionEvent.ACTION_MOVE: { // a pointer was moved
                    for (int size = event.getPointerCount(), i = 0; i < size; i++) {
                        PointF point = mActivePointers.get(event.getPointerId(i));
                        toDump = new StringBuilder();
                        toDump.append("Move, ");
                        if (point != null) {
                            point.x = event.getX(i);
                            point.y = event.getY(i);
                            toDump.append(Integer.toString(event.getPointerId(i)) + " | " + Float.toString(point.x) + " | " + Float.toString(point.y) + ", ");
                        }
                    }
                    break;
                }
                case MotionEvent.ACTION_UP:
                    toDump = new StringBuilder("Action up, " + Integer.toString(pointerId) + " | " + Float.toString(event.getX()) + " | " + Float.toString(event.getY()));
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    toDump = new StringBuilder("Action pointer up, " + Integer.toString(pointerId) + " | " + Float.toString(event.getX()) + " | " + Float.toString(event.getY()));
                    mActivePointers.remove(pointerId);
                    break;
                case MotionEvent.ACTION_CANCEL: {
                    toDump = new StringBuilder("Action cancel, " + Integer.toString(pointerId) + " | " + Float.toString(event.getX()) + " | " + Float.toString(event.getY()));
                    mActivePointers.remove(pointerId);
                    break;
                }
            }
        }

        Log.i(mLogTag, toDump.toString());

        return false;
    }

}
