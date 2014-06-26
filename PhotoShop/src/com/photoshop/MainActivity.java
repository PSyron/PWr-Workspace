package com.photoshop;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.photoshop.models.Photo;
import com.photoshop.models.User;
import com.photoshop.utils.Constans;

public class MainActivity extends Activity {

	Button mUiButton;
	EditText mUiLogin;
	EditText mUiPassword;
	User mUser;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initView();

	}

	void initView() {
		mUiButton = (Button) findViewById(R.id.main_bt_zaloguj);
		mUiLogin = (EditText) findViewById(R.id.main_login);
		mUiPassword = (EditText) findViewById(R.id.main_password);

		mUiButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mUser = new User(new ArrayList<Photo>(), mUiLogin.getText()
						.toString(), mUiPassword.getText().toString());
				Intent intent = new Intent(MainActivity.this,
						ShopActivity.class);

				intent.putExtra(Constans.EXTRAS_NAME, mUser);
				startActivity(intent);
				finish();
			}
		});
	}

}
