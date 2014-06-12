
package com.example.android3galeria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public final class TestFragment extends Fragment {
    // private static final String KEY_CONTENT = "TestFragment:Content";
    private static final String KEY_CONTENT = "TestFragment:Content";
    ImageView image;

    public static TestFragment newInstance(int content) {
        TestFragment fragment = new TestFragment();

        fragment.mContent = content;

        return fragment;
    }

    private int mContent = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if ((savedInstanceState != null) && savedInstanceState.containsKey(KEY_CONTENT)) {
            //  mContent = savedInstanceState.getString(KEY_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        image = new ImageView(getActivity());
        //        TextView text = new TextView(getActivity());
        //        text.setGravity(Gravity.CENTER);
        //        text.setText(mContent);
        //        text.setTextSize(20 * getResources().getDisplayMetrics().density);
        //        text.setPadding(20, 20, 20, 20);
        image.setBackgroundResource(mContent);
        image.setPadding(20, 20, 20, 20);

        final LinearLayout layout = new LinearLayout(getActivity());
        //layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
        //      LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);
        //   layout.addView(text);
        layout.setLayoutParams(new LayoutParams(400, 400));
        layout.addView(image);
        //        layout.setOnClickListener(new OnClickListener() {
        //
        //            @Override
        //            public void onClick(View v) {
        //                animBig(layout);
        //
        //            }
        //        });

        return layout;
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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //  outState.putString(KEY_CONTENT, mContent);
    }
}
