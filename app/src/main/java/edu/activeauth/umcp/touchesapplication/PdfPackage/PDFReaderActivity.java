package edu.activeauth.umcp.touchesapplication.PdfPackage;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import edu.activeauth.umcp.touchesapplication.R;
import edu.activeauth.umcp.touchesapplication.TouchBaseActivity;

/**
 * Created by Hooligan on 7/23/2015.
 */
public class PDFReaderActivity extends TouchBaseActivity {

    WebView mReadingWebView;
    private static String mLogTag = "PDFReaderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(mLogTag, "On Start");
        View view = getLayoutInflater().inflate(R.layout.reading_web_view, null);
        mReadingWebView = (WebView) view.findViewById(R.id.reading_web_view);
        mReadingWebView.loadUrl("file:///android_asset/article.html");
        mReadingWebView.getSettings().setBuiltInZoomControls(true);
        mReadingWebView.getSettings().setDisplayZoomControls(false);
        mReadingWebView.setOnTouchListener(this);
        mRelativeLayout.addView(mReadingWebView);
    }


}
