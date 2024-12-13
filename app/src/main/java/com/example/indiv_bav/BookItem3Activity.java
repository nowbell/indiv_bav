package com.example.indiv_bav;

import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class BookItem3Activity extends AppCompatActivity {
    Button back_btn;

    MediaPlayer audio_player;
    Button play_btn, pause_btn, stop_btn;
    SeekBar volumeController;
    AudioManager audioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book3);

        back_btn = findViewById(R.id.book3_back_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent get_back = new Intent(BookItem3Activity.this, MainActivity.class);
                startActivity(get_back);
            }
        });

        audio_player = MediaPlayer.create(this, R.raw.audio3);
        audio_player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stopPlay();
            }
        });

        play_btn = findViewById(R.id.play_btn);
        pause_btn = findViewById(R.id.pause_btn);
        stop_btn = findViewById(R.id.stop_btn);

        pause_btn.setEnabled(false);
        stop_btn.setEnabled(false);

        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curValue = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        volumeController = findViewById(R.id.volumeController);
        volumeController.setMax(maxVolume);
        volumeController.setProgress(curValue);
        volumeController.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, progress, 0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void stopPlay() {
        audio_player.stop();
        pause_btn.setEnabled(false);
        stop_btn.setEnabled(false);
        try {
            audio_player.prepare();
            audio_player.seekTo(0);
            play_btn.setEnabled(true);
        }
        catch (Throwable t) {
            Toast.makeText(this, t.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void play(View view) {
        audio_player.start();
        play_btn.setEnabled(false);
        pause_btn.setEnabled(true);
        stop_btn.setEnabled(true);
    }

    public void pause(View view) {
        audio_player.pause();
        play_btn.setEnabled(true);
        pause_btn.setEnabled(false);
        stop_btn.setEnabled(true);
    }

    public void stop(View view) {
        stopPlay();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (audio_player.isPlaying()) {
            stopPlay();
        }
    }
}