package edu.activeauth.umcp.touchesapplication.PopupPackage;

import android.graphics.Point;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

import edu.activeauth.umcp.touchesapplication.R;
import edu.activeauth.umcp.touchesapplication.TouchBaseActivity;

/**
 * Created by Hooligan on 7/22/2015.
 */

public class PopupActivity extends TouchBaseActivity implements View.OnClickListener, View.OnTouchListener {

    private static String mLogTag = "PopupActivity";

    private int mState = 0;
    private ImageView mImageView;
    private int width;
    private int height;
    private Point mLocationOfTouch;
    private Point mLocationOfDown;
    private static int CONSTANT = 40;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        View view = getLayoutInflater().inflate(R.layout.photo_popup_view, null);
        mImageView = (ImageView) view.findViewById(R.id.photo_popup_imageview);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        width = pxToDp(size.x);
        height = pxToDp(size.y);

        Log.d(mLogTag, "width: " + Integer.toString(width) + " height: " + Integer.toString(height));

        mImageView.setMinimumWidth(width);
        mImageView.setMinimumHeight(height);
        mImageView.setImageResource(R.drawable.img01);
        mImageView.setOnTouchListener(this);
        setImageViewPosition();

        mRelativeLayout.addView(mImageView);
        mImageView.setOnClickListener(this);
    }

    private void setImageViewPosition() {
        switch (mState) {
            case 0: // Top left
                mImageView.setX(-width + CONSTANT);
                mImageView.setY(-height + CONSTANT);
                break;
            case 1: // Top center
                mImageView.setX(0);
                mImageView.setY(-height + CONSTANT);
                break;
            case 2: // Top right
                mImageView.setX(width - CONSTANT);
                mImageView.setY(-height + CONSTANT);
                break;
            case 3: // Middle left
                mImageView.setX(-width + CONSTANT);
                mImageView.setY(0);
                break;
            case 4: // Middle right
                mImageView.setX(width- CONSTANT);
                mImageView.setY(0);
                break;
            case 5: // Bottom left
                mImageView.setX(-width + CONSTANT);
                mImageView.setY(height - CONSTANT);
                break;
            case 6: // Bottom center
                mImageView.setX(0);
                mImageView.setY(height - CONSTANT);
                break;
            case 7: // Bottom right
                mImageView.setX(width - CONSTANT);
                mImageView.setY(height - CONSTANT);
                break;
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.photo_popup_imageview:
                Log.d(mLogTag, "Photo Clicked");
                mState = (mState + 1) % 8;
                setImageViewPosition();
                break;
        }
    }

    private int pxToDp(int px) {
        DisplayMetrics displayMetrics = this.getApplicationContext().getResources().getDisplayMetrics();
        int dp = Math.round(px / (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT));
        return dp;
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mLocationOfTouch = new Point((int)event.getX(), (int)event.getY());
                mLocationOfDown = new Point((int)event.getX(), (int)event.getY());
                break;
            case MotionEvent.ACTION_MOVE:
                int differenceX = (int) event.getX() - mLocationOfTouch.x;
                int differenceY = (int) event.getY() - mLocationOfTouch.y;
                mImageView.setX(mImageView.getX() + differenceX);
                mImageView.setY(mImageView.getY() + differenceY);
                mLocationOfTouch.set((int)event.getX(), (int)event.getY());
                break;
            case MotionEvent.ACTION_UP:
                int diffX = (int) event.getX() - mLocationOfDown.x;
                int diffY = (int) event.getY() - mLocationOfDown.y;
                Double distance = Math.pow(diffX, 2) + Math.pow(diffY,2);
                Log.d(mLogTag, "distance: " + Double.toString(distance));
                if (distance < 5) {
                    return false;
                } else {
                    return true;
                }
        }
        return super.onTouch(v, event);
    }

}
