package com.example.cchav.autoscroll;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by cchav on 26-Sep-15.
 */
public final class PlaceSlideFragment extends Fragment {
    int imageResourceId;


public  PlaceSlideFragment(){
        super();

    }

    public PlaceSlideFragment(int i) {
        imageResourceId = i;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ImageView image = new ImageView(getActivity());
        image.setImageResource(imageResourceId);

        LinearLayout layout = new LinearLayout(getActivity());
        layout.setLayoutParams(new ViewPager.LayoutParams());

        layout.setGravity(Gravity.CENTER);
        layout.addView(image);

        return layout;
    }
}
