package edu.activeauth.umcp.touchesapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import edu.activeauth.umcp.touchesapplication.FindingPackage.FindingActivity;
import edu.activeauth.umcp.touchesapplication.PopupPackage.PopupActivity;
import edu.activeauth.umcp.touchesapplication.ScrollPackage.HorizontalScrollActivity;
import edu.activeauth.umcp.touchesapplication.ScrollPackage.VerticalScrollActivity;

public class TouchActivitySelector extends Activity implements View.OnClickListener {

    private static String mLogTag = "TouchActivitySelector";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_activity_selector);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_touch_activity_selector, menu);
        return true;
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
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.horizontal_scroll_activity_button:
                Intent horizontalScrollIntent = new Intent(this, HorizontalScrollActivity.class);
                startActivity(horizontalScrollIntent);
                break;
            case R.id.vertical_scroll_activity_button:
                Intent verticalScrollIntent = new Intent(this, VerticalScrollActivity.class);
                startActivity(verticalScrollIntent);
                break;
            case R.id.popup_activity_button:
                Intent popupIntent = new Intent(this, PopupActivity.class);
                startActivity(popupIntent);
                break;
            case R.id.finding_activity_button:
                Intent findingIntent = new Intent(this, FindingActivity.class);
                startActivity(findingIntent);
                break;
        }
    }

}
