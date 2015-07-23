package edu.activeauth.umcp.touchesapplication.ScrollPackage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * Created by Hooligan on 7/21/2015.
 */
public class ScrollImageAdapter extends FragmentStatePagerAdapter {

    private static String mLogTag = "ScrollImageAdapter";
    private int NUM_PAGES;
    private Context mContext;
    private boolean mHorizontal = true;

    public ScrollImageAdapter(FragmentManager fm, int numPages, Context context, boolean horizontal) {
        super(fm);
        NUM_PAGES = numPages;
        mContext = context;
        mHorizontal = horizontal;
    }

    @Override
    public Fragment getItem(int position) {
        PhotoViewFragment pf = new PhotoViewFragment();
        NumberFormat f = new DecimalFormat("00");
        String imageName;
        if (mHorizontal) {
            imageName = "img" + f.format(position + 1);

        } else {
            imageName = "img" + f.format(position + 8);
        }
        int resId = mContext.getResources().getIdentifier(imageName, "drawable", mContext.getPackageName());
        Log.d(mLogTag, "imageName: " + imageName + " resId: " + Integer.toString(resId));
        Bundle args = new Bundle();
        args.putInt(PhotoViewFragment.RESOURCE_KEY, resId);
        pf.setArguments(args);
        return pf;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }

}