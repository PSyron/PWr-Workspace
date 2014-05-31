
package szoste;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import com.example.android3galeria.R;

public class Zadanie6 extends Activity {

    TextView mUiButton;

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
        mUiButton = (TextView) findViewById(R.id.button_szosty);

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
        if (niemamPomysluNaNazwe == 0) {
            mUiButton.setText("Rozpocznij \nTEST");
        } else {
            mUiButton.setText("ROZPOCZNIJ \nANALIZĘ");
        }

    }
}
