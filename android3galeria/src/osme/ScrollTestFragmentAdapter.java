
package osme;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.android3galeria.R;
import com.example.android3galeria.TestFragment;
import com.viewpagerindicator.IconPagerAdapter;

class ScrollTestFragmentAdapter extends FragmentPagerAdapter implements IconPagerAdapter {
    protected static final String[] CONTENT = new String[] {
            "Pierwszy", "Drugi", "Trzeci", "Czwarty", "Piaty", "Szosty"
    };

    int[] ICONS;

    public static final int[] pierwsza = new int[] {
            R.drawable.piate1, R.drawable.piate2, R.drawable.piate3, R.drawable.piate4,
            R.drawable.piate5
    };

    public static final int[] druga = new int[] {
            R.drawable.piate6, R.drawable.piate7, R.drawable.piate8, R.drawable.piate9,
            R.drawable.piate10
    };

    public static final int[] trzecia = new int[] {
            R.drawable.piate11, R.drawable.piate12, R.drawable.piate13, R.drawable.piate14,
            R.drawable.piate15
    };

    int mWhichPhoto;

    int mCount;

    public ScrollTestFragmentAdapter(FragmentManager fm, int whichPhoto) {
        super(fm);

        int[] wybrana = null;
        if (whichPhoto == 1) {
            wybrana = pierwsza;
        } else if (whichPhoto == 2) {
            wybrana = druga;
        } else if (whichPhoto == 3) {
            wybrana = trzecia;
        }

        mWhichPhoto = whichPhoto;
        mCount = 5;
        ICONS = new int[5];

        ICONS = wybrana;

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
