package com.example.dvquizgsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.VideoView;
import java.util.Timer;


public class L5V extends AppCompatActivity {
    TextView dispName, dispMobile;
    VideoView videoView;
    Button skipVideo;
    ImageButton playVideo,pauseVideo;
    Timer timer;
    String video_url="https://firebasestorage.googleapis.com/v0/b/dvquizgsapp.appspot.com/o/dv.mp4?alt=media&token=3db2bd10-01ad-4653-b115-dd08b435a2f0";
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5_v);

        pauseVideo = (ImageButton) findViewById(R.id.pauseVideo);
        playVideo = (ImageButton) findViewById(R.id.playVideo);
        skipVideo = (Button) findViewById(R.id.skipVideo);
        videoView = (VideoView) findViewById(R.id.videoView);






        pd=new ProgressDialog(L5V.this);
        pd.setMessage("Buffering Video please wait");
        pd.show();
        Uri uri=Uri.parse(video_url);
        videoView.setVideoURI(uri);
        videoView.start();

        pauseVideo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                videoView.pause();
            }
        });
        playVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                videoView.start();
            }
        });

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                pd.dismiss();

            }
        });




        dispName = (TextView) findViewById(R.id.dispName);
        dispMobile = (TextView) findViewById(R.id.dispMobile);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        dispName.setText(name);
        dispName.setTextColor(Color.BLUE);
        dispName.setText("" + name);

        String mobile = intent.getStringExtra("mobile");
        dispMobile.setText(mobile);
        dispMobile.setTextColor(Color.BLUE);
        dispMobile.setText("" + mobile);


        skipVideo.setVisibility(View.INVISIBLE);



        timer = new Timer();
        skipVideo.postDelayed(new Runnable() {
            @Override
            public void run() {
                skipVideo.setVisibility(View.VISIBLE);
            }

        }, 1000);

        ////////1 * 60 * 1000);
    }


    public void skipVideo(View view) {
        timer.cancel();
        String name = dispName.getText().toString();
        String mobile = dispMobile.getText().toString();
        Intent k = new Intent(this, L5Q.class);
        k.putExtra("name", name);
        k.putExtra("mobile", mobile);
        startActivity(k);

    }
}
