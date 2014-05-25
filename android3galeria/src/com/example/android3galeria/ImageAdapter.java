
package com.example.android3galeria;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ImageAdapter extends BaseAdapter {

    private LayoutInflater mInflater = null;

    static class ViewHolder {
        TextView distance;
        TextView title;
        ImageView pic;

    }

    public ImageAdapter(Context context) {
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return Constans.zdjecia.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        View view = convertView;
        if (view == null) {
            view = mInflater.inflate(R.layout.item_list, null);

            viewHolder = new ViewHolder();

            viewHolder.title = (TextView) view.findViewById(R.id.title);
            viewHolder.distance = (TextView) view.findViewById(R.id.distance);
            viewHolder.pic = (ImageView) view.findViewById(R.id.picture);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.title.setText(Constans.title[position]);
        viewHolder.distance.setText(Constans.distance[position] + " ");
        viewHolder.pic.setImageResource(Constans.zdjecia[position]);

        return view;
    }
}
