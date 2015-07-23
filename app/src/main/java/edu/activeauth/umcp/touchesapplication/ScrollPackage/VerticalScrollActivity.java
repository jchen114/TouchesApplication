package edu.activeauth.umcp.touchesapplication.ScrollPackage;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;

import edu.activeauth.umcp.touchesapplication.R;
import edu.activeauth.umcp.touchesapplication.TouchBaseActivity;
import fr.castorflex.android.verticalviewpager.VerticalViewPager;

/**
 * Created by Hooligan on 7/22/2015.
 */
public class VerticalScrollActivity extends TouchBaseActivity {

    private static final int NUM_PAGES = 7;
    private static String mLogTag = "VerticalScrollActivity";

    private VerticalViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(mLogTag, "On Create");
        View pagerView = getLayoutInflater().inflate(R.layout.vertical_view_pager, null);
        mPager = (VerticalViewPager) pagerView.findViewById(R.id.vertical_pager);
        mPagerAdapter = new ScrollImageAdapter(getSupportFragmentManager(), NUM_PAGES, this, false);
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnTouchListener(this);

        mRelativeLayout.addView(mPager);

    }
}
