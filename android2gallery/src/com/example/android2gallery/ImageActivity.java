
package com.example.android2gallery;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ImageActivity extends Activity {

    LinearLayout myGallery;
    int extrasInt;
    TextView mUiButton;
    HorizontalScrollView mUiContainer;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getSupportActionBar().setTitle("Galeria moich fotografii");
        setContentView(R.layout.activity_image);
        extrasInt = getIntent().getIntExtra("resID", 0);
        myGallery = (LinearLayout) findViewById(R.id.mygallery);
        mUiButton = (TextView) findViewById(R.id.button);
        mUiContainer = (HorizontalScrollView) findViewById(R.id.horizontal);

        mUiButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });

        initPictures();

        //myGallery.set
    }

    void initPictures() {
        for (Integer resId : Constans.zdjecia) {

            myGallery.addView(insertPhoto(resId));
            if (resId == extrasInt) {
                return;
            }
        }
        mUiContainer.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
    }

    View insertPhoto(int resID) {

        LinearLayout layout = new LinearLayout(getApplicationContext());
        layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);

        ImageView imageView = new ImageView(getApplicationContext());
        imageView.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        imageView.setImageDrawable(getResources().getDrawable(resID));
        View space1 = new View(getApplicationContext());
        space1.setLayoutParams(new LayoutParams(100, LayoutParams.MATCH_PARENT));
        View space2 = new View(getApplicationContext());
        space2.setLayoutParams(new LayoutParams(100, LayoutParams.MATCH_PARENT));
        layout.addView(space1);
        layout.addView(imageView);
        layout.addView(space2);
        return layout;
    }
}
