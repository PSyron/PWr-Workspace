package com.photoshop;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;

import com.photoshop.models.User;
import com.photoshop.utils.Constans;

public class BasketActivity extends Activity {

	User mUser;
	ListView mUiLista;
	ImageAdapter mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_basket);
		mUser = (User) getIntent().getSerializableExtra(Constans.EXTRAS_NAME);
		Log.e("basket", mUser.getmBasket().size() + " ");
		mUiLista = (ListView) findViewById(R.id.bakset_list);
		mAdapter = new ImageAdapter(this, mUser.getmBasket());
		mUiLista.setAdapter(mAdapter);
		mUiLista.setOnItemLongClickListener(new OnItemLongClickListener() {
			// setting onItemLongClickListener and passing the position to the
			// function
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				removeItemFromList(position);

				return true;
			}
		});
	}

	// method to remove list item
	protected void removeItemFromList(int position) {
		final int deletePosition = position;

		AlertDialog.Builder alert = new AlertDialog.Builder(BasketActivity.this);

		alert.setTitle("Usuwanie z koszyka");
		alert.setMessage("Chcesz usunąć z koszyka ten przedmiot?");
		alert.setPositiveButton("Potwierdź", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TOD O Auto-generated method stub

				// main code on after clicking yes

				mUser.removerItemFromBasket(deletePosition);
				mAdapter.notifyDataSetChanged();
				mAdapter.notifyDataSetInvalidated();

			}
		});
		alert.setNegativeButton("Anuluj", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				dialog.dismiss();
			}
		});

		alert.show();

	}

	@Override
	public void onBackPressed() {

		Intent intent = new Intent(BasketActivity.this, ShopActivity.class);
		intent.putExtra(Constans.EXTRAS_NAME_RETURN, mUser);
		// TODO Add extras or a data URI to this intent as appropriate.
		startActivity(intent);

		finish();

		super.onBackPressed();
	}

}
