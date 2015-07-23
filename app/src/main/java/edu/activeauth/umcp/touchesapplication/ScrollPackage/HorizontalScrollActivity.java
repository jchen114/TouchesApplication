package edu.activeauth.umcp.touchesapplication.ScrollPackage;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;

import edu.activeauth.umcp.touchesapplication.R;
import edu.activeauth.umcp.touchesapplication.TouchBaseActivity;

/**
 * Created by Hooligan on 7/21/2015.
 */
public class HorizontalScrollActivity extends TouchBaseActivity {

    /**
     * The number of pages (wizard steps) to show in this demo.
     */
    private static final int NUM_PAGES = 7;

    private static String mLogTag = "HorizontalScrollActivity";

    private ViewPager mPager;
    private PagerAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(mLogTag, "On Create");
        View pagerView = getLayoutInflater().inflate(R.layout.horizontal_view_pager, null);
        mPager = (ViewPager) pagerView.findViewById(R.id.horizontal_pager);
        mRelativeLayout.addView(mPager);

        mPagerAdapter = new ScrollImageAdapter(getSupportFragmentManager(), NUM_PAGES, this, true);
        mPager.setAdapter(mPagerAdapter);
        mPager.setOnTouchListener(this);
    }

}
