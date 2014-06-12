
package szoste;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android3galeria.R;

public class Pytania extends Activity {

    TextView mUiPytanieNumer;
    TextView mUiPytanieTresc;

    ImageView mUiObrazek;

    RelativeLayout mUiPierwsze;
    TextView mUiPierwszeOdp;
    TextView mUiPierwszePop;
    TextView mUiPierwszeWybr;

    RelativeLayout mUiDrugie;
    TextView mUiDrugieOdp;
    TextView mUiDrugiePop;
    TextView mUiDrugieWybr;

    RelativeLayout mUiTrzecie;
    TextView mUiTrzecieOdp;
    TextView mUiTrzeciePop;
    TextView mUiTrzecieWybr;

    TextView mUiProsba;
    TextView mUiNastepne;

    private SharedPreferences preferences;
    public static final String MY_PREFERENCES = "myPreferences";

    boolean poAnalizie;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pytanie);

        ActionBar actionBar = getActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("Zadanie 6 - Test");
        actionBar.hide();

        preferences = getSharedPreferences(MY_PREFERENCES, Activity.MODE_PRIVATE);
        poAnalizie = preferences.getBoolean("poAnalizie", false);
        initView();
        initPierwsze();
    }

    public void initView() {
        mUiPytanieNumer = (TextView) findViewById(R.id.pytanie_numer);
        mUiPytanieTresc = (TextView) findViewById(R.id.pytanie_tresc);

        mUiObrazek = (ImageView) findViewById(R.id.pytanie_obrazek);

        mUiPierwsze = (RelativeLayout) findViewById(R.id.pierwsze);
        mUiPierwszeOdp = (TextView) findViewById(R.id.pytanie_pierwsze_odpowiedz);
        mUiPierwszePop = (TextView) findViewById(R.id.pytanie_pierwsze_poprawna);
        mUiPierwszeWybr = (TextView) findViewById(R.id.pytanie_pierwsze_wybrana);

        mUiDrugie = (RelativeLayout) findViewById(R.id.drugie);
        mUiDrugieOdp = (TextView) findViewById(R.id.pytanie_drugie_odpowiedz);
        mUiDrugiePop = (TextView) findViewById(R.id.pytanie_drugie_poprawna);
        mUiDrugieWybr = (TextView) findViewById(R.id.pytanie_drugie_wybrana);

        mUiTrzecie = (RelativeLayout) findViewById(R.id.trzecie);
        mUiTrzecieOdp = (TextView) findViewById(R.id.pytanie_trzecie_odpowiedz);
        mUiTrzeciePop = (TextView) findViewById(R.id.pytanie_trzecie_poprawna);
        mUiTrzecieWybr = (TextView) findViewById(R.id.pytanie_trzecie_wybrana);

        mUiProsba = (TextView) findViewById(R.id.pytanie_prosba);
        mUiNastepne = (TextView) findViewById(R.id.pytanie_nastepne);
    }

    public void initPierwsze() {
        int odpowiedz = preferences.getInt("first", 0);
        mUiPytanieNumer.setText("Pytanie 1");

        mUiPierwszePop.setVisibility(View.INVISIBLE);
        mUiPierwszeWybr.setVisibility(View.INVISIBLE);

        mUiDrugiePop.setVisibility(View.INVISIBLE);
        mUiDrugieWybr.setVisibility(View.INVISIBLE);

        mUiTrzeciePop.setVisibility(View.INVISIBLE);
        mUiTrzecieWybr.setVisibility(View.INVISIBLE);
        if (!poAnalizie) {
            mUiPytanieTresc.setText("Jakiego koloru jest to Lambo?");
            mUiObrazek.setImageResource(R.drawable.piate13);

            mUiPierwszeOdp.setText("Czerwone");
            mUiDrugieOdp.setText("Pomaranczowe");
            mUiTrzecieOdp.setText("Zielone");
        } else {
            mUiPytanieTresc.setText("Którego albumu Ellie Goulding to jest okładka?");
            mUiObrazek.setImageResource(R.drawable.ellie);

            mUiPierwszeOdp.setText("Lights");
            mUiDrugieOdp.setText("Burn");
            mUiTrzecieOdp.setText("Halcyon");
        }

        if (odpowiedz == 0) {
            mUiProsba.setVisibility(View.VISIBLE);
            mUiNastepne.setVisibility(View.INVISIBLE);
            mUiPierwsze.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("first", 1);
                    preferencesEditor.commit();
                    initDrugie();
                }
            });
            mUiDrugie.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("first", 2);
                    preferencesEditor.commit();
                    initDrugie();
                }
            });
            mUiTrzecie.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("first", 3);
                    preferencesEditor.commit();
                    initDrugie();
                }
            });
        } else if (odpowiedz != 0) {
            if (!poAnalizie) {
                mUiProsba.setVisibility(View.INVISIBLE);
                mUiNastepne.setVisibility(View.VISIBLE);
                if (odpowiedz == 1) {
                    mUiPierwszeWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 2) {
                    mUiDrugieWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 3) {
                    mUiTrzecieWybr.setVisibility(View.VISIBLE);
                }
                mUiDrugiePop.setVisibility(View.VISIBLE);

                mUiNastepne.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor preferencesEditor = preferences.edit();
                        preferencesEditor.putInt("first", 0);
                        preferencesEditor.commit();
                        initDrugie();
                    }
                });
            } else {
                mUiProsba.setVisibility(View.INVISIBLE);
                mUiNastepne.setVisibility(View.VISIBLE);
                if (odpowiedz == 1) {
                    mUiPierwszeWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 2) {
                    mUiDrugieWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 3) {
                    mUiTrzecieWybr.setVisibility(View.VISIBLE);
                }
                mUiTrzeciePop.setVisibility(View.VISIBLE);

                mUiNastepne.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor preferencesEditor = preferences.edit();
                        preferencesEditor.putInt("first", 0);
                        preferencesEditor.commit();
                        initDrugie();
                    }
                });
            }
        }
    }

    void initDrugie() {
        int odpowiedz = preferences.getInt("second", 0);
        mUiPytanieNumer.setText("Pytanie 2");

        mUiPierwszePop.setVisibility(View.INVISIBLE);
        mUiPierwszeWybr.setVisibility(View.INVISIBLE);

        mUiDrugiePop.setVisibility(View.INVISIBLE);
        mUiDrugieWybr.setVisibility(View.INVISIBLE);

        mUiTrzeciePop.setVisibility(View.INVISIBLE);
        mUiTrzecieWybr.setVisibility(View.INVISIBLE);

        if (!poAnalizie) {
            mUiPytanieTresc.setText("Po której stronie stoi czarne auto?");
            mUiObrazek.setImageResource(R.drawable.piate5);
            mUiPierwszeOdp.setText("Nie stoi!");
            mUiDrugieOdp.setText("Po prawej");
            mUiTrzecieOdp.setText("Po lewej");
        } else {
            mUiPytanieTresc.setText("Kto nie brał udziału w tworzeniu płyty?");
            mUiObrazek.setImageResource(R.drawable.donatan);
            mUiPierwszeOdp.setText("Ich Troje");
            mUiDrugieOdp.setText("Chada");
            mUiTrzecieOdp.setText("TEDE");
        }

        if (odpowiedz == 0) {
            mUiProsba.setVisibility(View.VISIBLE);
            mUiNastepne.setVisibility(View.INVISIBLE);
            mUiPierwsze.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("second", 1);
                    preferencesEditor.commit();
                    initTrzecie();
                }
            });
            mUiDrugie.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("second", 2);
                    preferencesEditor.commit();
                    initTrzecie();
                }
            });
            mUiTrzecie.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("second", 3);
                    preferencesEditor.commit();
                    initTrzecie();
                }
            });
        } else if (odpowiedz != 0) {
            if (!poAnalizie) {
                mUiProsba.setVisibility(View.INVISIBLE);
                mUiNastepne.setVisibility(View.VISIBLE);
                if (odpowiedz == 1) {
                    mUiPierwszeWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 2) {
                    mUiDrugieWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 3) {
                    mUiTrzecieWybr.setVisibility(View.VISIBLE);
                }
                mUiTrzeciePop.setVisibility(View.VISIBLE);

                mUiNastepne.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor preferencesEditor = preferences.edit();
                        preferencesEditor.putInt("second", 0);
                        preferencesEditor.commit();
                        initTrzecie();
                    }
                });
            } else {
                mUiProsba.setVisibility(View.INVISIBLE);
                mUiNastepne.setVisibility(View.VISIBLE);
                if (odpowiedz == 1) {
                    mUiPierwszeWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 2) {
                    mUiDrugieWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 3) {
                    mUiTrzecieWybr.setVisibility(View.VISIBLE);
                }
                mUiPierwszePop.setVisibility(View.VISIBLE);

                mUiNastepne.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor preferencesEditor = preferences.edit();
                        preferencesEditor.putInt("second", 0);
                        preferencesEditor.commit();
                        initTrzecie();
                    }
                });
            }
        }
    }

    public void initTrzecie() {
        int odpowiedz = preferences.getInt("third", 0);
        mUiPytanieNumer.setText("Pytanie 3");

        mUiPierwszePop.setVisibility(View.INVISIBLE);
        mUiPierwszeWybr.setVisibility(View.INVISIBLE);

        mUiDrugiePop.setVisibility(View.INVISIBLE);
        mUiDrugieWybr.setVisibility(View.INVISIBLE);

        mUiTrzeciePop.setVisibility(View.INVISIBLE);
        mUiTrzecieWybr.setVisibility(View.INVISIBLE);

        if (!poAnalizie) {
            mUiPytanieTresc.setText("Jaki to model Lambo?");
            mUiObrazek.setImageResource(R.drawable.piate14);
            mUiPierwszeOdp.setText("Aventador");
            mUiDrugieOdp.setText("Diablo");
            mUiTrzecieOdp.setText("Nie wiem");
        } else {
            mUiPytanieTresc.setText("Kto był wokalistą Linkin Park na tej płycie?");
            mUiObrazek.setImageResource(R.drawable.lp);
            mUiPierwszeOdp.setText("Doda");
            mUiDrugieOdp.setText("Chester Bennington");
            mUiTrzecieOdp.setText("Nie było wokalisty");
        }

        if (odpowiedz == 0) {
            mUiProsba.setVisibility(View.VISIBLE);
            mUiNastepne.setVisibility(View.INVISIBLE);
            mUiPierwsze.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("third", 1);
                    preferencesEditor.commit();
                    finish();
                }
            });
            mUiDrugie.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("third", 2);
                    preferencesEditor.commit();
                    finish();
                }
            });
            mUiTrzecie.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor preferencesEditor = preferences.edit();
                    preferencesEditor.putInt("third", 3);
                    preferencesEditor.putBoolean("poAnalizie", false);
                    preferencesEditor.commit();
                    finish();
                }
            });
        } else if (odpowiedz != 0) {
            if (!poAnalizie) {
                mUiProsba.setVisibility(View.INVISIBLE);
                mUiNastepne.setVisibility(View.VISIBLE);
                if (odpowiedz == 1) {
                    mUiPierwszeWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 2) {
                    mUiDrugieWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 3) {
                    mUiTrzecieWybr.setVisibility(View.VISIBLE);
                }
                mUiPierwszePop.setVisibility(View.VISIBLE);

                mUiNastepne.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor preferencesEditor = preferences.edit();
                        preferencesEditor.putInt("third", 0);
                        preferencesEditor.putBoolean("poAnalizie", true);
                        preferencesEditor.commit();
                        finish();
                    }
                });
            } else {
                mUiProsba.setVisibility(View.INVISIBLE);
                mUiNastepne.setVisibility(View.VISIBLE);
                if (odpowiedz == 1) {
                    mUiPierwszeWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 2) {
                    mUiDrugieWybr.setVisibility(View.VISIBLE);
                } else if (odpowiedz == 3) {
                    mUiTrzecieWybr.setVisibility(View.VISIBLE);
                }
                mUiDrugiePop.setVisibility(View.VISIBLE);

                mUiNastepne.setOnClickListener(new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        SharedPreferences.Editor preferencesEditor = preferences.edit();
                        preferencesEditor.putInt("third", 0);
                        preferencesEditor.putBoolean("poAnalizie", false);
                        preferencesEditor.commit();
                        finish();
                    }
                });
            }
        }
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Zabijanie aktywność na BACK jest wyłączone",
                Toast.LENGTH_LONG).show();
    }

}
