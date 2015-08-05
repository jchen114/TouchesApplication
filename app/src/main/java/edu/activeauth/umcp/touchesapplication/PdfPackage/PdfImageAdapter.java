package edu.activeauth.umcp.touchesapplication.PdfPackage;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import edu.activeauth.umcp.touchesapplication.ScrollPackage.PhotoViewFragment;

/**
 * Created by Hooligan on 8/5/2015.
 */
public class PdfImageAdapter extends FragmentStatePagerAdapter {

    private static String mLogTag = "PDFImageAdapter";
    private int NUM_PAGES;
    private Context mContext;
    private boolean mHorizontal = true;

    public PdfImageAdapter(FragmentManager fm, int numPages, Context context, boolean horizontal) {
        super(fm);
        NUM_PAGES = numPages;
        mContext = context;
        mHorizontal = horizontal;
    }

    @Override
    public Fragment getItem(int position) {
        PhotoViewFragment pf = new PhotoViewFragment();
        NumberFormat f = new DecimalFormat("000");
        String imageName  = "article_" + f.format(position + 1);
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
