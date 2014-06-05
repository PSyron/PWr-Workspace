
package osme;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.android3galeria.R;

public class ScrollSecActivity extends FragmentActivity {

    int extrasInt;
    ViewPager mPager;
    ScrollTestFragmentAdapter mAdapter;
    Button mUiButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding);
        extrasInt = getIntent().getIntExtra("position", 0);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle("wstecz");
        mUiButton = (Button) findViewById(R.id.sliding_button);
        mUiButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();

            }
        });
        mAdapter = new ScrollTestFragmentAdapter(getSupportFragmentManager(), extrasInt);

        mPager = (ViewPager) findViewById(R.id.sliding_pager);
        mPager.setAdapter(mAdapter);
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
}
