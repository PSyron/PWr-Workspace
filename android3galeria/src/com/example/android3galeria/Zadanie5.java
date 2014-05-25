
package com.example.android3galeria;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
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

    public OnTouchListener imgClk = new OnTouchListener() {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    pressed = true;
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

                    return true; // if you want to handle the touch event
                case MotionEvent.ACTION_UP:
                    pressed = false;
                    return true; // if you want to handle the touch event

            }
            return false;
        }
    };

    public OnClickListener imgOneClick = new OnClickListener() {

        @Override
        public void onClick(View v) {
            mUiBigOne.setVisibility(View.VISIBLE);

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
        mUiPierwsze.setOnTouchListener(imgClk);
        mUiPierwsze.setOnClickListener(imgOneClick);
        mUiDrugie = (ImageView) findViewById(R.id.image_2);
        mUiDrugie.setOnTouchListener(imgClk);
        mUiTrzecie = (ImageView) findViewById(R.id.image_3);
        mUiTrzecie.setOnTouchListener(imgClk);
        mUiCzwarte = (ImageView) findViewById(R.id.image_4);
        mUiCzwarte.setOnTouchListener(imgClk);
        mUiPiate = (ImageView) findViewById(R.id.image_5);
        mUiPiate.setOnTouchListener(imgClk);
        mUiSzoste = (ImageView) findViewById(R.id.image_6);
        mUiSzoste.setOnTouchListener(imgClk);
        mUiSiodme = (ImageView) findViewById(R.id.image_7);
        mUiSiodme.setOnTouchListener(imgClk);
        mUiOsme = (ImageView) findViewById(R.id.image_8);
        mUiOsme.setOnTouchListener(imgClk);
        mUiDziewiate = (ImageView) findViewById(R.id.image_9);
        mUiDziewiate.setOnTouchListener(imgClk);
        mUiDziesiate = (ImageView) findViewById(R.id.image_10);
        mUiDziesiate.setOnTouchListener(imgClk);
        mUiJedynaste = (ImageView) findViewById(R.id.image_11);
        mUiJedynaste.setOnTouchListener(imgClk);
        mUiDwunaste = (ImageView) findViewById(R.id.image_12);
        mUiDwunaste.setOnTouchListener(imgClk);
        mUiTrzynaste = (ImageView) findViewById(R.id.image_13);
        mUiTrzynaste.setOnTouchListener(imgClk);
        mUiCzternaste = (ImageView) findViewById(R.id.image_14);
        mUiCzternaste.setOnTouchListener(imgClk);
        mUiPietnaste = (ImageView) findViewById(R.id.image_15);
        mUiPietnaste.setOnTouchListener(imgClk);
        mUiSzesnaste = (ImageView) findViewById(R.id.image_16);
        mUiSzesnaste.setOnTouchListener(imgClk);
        mUiBigOne = (ImageView) findViewById(R.id.big_picture);
        mUiBigOne.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                animBig(v);
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
                if (pressed == true) {
                    animSet.start();
                }

            }
        });
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
                if (pressed == true) {
                    animSet.start();
                }

            }
        });
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
                if (pressed == true) {
                    animSet.start();
                }

            }
        });
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
                if (pressed == true) {
                    animSet.start();
                }

            }
        });
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
        AnimationSet animSet = new AnimationSet(true);
        animSet.setFillEnabled(true);
        animSet.addAnimation(scale);
        //  animSet.addAnimation(slideUp);

        animSet.setAnimationListener(new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                view.setVisibility(View.INVISIBLE);

            }
        });
        // Launching animation set
        view.startAnimation(animSet);
    }
}
