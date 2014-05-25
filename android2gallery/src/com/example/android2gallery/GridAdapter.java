
package com.example.android2gallery;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class GridAdapter extends BaseAdapter {

    Context mCtx;

    public GridAdapter(Context c) {

        mCtx = c;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return Constans.zdjecia.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return Constans.zdjecia[position];
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iview;
        if (convertView == null) {
            iview = new ImageView(mCtx);
            iview.setLayoutParams(new GridView.LayoutParams(150, 200));
            iview.setScaleType(ImageView.ScaleType.CENTER_CROP);
            iview.setPadding(5, 5, 5, 5);
        } else {
            iview = (ImageView) convertView;
        }
        iview.setImageResource(Constans.zdjecia[position]);
        return iview;

    }

}
