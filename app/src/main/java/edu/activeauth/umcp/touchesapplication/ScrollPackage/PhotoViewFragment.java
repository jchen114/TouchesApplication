package edu.activeauth.umcp.touchesapplication.ScrollPackage;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import edu.activeauth.umcp.touchesapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhotoViewFragment extends Fragment {

    private ImageView myImage;
    private String mLogTag = "PhotoViewFragment";
    public static String RESOURCE_KEY = "RESOURCE_KEY";

    public PhotoViewFragment() {
        // Required empty public constructor
        super();
        Log.d(mLogTag, "Constructor");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(mLogTag, "On Create View");
        return inflater.inflate(R.layout.fragment_photo_view, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Bundle bundle = getArguments();
        int resId = bundle.getInt(RESOURCE_KEY);
        Log.d(mLogTag, "On Start, " + resId + Integer.toString(resId));
        setResource(resId);
    }

    private void setResource(int resource) {
        Log.d(mLogTag, "Set Resource");
        if (myImage == null) {
            myImage = (ImageView) getView().findViewById(R.id.photo);
        }
        myImage.setImageResource(resource);
    }
}
