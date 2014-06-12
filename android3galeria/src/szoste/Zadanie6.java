
package szoste;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android3galeria.R;

public class Zadanie6 extends Activity {

    TextView mUiButton;
    ImageView mUiPierwsze;
    ImageView mUiDrugie;
    ImageView mUiTrzecie;
    TextView mUiTytul;

    private SharedPreferences preferences;
    public static final String MY_PREFERENCES = "myPreferences";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_szoste);
        preferences = getSharedPreferences(MY_PREFERENCES, Activity.MODE_PRIVATE);
        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Zadanie 6 - Test");
        mUiPierwsze = (ImageView) findViewById(R.id.pierwsze);
        mUiDrugie = (ImageView) findViewById(R.id.drugie);
        mUiTrzecie = (ImageView) findViewById(R.id.trzecie);
        mUiButton = (TextView) findViewById(R.id.button_szosty);
        mUiTytul = (TextView) findViewById(R.id.tytul);
        mUiButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), Pytania.class);
                startActivity(intent);

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
        int niemamPomysluNaNazwe = preferences.getInt("third", 0);
        boolean poAnalizie = preferences.getBoolean("poAnalizie", false);
        if (niemamPomysluNaNazwe == 0 && !poAnalizie) {
            mUiButton.setText("Rozpocznij \nTEST");
            mUiPierwsze.setImageResource(R.drawable.piate1);
            mUiDrugie.setImageResource(R.drawable.piate2);
            mUiTrzecie.setImageResource(R.drawable.piate3);
            mUiTytul.setText("Super samochody \n TEST");
        } else if (niemamPomysluNaNazwe != 0 && !poAnalizie) {
            mUiButton.setText("ROZPOCZNIJ \nANALIZĘ");

            mUiTytul.setText("Super samochody \n TEST");
            mUiPierwsze.setImageResource(R.drawable.piate1);
            mUiDrugie.setImageResource(R.drawable.piate2);
            mUiTrzecie.setImageResource(R.drawable.piate3);
        } else if (niemamPomysluNaNazwe == 0 && poAnalizie) {
            mUiTytul.setText("Muzyka \n TEST");
            mUiButton.setText("Rozpocznij \n drugi TEST");
            mUiPierwsze.setImageResource(R.drawable.ellie);
            mUiDrugie.setImageResource(R.drawable.donatan);
            mUiTrzecie.setImageResource(R.drawable.lp);
        } else if (niemamPomysluNaNazwe != 0 && poAnalizie) {
            mUiButton.setText("Rozpocznij \n druga ANALIZĘ");
            mUiTytul.setText("Muzyka \n TEST");
            mUiPierwsze.setImageResource(R.drawable.ellie);
            mUiDrugie.setImageResource(R.drawable.donatan);
            mUiTrzecie.setImageResource(R.drawable.lp);
        }

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
