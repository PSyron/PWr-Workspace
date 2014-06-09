
package dziewiate;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.android3galeria.R;

import osme.MyGrid;
import osme.ScrollSecActivity;

public class Scroll9Activity extends Activity {
    MyGrid mUiFirstGrid;
    MyGrid mUiSecondGrid;
    MyGrid mUithirdGrid;
    FirstGrid9Adapter mFirstAdapter;
    SecondGrid9Adapter mSecondAdapter;
    ThirdGrid9Adapter mThirdAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll9);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Zadanie 9");

        mUiFirstGrid = (MyGrid) findViewById(R.id.scroll_first_grid);
        mUiSecondGrid = (MyGrid) findViewById(R.id.scroll_second_grid);
        mUithirdGrid = (MyGrid) findViewById(R.id.scroll_third_grid);

        mUiFirstGrid.setExpanded(true);
        mUiSecondGrid.setExpanded(true);
        mUithirdGrid.setExpanded(true);

        mFirstAdapter = new FirstGrid9Adapter(this);
        mSecondAdapter = new SecondGrid9Adapter(this);
        mThirdAdapter = new ThirdGrid9Adapter(this);

        mUiFirstGrid.setAdapter(mFirstAdapter);
        mUiSecondGrid.setAdapter(mSecondAdapter);
        mUithirdGrid.setAdapter(mThirdAdapter);

        mUiFirstGrid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), ScrollSecActivity.class);
                intent.putExtra("position", 1);
                startActivity(intent);

            }
        });

        mUiSecondGrid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), SongActivity.class);
                intent.putExtra("song", position);
                startActivity(intent);

            }
        });

        mUithirdGrid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), ScrollSecActivity.class);
                intent.putExtra("position", 3);
                startActivity(intent);

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
}
