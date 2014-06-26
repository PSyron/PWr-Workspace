package com.photoshop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.photoshop.models.User;
import com.photoshop.utils.Constans;

public class ShopActivity extends Activity {

	public static final int REQUEST_CODE = 5672763;

	User mUser;
	TextView mUiBasket;
	TextView mUiTitle1;
	TextView mUiSub11;
	TextView mUiSub12;
	TextView mUiSub13;

	TextView mUiTitle2;
	TextView mUiSub21;
	TextView mUiSub22;
	TextView mUiSub23;

	TextView mUiTitle3;
	TextView mUiSub31;
	TextView mUiSub32;
	TextView mUiSub33;

	TextView mUiTitle4;
	TextView mUiSub41;
	TextView mUiSub42;
	TextView mUiSub43;

	TextView mUiTitle5;
	TextView mUiSub51;
	TextView mUiSub52;
	TextView mUiSub53;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		Log.e("log", "OnCreate");
		setContentView(R.layout.activity_shop);
		initView();
		if (getIntent().hasExtra(Constans.EXTRAS_NAME_RETURN)) {
			mUser = (User) getIntent().getSerializableExtra(
					Constans.EXTRAS_NAME_RETURN);
			mUiBasket.setText(mUser.getmBasket().size() + "");
		} else {
			mUser = (User) getIntent().getSerializableExtra(
					Constans.EXTRAS_NAME);
		}
		Log.e("cos", mUser.getmBasket().size() + " ");
		mUiBasket.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						BasketActivity.class);

				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();

			}
		});

	}

	void initView() {
		mUiBasket = (TextView) findViewById(R.id.shop_counter);
		mUiTitle1 = (TextView) findViewById(R.id.shop_first_Title);
		mUiTitle2 = (TextView) findViewById(R.id.shop_second_Title);
		mUiTitle3 = (TextView) findViewById(R.id.shop_third_Title);
		mUiTitle4 = (TextView) findViewById(R.id.shop_fourth_Title);
		mUiTitle5 = (TextView) findViewById(R.id.shop_fifth_Title);

		mUiSub11 = (TextView) findViewById(R.id.shop_first1);
		mUiSub12 = (TextView) findViewById(R.id.shop_first2);
		mUiSub13 = (TextView) findViewById(R.id.shop_first3);

		mUiSub21 = (TextView) findViewById(R.id.shop_second1);
		mUiSub22 = (TextView) findViewById(R.id.shop_second2);
		mUiSub23 = (TextView) findViewById(R.id.shop_second3);

		mUiSub31 = (TextView) findViewById(R.id.shop_third1);
		mUiSub32 = (TextView) findViewById(R.id.shop_third2);
		mUiSub33 = (TextView) findViewById(R.id.shop_third3);

		mUiSub41 = (TextView) findViewById(R.id.shop_fourth1);
		mUiSub42 = (TextView) findViewById(R.id.shop_fourth2);
		mUiSub43 = (TextView) findViewById(R.id.shop_fourth3);

		mUiSub51 = (TextView) findViewById(R.id.shop_fifth1);
		mUiSub52 = (TextView) findViewById(R.id.shop_fifth2);
		mUiSub53 = (TextView) findViewById(R.id.shop_fifth3);
		initCategoryListeners();
		initSubCategoryListeners();
	}

	private void initSubCategoryListeners() {
		OnClickListener sub11 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 1);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				startActivity(intent);
				finish();

			}
		};
		OnClickListener sub12 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 2);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};
		OnClickListener sub13 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 3);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};
		OnClickListener sub21 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 4);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};
		OnClickListener sub22 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 5);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};

		OnClickListener sub23 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 6);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				startActivity(intent);
				finish();

			}
		};
		OnClickListener sub31 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 7);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};
		OnClickListener sub32 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 8);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};
		OnClickListener sub33 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 9);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};
		OnClickListener sub41 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 10);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};

		OnClickListener sub42 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 11);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				startActivity(intent);
				finish();

			}
		};
		OnClickListener sub43 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 12);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};
		OnClickListener sub51 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 13);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};
		OnClickListener sub52 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 14);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};
		OnClickListener sub53 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(ShopActivity.this,
						SubcategoryActivity.class);
				intent.putExtra(Constans.EXTRAS_WHICH, 15);
				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				// startActivity(intent);
				startActivity(intent);
				finish();
			}
		};

		mUiSub11.setOnClickListener(sub11);
		mUiSub12.setOnClickListener(sub12);
		mUiSub13.setOnClickListener(sub13);

		mUiSub21.setOnClickListener(sub21);
		mUiSub22.setOnClickListener(sub22);
		mUiSub23.setOnClickListener(sub23);

		mUiSub31.setOnClickListener(sub31);
		mUiSub32.setOnClickListener(sub32);
		mUiSub33.setOnClickListener(sub33);

		mUiSub41.setOnClickListener(sub41);
		mUiSub42.setOnClickListener(sub42);
		mUiSub43.setOnClickListener(sub43);

		mUiSub51.setOnClickListener(sub51);
		mUiSub52.setOnClickListener(sub52);
		mUiSub53.setOnClickListener(sub53);

	}

	private void initCategoryListeners() {
		mUiTitle1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (mUiSub11.getVisibility() == View.VISIBLE) {
					mUiSub11.setVisibility(View.GONE);
					mUiSub12.setVisibility(View.GONE);
					mUiSub13.setVisibility(View.GONE);
				} else {
					mUiSub11.setVisibility(View.VISIBLE);
					mUiSub12.setVisibility(View.VISIBLE);
					mUiSub13.setVisibility(View.VISIBLE);
				}

			}
		});

		mUiTitle2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (mUiSub21.getVisibility() == View.VISIBLE) {
					mUiSub21.setVisibility(View.GONE);
					mUiSub22.setVisibility(View.GONE);
					mUiSub23.setVisibility(View.GONE);
				} else {
					mUiSub21.setVisibility(View.VISIBLE);
					mUiSub22.setVisibility(View.VISIBLE);
					mUiSub23.setVisibility(View.VISIBLE);
				}

			}
		});

		mUiTitle3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (mUiSub31.getVisibility() == View.VISIBLE) {
					mUiSub31.setVisibility(View.GONE);
					mUiSub32.setVisibility(View.GONE);
					mUiSub33.setVisibility(View.GONE);
				} else {
					mUiSub31.setVisibility(View.VISIBLE);
					mUiSub32.setVisibility(View.VISIBLE);
					mUiSub33.setVisibility(View.VISIBLE);
				}

			}
		});

		mUiTitle4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (mUiSub41.getVisibility() == View.VISIBLE) {
					mUiSub41.setVisibility(View.GONE);
					mUiSub42.setVisibility(View.GONE);
					mUiSub43.setVisibility(View.GONE);
				} else {
					mUiSub41.setVisibility(View.VISIBLE);
					mUiSub42.setVisibility(View.VISIBLE);
					mUiSub43.setVisibility(View.VISIBLE);
				}

			}
		});

		mUiTitle5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (mUiSub51.getVisibility() == View.VISIBLE) {
					mUiSub51.setVisibility(View.GONE);
					mUiSub52.setVisibility(View.GONE);
					mUiSub53.setVisibility(View.GONE);
				} else {
					mUiSub51.setVisibility(View.VISIBLE);
					mUiSub52.setVisibility(View.VISIBLE);
					mUiSub53.setVisibility(View.VISIBLE);
				}

			}
		});

	}

}
