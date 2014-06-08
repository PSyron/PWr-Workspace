package com.routeapp;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class TrackActivity extends Activity {

	static LatLng StartingPoint = null;
	private GoogleMap googleMap;
	private ArrayList<LatLng> points = null;
	PolylineOptions lineOptions;
	Button mUiBtStart;
	Button mUiBtStop;
	GPSTracker mGps;
	Boolean mStarted;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_track);
		points = new ArrayList<LatLng>();
		lineOptions = new PolylineOptions();
		mStarted = false;
		mGps = new GPSTracker(this);
		if (mGps.canGetLocation()) {
			Log.e("log", "true");
			double lat = mGps.getLatitude(); // returns latitude
			double lng = mGps.getLongitude(); // returns longitude
			StartingPoint = new LatLng(lat, lng);

		}
		init();
		try {
			if (googleMap == null) {
				googleMap = ((MapFragment) getFragmentManager()
						.findFragmentById(R.id.map)).getMap();
			}
			googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

			Marker TP = googleMap.addMarker(new MarkerOptions().position(
					StartingPoint).title("Starting Point"));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void init() {

		mUiBtStart = (Button) findViewById(R.id.track_start);
		mUiBtStop = (Button) findViewById(R.id.track_stop);
		mUiBtStart.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(
						new LatLng(mGps.getLatitude(), mGps.getLongitude()),
						12.0f));
				Toast.makeText(
						getApplicationContext(),
						"Rozpoczęto pomiar, naciśnij STOP aby zobaczyć trase wynikową",
						Toast.LENGTH_LONG).show();
				mStarted = true;
				startProgress();
			}
		});
		mUiBtStop.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				mStarted = false;
				Toast.makeText(getApplicationContext(), "Zakończono pomiar",
						Toast.LENGTH_LONG).show();
				Marker TS = googleMap.addMarker(new MarkerOptions().position(
						new LatLng(mGps.getLatitude(), mGps.getLongitude()))
						.title("Finish Point"));

				mGps.stopUsingGPS();

				lineOptions.addAll(points);
				lineOptions.width(2);
				lineOptions.color(Color.RED);

				googleMap.addPolyline(lineOptions);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.track, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void startProgress() {

		points = new ArrayList<LatLng>();

		new Thread(new Task()).start();

	}

	// Kontrola wycieków pamięci
	@Override
	protected void onPause() {
		mStarted = false;
		mGps.stopUsingGPS();
		super.onPause();
	}

	@Override
	public void onBackPressed() {
		mStarted = false;
		mGps.stopUsingGPS();
		super.onBackPressed();
	}

	class Task implements Runnable {
		double lat;
		double lng;

		@Override
		public void run() {

			while (mStarted) {
				try {
					Thread.sleep(1000); // TODO Tu ustawiasz czas pomiedzy
										// pomiarami
					lat = mGps.getLatitude();
					lng = mGps.getLongitude();
					points.add(new LatLng(lat, lng));

					Log.e("log", lat + " " + lng + " size " + points.size());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
}
