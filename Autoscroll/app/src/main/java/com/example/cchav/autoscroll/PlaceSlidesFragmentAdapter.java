package com.example.cchav.autoscroll;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by cchav on 26-Sep-15.
 */
public class PlaceSlidesFragmentAdapter extends FragmentPagerAdapter implements
        IconPagerAdapter {
    protected static final int[] ICONS = new int[]{R.drawable.round_purple,
            R.drawable.round_purple, R.drawable.round_purple, R.drawable.round_purple, R.drawable.round_purple, R.drawable.round_purple, R.drawable.round_purple,
            R.drawable.round_purple, R.drawable.round_purple, R.drawable.round_purple, R.drawable.round_purple, R.drawable.round_purple};
    public final int NUM = 4;
    private int[] Images = new int[]{R.drawable.brila1, R.drawable.birla21,
            R.drawable.bu1, R.drawable.bu2, R.drawable.cm1, R.drawable.cm2, R.drawable.brila1, R.drawable.birla21,
            R.drawable.bu1, R.drawable.bu2, R.drawable.cm1, R.drawable.cm2

    };
    private int mCount = Images.length;

    public PlaceSlidesFragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return new PlaceSlideFragment(Images[position]);
    }

    @Override
    public int getCount() {
        return mCount;
    }

    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }

    @Override
    public int getIconResId(int index) {


        return ICONS[index % ICONS.length];
    }


}