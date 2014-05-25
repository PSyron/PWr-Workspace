
package com.example.android3galeria;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.viewpagerindicator.CirclePageIndicator;

public class DetailsActivity extends FragmentActivity {

    int extrasInt;
    TextView mUiTitle;
    ImageView mUiPicture;
    TextView mUiDescribe;
    ViewPager mPager;
    CirclePageIndicator mIndicator;
    TestFragmentAdapter mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getSupportActionBar().setTitle("Galeria moich fotografii");
        setContentView(R.layout.activity_details);
        extrasInt = getIntent().getIntExtra("position", 0);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("wstecz");
        mUiTitle = (TextView) findViewById(R.id.title);
        mUiDescribe = (TextView) findViewById(R.id.describe);
        //  mUiPicture = (ImageView) findViewById(R.id.picture);
        mUiTitle.setText(Constans.title[extrasInt]);
        mUiDescribe.setText(Constans.descr[extrasInt]);
        //   mUiPicture.setImageResource(Constans.zdjecia[extrasInt]);

        mAdapter = new TestFragmentAdapter(getSupportFragmentManager(), extrasInt);

        mPager = (ViewPager) findViewById(R.id.pager);
        mPager.setAdapter(mAdapter);

        mIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        mIndicator.setViewPager(mPager);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
