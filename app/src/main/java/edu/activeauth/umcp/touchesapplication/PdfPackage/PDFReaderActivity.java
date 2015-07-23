package edu.activeauth.umcp.touchesapplication.PdfPackage;

import android.util.Log;
import android.view.View;
import android.webkit.WebView;

import edu.activeauth.umcp.touchesapplication.R;
import edu.activeauth.umcp.touchesapplication.TouchBaseActivity;

/**
 * Created by Hooligan on 7/23/2015.
 */
public class PDFReaderActivity extends TouchBaseActivity {

    private WebView mPDFWebView;
    private static String mLogTag = "PDFReaderActivity";

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(mLogTag, "On Start");
        View view = getLayoutInflater().inflate(R.layout.waldo_web_view, null);
        mPDFWebView = (WebView) view.findViewById(R.id.waldo_web_view);
        mPDFWebView.getSettings().setBuiltInZoomControls(true);
        mPDFWebView.getSettings().setDisplayZoomControls(false);
        mPDFWebView.getSettings().setJavaScriptEnabled(true);
        String pdf = "http://www.adobe.com/devnet/acrobat/pdfs/pdf_open_parameters.pdf";
        mPDFWebView.loadUrl("http://docs.google.com/gview?embedded=true&url=" + pdf);
        mPDFWebView.setOnTouchListener(this);
        mRelativeLayout.addView(mPDFWebView);
    }



}
