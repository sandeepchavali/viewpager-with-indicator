package com.example.cchav.autoscroll;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends FragmentActivity {
    public static final String TAG = "detailsFragment";
    private static final int NUM_PAGES = 4;
    //int[] page21 = {1, 1, 3, 1, 3, 1};

    Timer timer;
    int page = 0;
    //PlaceDetailsFragment place;
    LayoutInflater inflater;
    PlaceSlidesFragmentAdapter mAdapter;
    ViewPager mPager;
    PageIndicator mIndicator;
    //private int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();

        pageSwitcher(2);


    }


    private void setUpView() {
        mPager = (ViewPager) findViewById(R.id.pager);
        mAdapter = new PlaceSlidesFragmentAdapter(getSupportFragmentManager());
        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(0);
        //initButton();
        mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);
        ((CirclePageIndicator) mIndicator).setSnap(true);


        mIndicator
                .setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                        /*Toast.makeText(getApplicationContext(),
                                "Changed to page " + position,
                                Toast.LENGTH_SHORT).show();
                   */
                    }

                    @Override
                    public void onPageScrolled(int position,
                                               float positionOffset, int positionOffsetPixels) {
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {
                    }

                });
    }

    /*   This Method handels the switching of pages
    * */
    public void pageSwitcher(int seconds) {
        timer = new Timer(); // At this line a new Thread will be created
        timer.scheduleAtFixedRate(new RemindTask(), 1, seconds * 1000); // delay
        // in
        // milliseconds
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // this is an inner class...
    /*
    * Thia class is used for changing the Images automatically
    *
    * */
    class RemindTask extends TimerTask {

        int page3 = 0;

        @Override
        public void run() {

            // As the TimerTask run on a seprate thread from UI thread we have
            // to call runOnUiThread to do work on UI thread.
            runOnUiThread(new Runnable() {
                public void run() {

                    // mPager.setCurrentItem(page++);

                    if (page3 > 12) { // In my case the number of pages are 5
                        //timer.cancel();
                        page3 = 0;
                        pageSwitcher(2);
                        // Showing a toast for just testing purpose
                        //Toast.makeText(getApplicationContext(), "Timer stoped \n\r" + "Page value=" + page,
                        // Toast.LENGTH_LONG).show();
                    } else {
                        mPager.setCurrentItem(page3++);
                    }
                }
            });

        }
    }


}
