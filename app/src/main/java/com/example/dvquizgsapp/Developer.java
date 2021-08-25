package com.example.dvquizgsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Developer extends AppCompatActivity {
    TextView tv1, tv2, tv3, tv4;
    ImageView iv;
    ImageButton back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);


        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        tv3 = (TextView)findViewById(R.id.tv3);
        tv4 = (TextView)findViewById(R.id.tv4);


        iv = (ImageView)findViewById(R.id.iv);

        back = (ImageButton)findViewById(R.id.back);

    }
    public void Dev_Main(View view) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
