
package dziewiate;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import com.example.android3galeria.R;

public class SongActivity extends Activity {

    int extrasInt;
    ImageView mUiAlbum;
    Button mUiPause;
    Button mUiStop;
    Button mUiPlay;

    public int[] zdjecia = {
            R.drawable.donatan, R.drawable.ellie, R.drawable.lp, R.drawable.script,
            R.drawable.lonely
    };

    MediaPlayer mediaPlayer;

    static final String[] songs = {
            "donatan", "ellie", "lp", "script", "lonely"
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        extrasInt = getIntent().getIntExtra("song", 0);
        init();
    }

    public void init() {
        mUiAlbum = (ImageView) findViewById(R.id.song_iv);
        mUiPause = (Button) findViewById(R.id.song_pause);
        mUiStop = (Button) findViewById(R.id.song_stop);
        mUiPlay = (Button) findViewById(R.id.song_start);
        mediaPlayer = new MediaPlayer();

        //  mUiAlbum.setImageResource(zdjecia[extrasInt]);
        mUiAlbum.setImageDrawable(this.getResources().getDrawable(zdjecia[extrasInt]));
        //        mUiPlay.setOnClickListener(new OnClickListener() {
        //
        //            @Override
        //            public void onClick(View v) {
        //                int resID = getResources().getIdentifier(songs[extrasInt], "raw", getPackageName());
        //
        //                mediaPlayer = MediaPlayer.create(getApplicationContext(), resID);
        //                mediaPlayer.start();
        //
        //            }
        //        });
    }
}
