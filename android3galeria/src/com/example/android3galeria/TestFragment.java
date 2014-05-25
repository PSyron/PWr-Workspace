
package com.example.android3galeria;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

public final class TestFragment extends Fragment {
    // private static final String KEY_CONTENT = "TestFragment:Content";
    private static final String KEY_CONTENT = "TestFragment:Content";

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
        ImageView image = new ImageView(getActivity());
        //        TextView text = new TextView(getActivity());
        //        text.setGravity(Gravity.CENTER);
        //        text.setText(mContent);
        //        text.setTextSize(20 * getResources().getDisplayMetrics().density);
        //        text.setPadding(20, 20, 20, 20);
        image.setBackgroundResource(mContent);
        image.setPadding(20, 20, 20, 20);

        LinearLayout layout = new LinearLayout(getActivity());
        //layout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
        //      LayoutParams.MATCH_PARENT));
        layout.setGravity(Gravity.CENTER);
        //   layout.addView(text);
        layout.setLayoutParams(new LayoutParams(400, 400));
        layout.addView(image);

        return layout;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //  outState.putString(KEY_CONTENT, mContent);
    }
}
