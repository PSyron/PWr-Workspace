
package com.example.android3galeria;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.viewpagerindicator.IconPagerAdapter;

import java.util.Random;

class TestFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
    protected static final String[] CONTENT = new String[] {
            "Pierwszy", "Drugi", "Trzeci", "Czwarty", "Piaty", "Szosty"
    };
    int[] ICONS;

    int mWhichPhoto;

    int mCount;

    public TestFragmentAdapter(FragmentManager fm, int whichPhoto) {
        super(fm);
        mWhichPhoto = whichPhoto;
        mCount = Constans.ileZdjec[whichPhoto];
        ICONS = new int[mCount];
        ICONS[0] = Constans.zdjecia[whichPhoto];
        Random rand = new Random();
        int random = whichPhoto;
        Log.e("adapter", mCount + " " + mWhichPhoto + " " + ICONS[0]);
        for (int i = 1; i < mCount; i++) {
            random = rand.nextInt(Constans.zdjecia.length);
            ICONS[i] = Constans.zdjecia[random];
        }

    }

    @Override
    public Fragment getItem(int position) {
        return TestFragment.newInstance(ICONS[position % mCount]);
    }

    @Override
    public int getCount() {
        return mCount;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "";
    }

    @Override
    public int getIconResId(int index) {
        return ICONS[index % ICONS.length];
    }

    public void setCount(int count) {
        if (count > 0 && count <= 10) {
            mCount = count;
            notifyDataSetChanged();
        }
    }
}
