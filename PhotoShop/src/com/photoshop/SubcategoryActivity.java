package com.photoshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.photoshop.models.User;
import com.photoshop.utils.Constans;

public class SubcategoryActivity extends Activity {
	User mUser;
	int mWhich;
	ImageView mUiFirst;
	ImageView mUiSecond;
	ImageView mUiThird;
	int mFirst;
	int mSecond;
	int mThird;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subcategory);
		mUser = (User) getIntent().getSerializableExtra(Constans.EXTRAS_NAME);
		mWhich = getIntent().getIntExtra(Constans.EXTRAS_WHICH, 0);
		mUiFirst = (ImageView) findViewById(R.id.sub_first);
		mUiSecond = (ImageView) findViewById(R.id.sub_second);
		mUiThird = (ImageView) findViewById(R.id.sub_third);

		mFirst = (mWhich * 3) - 3;
		mSecond = (mWhich * 3) - 2;
		mThird = (mWhich * 3) - 1;
		mUiFirst.setImageResource(Constans.photo_database[mFirst]);
		mUiSecond.setImageResource(Constans.photo_database[mSecond]);
		mUiThird.setImageResource(Constans.photo_database[mThird]);

		mUiFirst.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SubcategoryActivity.this,
						DetailActivity.class);
				intent.putExtra(Constans.EXTRAS_DETAIL_INDEX, mFirst);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				startActivity(intent);
				finish();
			}
		});
		mUiSecond.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SubcategoryActivity.this,
						DetailActivity.class);
				intent.putExtra(Constans.EXTRAS_DETAIL_INDEX, mSecond);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				startActivity(intent);
				finish();
			}
		});
		mUiThird.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(SubcategoryActivity.this,
						DetailActivity.class);
				intent.putExtra(Constans.EXTRAS_DETAIL_INDEX, mThird);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				startActivity(intent);
				finish();
			}
		});

	}

	@Override
	public void onBackPressed() {

		Intent intent = new Intent(SubcategoryActivity.this, ShopActivity.class);
		intent.putExtra(Constans.EXTRAS_NAME_RETURN, mUser);
		// TODO Add extras or a data URI to this intent as appropriate.
		startActivity(intent);

		finish();

		super.onBackPressed();
	}

}
