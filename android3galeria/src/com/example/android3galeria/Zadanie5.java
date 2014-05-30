
package com.example.android3galeria;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class Zadanie5 extends Activity {

    ImageView mUiPierwsze;
    ImageView mUiDrugie;
    ImageView mUiTrzecie;
    ImageView mUiCzwarte;
    ImageView mUiPiate;
    ImageView mUiSzoste;
    ImageView mUiSiodme;
    ImageView mUiOsme;
    ImageView mUiDziewiate;
    ImageView mUiDziesiate;
    ImageView mUiJedynaste;
    ImageView mUiDwunaste;
    ImageView mUiTrzynaste;
    ImageView mUiCzternaste;
    ImageView mUiPietnaste;
    ImageView mUiSzesnaste;
    ImageView mUiBigOne;
    int mImageW;
    int mImageH;
    int mSpaceW;
    int mSpaceH;
    int mDuration = 1200;
    boolean pressed = false;
    boolean bigOnePressd = false;

    public OnLongClickListener imgClk = new OnLongClickListener() {

        @Override
        public boolean onLongClick(View v) {
            if (R.id.image_4 == v.getId() || v.getId() == R.id.image_8
                    || v.getId() == R.id.image_12) {
                animToLB(v);
            } else if (R.id.image_13 == v.getId() || R.id.image_14 == v.getId()
                    || R.id.image_15 == v.getId()) {
                animToRT(v);
            } else if (R.id.image_16 == v.getId()) {
                animToLT(v);
            } else {
                animaToRB(v);
            }
            return true;
        }
    };

    public OnClickListener imgOneClick = new OnClickListener() {

        @Override
        public void onClick(View v) {
            if (bigOnePressd == false) {
                if (v instanceof ImageView) {
                    bigOnePressd = true;
                    mUiBigOne.setVisibility(View.VISIBLE);

                    mUiBigOne.setImageDrawable(((ImageView) v).getDrawable());
                }
            }
        }

    };

    OnTouchListener imgTouch = new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_CANCEL
                    || event.getAction() == MotionEvent.ACTION_UP) {
                v.clearAnimation();
            }
            return false;
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //getSupportActionBar().setTitle("Galeria moich fotografii");
        setContentView(R.layout.activity_piate);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("Zadanie 5");
        actionBar.hide();

        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        int width = size.x;
        int height = size.y;
        mImageW = width / 6;
        mImageH = height / 6;
        mSpaceW = width / 96;
        mSpaceH = height / 96;
        // View + click listiner
        initViews();
        // initSize();

    }

    public void initViews() {
        mUiPierwsze = (ImageView) findViewById(R.id.image_1);
        mUiPierwsze.setOnLongClickListener(imgClk);
        mUiPierwsze.setOnClickListener(imgOneClick);
        mUiPierwsze.setOnTouchListener(imgTouch);
        mUiDrugie = (ImageView) findViewById(R.id.image_2);
        mUiDrugie.setOnLongClickListener(imgClk);
        mUiDrugie.setOnClickListener(imgOneClick);
        mUiDrugie.setOnTouchListener(imgTouch);
        mUiTrzecie = (ImageView) findViewById(R.id.image_3);
        mUiTrzecie.setOnLongClickListener(imgClk);
        mUiTrzecie.setOnClickListener(imgOneClick);
        mUiTrzecie.setOnTouchListener(imgTouch);
        mUiCzwarte = (ImageView) findViewById(R.id.image_4);
        mUiCzwarte.setOnLongClickListener(imgClk);
        mUiCzwarte.setOnClickListener(imgOneClick);
        mUiCzwarte.setOnTouchListener(imgTouch);
        mUiPiate = (ImageView) findViewById(R.id.image_5);
        mUiPiate.setOnLongClickListener(imgClk);
        mUiPiate.setOnClickListener(imgOneClick);
        mUiPiate.setOnTouchListener(imgTouch);
        mUiSzoste = (ImageView) findViewById(R.id.image_6);
        mUiSzoste.setOnLongClickListener(imgClk);
        mUiSzoste.setOnClickListener(imgOneClick);
        mUiSzoste.setOnTouchListener(imgTouch);
        mUiSiodme = (ImageView) findViewById(R.id.image_7);
        mUiSiodme.setOnLongClickListener(imgClk);
        mUiSiodme.setOnClickListener(imgOneClick);
        mUiSiodme.setOnTouchListener(imgTouch);
        mUiOsme = (ImageView) findViewById(R.id.image_8);
        mUiOsme.setOnLongClickListener(imgClk);
        mUiOsme.setOnClickListener(imgOneClick);
        mUiOsme.setOnTouchListener(imgTouch);
        mUiDziewiate = (ImageView) findViewById(R.id.image_9);
        mUiDziewiate.setOnLongClickListener(imgClk);
        mUiDziewiate.setOnClickListener(imgOneClick);
        mUiDziewiate.setOnTouchListener(imgTouch);
        mUiDziesiate = (ImageView) findViewById(R.id.image_10);
        mUiDziesiate.setOnLongClickListener(imgClk);
        mUiDziesiate.setOnClickListener(imgOneClick);
        mUiDziesiate.setOnTouchListener(imgTouch);
        mUiJedynaste = (ImageView) findViewById(R.id.image_11);
        mUiJedynaste.setOnLongClickListener(imgClk);
        mUiJedynaste.setOnClickListener(imgOneClick);
        mUiJedynaste.setOnTouchListener(imgTouch);
        mUiDwunaste = (ImageView) findViewById(R.id.image_12);
        mUiDwunaste.setOnLongClickListener(imgClk);
        mUiDwunaste.setOnClickListener(imgOneClick);
        mUiDwunaste.setOnTouchListener(imgTouch);
        mUiTrzynaste = (ImageView) findViewById(R.id.image_13);
        mUiTrzynaste.setOnLongClickListener(imgClk);
        mUiTrzynaste.setOnClickListener(imgOneClick);
        mUiTrzynaste.setOnTouchListener(imgTouch);
        mUiCzternaste = (ImageView) findViewById(R.id.image_14);
        mUiCzternaste.setOnLongClickListener(imgClk);
        mUiCzternaste.setOnClickListener(imgOneClick);
        mUiCzternaste.setOnTouchListener(imgTouch);
        mUiPietnaste = (ImageView) findViewById(R.id.image_15);
        mUiPietnaste.setOnLongClickListener(imgClk);
        mUiPietnaste.setOnClickListener(imgOneClick);
        mUiPietnaste.setOnTouchListener(imgTouch);
        mUiSzesnaste = (ImageView) findViewById(R.id.image_16);
        mUiSzesnaste.setOnLongClickListener(imgClk);
        mUiSzesnaste.setOnClickListener(imgOneClick);
        mUiSzesnaste.setOnTouchListener(imgTouch);
        mUiBigOne = (ImageView) findViewById(R.id.big_picture);

        mUiBigOne.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                if (bigOnePressd == true) {
                    bigOnePressd = false;
                    animBig(v);
                    v.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    public void initSize() {
        RelativeLayout.LayoutParams parms = new RelativeLayout.LayoutParams(mImageW, mImageH);
        parms.setMargins(mSpaceW, mSpaceH, mSpaceW, mSpaceH);

        mUiPierwsze.setLayoutParams(parms);
        mUiPierwsze.setMaxHeight(mImageH);
        mUiPierwsze.setMaxWidth(mImageH);
        parms.addRule(RelativeLayout.LEFT_OF, mUiPierwsze.getId());
        mUiDrugie.setLayoutParams(parms);

        parms.addRule(RelativeLayout.LEFT_OF, mUiDrugie.getId());
        mUiTrzecie.setLayoutParams(parms);
        mUiCzwarte.setLayoutParams(parms);
        mUiPiate.setLayoutParams(parms);
        mUiSzoste.setLayoutParams(parms);
        mUiSiodme.setLayoutParams(parms);
        mUiOsme.setLayoutParams(parms);
        mUiDziewiate.setLayoutParams(parms);
        mUiDziesiate.setLayoutParams(parms);
        mUiJedynaste.setLayoutParams(parms);
        mUiDwunaste.setLayoutParams(parms);
        mUiTrzynaste.setLayoutParams(parms);
        mUiCzternaste.setLayoutParams(parms);
        mUiPietnaste.setLayoutParams(parms);
        mUiSzesnaste.setLayoutParams(parms);
    }

    public void animaToRB(View view) {
        //        Animation scale = new ScaleAnimation(fromXscale, toXscale, fromYscale, toYscale,
        //                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        view.bringToFront();
        Animation scale = new ScaleAnimation(1, 2.9f, 1, 2.9f, Animation.RELATIVE_TO_SELF, 0,
                Animation.RELATIVE_TO_SELF, 0);
        //System.out.println(view.getX() + "   " + view.getY());
        //        Toast.makeText(getApplicationContext(), view.getX() + "   " + view.getY(),
        //                Toast.LENGTH_SHORT).show();
        // 1 second duration
        scale.setDuration(mDuration);
        // Moving up
        //        Animation slideUp = new TranslateAnimation(view.getLeft(), view.getRight() + view.getX(),
        //                view.getTop(), view.getBottom() + view.getY());
        //        Animation slideUp = new TranslateAnimation(view.getLeft(), view.getLeft(),
        //             view.getTop(), view.getTop());
        // 1 second duration
        //  slideUp.setDuration(1000);
        // Animation set to join both scaling and moving
        final AnimationSet animSet = new AnimationSet(true);
        animSet.setFillEnabled(true);
        animSet.setFillAfter(true);

        animSet.addAnimation(scale);
        //  animSet.addAnimation(slideUp);
        // Launching animation set
        view.startAnimation(animSet);

    }

    public void animToLB(View view) {
        view.bringToFront();
        Animation scale = new ScaleAnimation(1.0f, 2.9f, 1.0f, 2.9f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);

        //System.out.println(view.getX() + "   " + view.getY());
        //        Toast.makeText(getApplicationContext(), view.getX() + "   " + view.getY(),
        //                Toast.LENGTH_SHORT).show();
        // 1 second duration
        scale.setDuration(mDuration);
        // Moving up
        //        Animation slideUp = new TranslateAnimation(view.getLeft(), view.getRight() + view.getX(),
        //                view.getTop(), view.getBottom() + view.getY());
        //        Animation slideUp = new TranslateAnimation(view.getLeft(), view.getLeft(),
        //             view.getTop(), view.getTop());
        // 1 second duration
        //  slideUp.setDuration(1000);
        // Animation set to join both scaling and moving
        final AnimationSet animSet = new AnimationSet(true);
        animSet.setFillEnabled(true);
        animSet.setFillAfter(true);

        animSet.addAnimation(scale);
        //  animSet.addAnimation(slideUp);
        // Launching animation set
        view.startAnimation(animSet);
    }

    public void animToRT(View view) {
        view.bringToFront();
        Animation scale = new ScaleAnimation(1.0f, 2.9f, 1.0f, 2.9f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 1.0f);

        //System.out.println(view.getX() + "   " + view.getY());
        //        Toast.makeText(getApplicationContext(), view.getX() + "   " + view.getY(),
        //                Toast.LENGTH_SHORT).show();
        // 1 second duration
        scale.setDuration(mDuration);
        // Moving up
        //        Animation slideUp = new TranslateAnimation(view.getLeft(), view.getRight() + view.getX(),
        //                view.getTop(), view.getBottom() + view.getY());
        //        Animation slideUp = new TranslateAnimation(view.getLeft(), view.getLeft(),
        //             view.getTop(), view.getTop());
        // 1 second duration
        //  slideUp.setDuration(1000);
        // Animation set to join both scaling and moving
        final AnimationSet animSet = new AnimationSet(true);
        animSet.setFillEnabled(true);
        animSet.addAnimation(scale);
        animSet.setFillAfter(true);
        //  animSet.addAnimation(slideUp);
        // Launching animation set
        view.startAnimation(animSet);
    }

    public void animToLT(View view) {
        view.bringToFront();
        Animation scale = new ScaleAnimation(1.0f, 2.9f, 1.0f, 2.9f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 1.0f);

        //System.out.println(view.getX() + "   " + view.getY());
        // Toast.makeText(getApplicationContext(), view.getX() + "   " + view.getY(),
        //         Toast.LENGTH_SHORT).show();
        // 1 second duration
        scale.setDuration(mDuration);
        // Moving up
        //        Animation slideUp = new TranslateAnimation(view.getLeft(), view.getRight() + view.getX(),
        //                view.getTop(), view.getBottom() + view.getY());
        //        Animation slideUp = new TranslateAnimation(view.getLeft(), view.getLeft(),
        //             view.getTop(), view.getTop());
        // 1 second duration
        //  slideUp.setDuration(1000);
        // Animation set to join both scaling and moving
        final AnimationSet animSet = new AnimationSet(true);
        animSet.setFillEnabled(true);
        animSet.addAnimation(scale);
        //  animSet.addAnimation(slideUp);
        animSet.setFillAfter(true);
        // Launching animation set
        view.startAnimation(animSet);
    }

    public void animBig(final View view) {
        view.bringToFront();
        Animation scale = new ScaleAnimation(1.0f, 0.3f, 1.0f, 0.3f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        //System.out.println(view.getX() + "   " + view.getY());
        // Toast.makeText(getApplicationContext(), view.getX() + "   " + view.getY(),
        //         Toast.LENGTH_SHORT).show();
        // 1 second duration
        scale.setDuration(mDuration);
        // Moving up
        //        Animation slideUp = new TranslateAnimation(view.getLeft(), view.getRight() + view.getX(),
        //                view.getTop(), view.getBottom() + view.getY());
        //        Animation slideUp = new TranslateAnimation(view.getLeft(), view.getLeft(),
        //             view.getTop(), view.getTop());
        // 1 second duration
        //  slideUp.setDuration(1000);
        // Animation set to join both scaling and moving
        final AnimationSet animSet = new AnimationSet(true);
        animSet.setFillEnabled(true);
        animSet.addAnimation(scale);
        //  animSet.addAnimation(slideUp);
        animSet.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                mUiBigOne.setVisibility(View.INVISIBLE);

            }
        });

        // animSet.setFillAfter(true);
        // Launching animation set
        view.startAnimation(animSet);
    }
}
