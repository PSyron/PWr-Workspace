
package dziewiate;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android3galeria.R;

public class ScrollSec9Activity extends FragmentActivity {

    int extrasInt;
    ViewPager mPager;
    ScrollTest9FragmentAdapter mAdapter;
    Button mUiButton;
    int mPage;
    private ImageView zdjecie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);
        extrasInt = getIntent().getIntExtra("position", 0);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        mPage = getIntent().getIntExtra("page", -1);

        actionBar.setTitle("wstecz");
        mUiButton = (Button) findViewById(R.id.sliding_button);
        mUiButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });
        mAdapter = new ScrollTest9FragmentAdapter(getSupportFragmentManager(), extrasInt);

        mPager = (ViewPager) findViewById(R.id.sliding_pager);

        mPager.setAdapter(mAdapter);
        mPager.setCurrentItem(mPage);
        mPager.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                animBig(v);

            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    public void skalowanie(View v) {
        zdjecie = (ImageView) v;

        if (zdjecie.getAnimation() == null) {
            ScaleAnimation anim = new ScaleAnimation(1f, 1.2f, 1.f, 1.2f, v.getWidth() / 2,
                    v.getHeight() / 2);
            anim.setDuration(2000);
            anim.setAnimationListener(new AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    ScaleAnimation anim = new ScaleAnimation(1.2f, 1.2f, 1.2f, 1.2f, zdjecie
                            .getWidth() / 2, zdjecie.getHeight() / 2);
                    anim.setRepeatCount(ScaleAnimation.INFINITE);
                    zdjecie.startAnimation(anim);

                }
            });
            v.startAnimation(anim);
        }

        else {
            zdjecie.clearAnimation();
        }
    }

    public void animBig(final View view) {
        Log.e("fragment", "click");
        view.bringToFront();
        Animation scale = new ScaleAnimation(1.0f, 1.3f, 1.0f, 1.3f, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);

        scale.setDuration(2000);

        final AnimationSet animSet = new AnimationSet(true);
        animSet.setFillEnabled(true);
        animSet.addAnimation(scale);
        //  animSet.addAnimation(slideUp);

        // animSet.setFillAfter(true);
        // Launching animation set
        view.startAnimation(animSet);
    }

}
