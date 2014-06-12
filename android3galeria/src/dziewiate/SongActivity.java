
package dziewiate;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android3galeria.R;

import java.io.IOException;

public class SongActivity extends Activity {

    int extrasInt;
    ImageView mUiAlbum;
    TextView mUiPause;
    TextView mUiStop;
    TextView mUiPlay;
    Button mUiMenu;

    public int[] zdjecia = {
            R.drawable.donatan, R.drawable.ellie, R.drawable.lp, R.drawable.script,
            R.drawable.lonely
    };

    MediaPlayer mediaPlayer;

    static final int[] songs = {
            R.raw.donatan, R.raw.ellie, R.raw.lp, R.raw.script, R.raw.lonely
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        extrasInt = getIntent().getIntExtra("song", 0);

        mediaPlayer = mediaPlayer.create(this, songs[extrasInt]);
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 20, 0);
        try {
            mediaPlayer.prepare();
        } catch (IllegalStateException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        init();
    }

    public void init() {
        mUiAlbum = (ImageView) findViewById(R.id.song_iv);
        mUiPause = (TextView) findViewById(R.id.song_pause);
        mUiStop = (TextView) findViewById(R.id.song_stop);
        mUiPlay = (TextView) findViewById(R.id.song_start);
        mUiMenu = (Button) findViewById(R.id.menu_bt);
        mUiAlbum.setImageResource(zdjecia[extrasInt]);
        //mUiAlbum.setImageDrawable(this.getResources().getDrawable(zdjecia[extrasInt]));
        mUiPlay.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                mediaPlayer.start();

            }
        });
        mUiPause.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            }
        });
        mUiStop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                }
            }
        });
        mUiMenu.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                mediaPlayer.reset();
                mediaPlayer.release();
                finish();
            }
        });

    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        super.onBackPressed();
    }
}
