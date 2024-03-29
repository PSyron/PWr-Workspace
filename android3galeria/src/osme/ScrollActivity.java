
package osme;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.android3galeria.R;

public class ScrollActivity extends Activity {
    MyGrid mUiFirstGrid;
    MyGrid mUiSecondGrid;
    MyGrid mUithirdGrid;
    FirstGridAdapter mFirstAdapter;
    SecondGridAdapter mSecondAdapter;
    ThirdGridAdapter mThirdAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Zadanie 8");

        mUiFirstGrid = (MyGrid) findViewById(R.id.scroll_first_grid);
        mUiSecondGrid = (MyGrid) findViewById(R.id.scroll_second_grid);
        mUithirdGrid = (MyGrid) findViewById(R.id.scroll_third_grid);

        mUiFirstGrid.setExpanded(true);
        mUiSecondGrid.setExpanded(true);
        mUithirdGrid.setExpanded(true);

        mFirstAdapter = new FirstGridAdapter(this);
        mSecondAdapter = new SecondGridAdapter(this);
        mThirdAdapter = new ThirdGridAdapter(this);

        mUiFirstGrid.setAdapter(mFirstAdapter);
        mUiSecondGrid.setAdapter(mSecondAdapter);
        mUithirdGrid.setAdapter(mThirdAdapter);

        mUiFirstGrid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), ScrollSecActivity.class);
                intent.putExtra("page", position);
                intent.putExtra("position", 1);
                startActivity(intent);

            }
        });

        mUiSecondGrid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), ScrollSecActivity.class);
                intent.putExtra("page", position);
                intent.putExtra("position", 2);
                startActivity(intent);

            }
        });

        mUithirdGrid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent intent = new Intent(view.getContext(), ScrollSecActivity.class);
                intent.putExtra("page", position);
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
