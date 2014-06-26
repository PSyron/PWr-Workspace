package com.photoshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.photoshop.models.Photo;
import com.photoshop.models.User;
import com.photoshop.utils.Constans;

public class DetailActivity extends Activity {
	User mUser;
	int mIndex;
	ImageView mUiPicture;
	TextView mUiTitle;
	TextView mUiDescrib;
	TextView mUiPrice;
	Button mUiBuy;
	Button mUiBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_details);
		mUser = (User) getIntent().getSerializableExtra(Constans.EXTRAS_NAME);
		mIndex = getIntent().getIntExtra(Constans.EXTRAS_DETAIL_INDEX, -1);
		mUiPicture = (ImageView) findViewById(R.id.det_img);
		mUiTitle = (TextView) findViewById(R.id.det_title);

		mUiPrice = (TextView) findViewById(R.id.det_price);
		mUiDescrib = (TextView) findViewById(R.id.det_desc);
		mUiBuy = (Button) findViewById(R.id.det_buy);
		mUiBack = (Button) findViewById(R.id.det_back);
		mUiPicture.setImageResource(Constans.photo_database[mIndex]);
		mUiTitle.setText(Constans.title_database[mIndex]);
		mUiDescrib.setText(Constans.describ_database[mIndex]);
		mUiPrice.setText(Constans.price_database[mIndex] + " zł ");

		mUiPicture.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(DetailActivity.this,
						SinglePhotoActivity.class);
				intent.putExtra(Constans.EXTRAS_PHOTO_ID,
						Constans.photo_database[mIndex]);
				// TODO Add extras or a data URI to this intent as appropriate.
				startActivity(intent);

			}
		});

		mUiBuy.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Photo ph = new Photo(Constans.title_database[mIndex],
						Constans.describ_database[mIndex],
						Constans.price_database[mIndex],
						Constans.photo_database[mIndex]);
				mUser.addItemToBasket(ph);

				Intent intent = new Intent(DetailActivity.this,
						ShopActivity.class);
				intent.putExtra(Constans.EXTRAS_NAME_RETURN, mUser);
				// TODO Add extras or a data URI to this intent as appropriate.
				startActivity(intent);

				finish();

			}
		});

		mUiBack.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Intent intent = new Intent(DetailActivity.this,
						ShopActivity.class);
				intent.putExtra(Constans.EXTRAS_NAME_RETURN, mUser);
				// TODO Add extras or a data URI to this intent as appropriate.
				startActivity(intent);

				finish();

			}
		});

		super.onCreate(savedInstanceState);
	}

	@Override
	public void onBackPressed() {

	}
}
