package com.example.kid_rhymes;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    AppCompatButton buttonOne, buttonTwo, buttonThree, buttonFour, buttonFive, buttonSix, buttonSeven, buttonEight, buttonNine;
    ImageView iv_stop;
    private MediaPlayer mediaPlayer;
    Boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonOne = findViewById(R.id.button_one);
        buttonTwo = findViewById(R.id.button_two);
        buttonThree = findViewById(R.id.button_three);
        buttonFour = findViewById(R.id.button_four);
        buttonFive = findViewById(R.id.button_five);
        buttonSix = findViewById(R.id.button_six);
        buttonSeven = findViewById(R.id.button_seven);
        buttonEight = findViewById(R.id.button_eight);
        buttonNine = findViewById(R.id.button_nine);
        iv_stop = findViewById(R.id.iv_stop);

       /* iv_stop.setOnClickListener(v -> {
            throw new RuntimeException("Test Crash"); // Force a crash
        });*/
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(R.raw.baa_baa_black_sheep);
            }
        });

        buttonTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(R.raw.big_ship_sails);
            }
        });

        buttonThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(R.raw.fish_alive);
            }
        });

        buttonFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(R.raw.five_little_monkey);
            }
        });

        buttonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(R.raw.johny_johny);
            }
        });

        buttonSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(R.raw.humpty_dumpty_nursery);
            }
        });

        buttonSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(R.raw.mouse_children);
            }
        });

        buttonEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(R.raw.nick_nack_paddy_wack);
            }
        });

        buttonNine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playSong(R.raw.one_two_buckle_shoe);
            }
        });
        iv_stop.setOnClickListener(view -> {
            stopMedia(); // Stop the currently playing media immediately

            new Handler().postDelayed(() -> {
                MediaPlayer stopMediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.stop_sound);
                stopMediaPlayer.start();
                stopMediaPlayer.setOnCompletionListener(mp -> stopMediaPlayer.release());
            }, 0);
        });
    }

    private void playSong(int songId){
        if(isPlaying){
            stopMedia();
        }
        mediaPlayer = MediaPlayer.create(this,songId);
        mediaPlayer.start();
        isPlaying = true;
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
       stopMedia();
    }
    @Override
    protected void onPause() {
        super.onPause();
       stopMedia();
    }

    private void stopMedia() {
        if (mediaPlayer != null) {
            try {
                mediaPlayer.stop();
                mediaPlayer.release();
            } catch (IllegalStateException e) {
                e.printStackTrace(); // Handle the exception if needed
            } finally {
                mediaPlayer = null;
                isPlaying = false;
            }
        }
    }
}