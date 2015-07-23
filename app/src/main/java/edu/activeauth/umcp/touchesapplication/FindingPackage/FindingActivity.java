package edu.activeauth.umcp.touchesapplication.FindingPackage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import edu.activeauth.umcp.touchesapplication.R;
import edu.activeauth.umcp.touchesapplication.TouchBaseActivity;

/**
 * Created by Hooligan on 7/23/2015.
 */

public class FindingActivity extends TouchBaseActivity {

    WebView mWaldoWebView;
    private static String mLogTag = "FindingActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(mLogTag, "On Start");
        View view = getLayoutInflater().inflate(R.layout.waldo_web_view, null);
        mWaldoWebView = (WebView) view.findViewById(R.id.waldo_web_view);
        mWaldoWebView.loadUrl("file:///android_asset/waldo.html");
        mWaldoWebView.getSettings().setBuiltInZoomControls(true);
        mWaldoWebView.getSettings().setDisplayZoomControls(false);
        mWaldoWebView.setOnTouchListener(this);
        mRelativeLayout.addView(mWaldoWebView);
    }
}
