package com.photoshop;

import java.util.ArrayList;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.photoshop.models.Photo;

public class ImageAdapter extends BaseAdapter {

	private LayoutInflater mInflater = null;
	ArrayList<Photo> mThisBasket;
	Photo temp;

	static class ViewHolder {
		TextView describe;
		TextView title;
		ImageView pic;

	}

	public ImageAdapter(Context context, ArrayList<Photo> basket) {
		mInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mThisBasket = basket;
		Log.e("adapter", mThisBasket.size() + " ");
	}

	@Override
	public int getCount() {
		return mThisBasket.size();
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
			view = mInflater.inflate(R.layout.list_basket_item, null);

			viewHolder = new ViewHolder();

			viewHolder.title = (TextView) view.findViewById(R.id.basket_title);
			viewHolder.describe = (TextView) view
					.findViewById(R.id.basket_descr);
			viewHolder.pic = (ImageView) view.findViewById(R.id.basket_icon);

			view.setTag(viewHolder);
		} else {
			viewHolder = (ViewHolder) view.getTag();
		}
		Log.e("adapter", mThisBasket.size() + " " + position);
		temp = mThisBasket.get(position);
		viewHolder.title.setText(temp.getmName());
		viewHolder.describe.setText(temp.getmDescribe());
		viewHolder.pic.setImageResource(temp.getmImageID());

		return view;
	}
}
