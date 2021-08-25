package com.example.dvquizgsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1;
    ImageView iv1, iv2;
    ImageButton start, developer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.tv1);

        iv1 = (ImageView)findViewById(R.id.iv1);
        iv2 = (ImageView)findViewById(R.id.iv2);

        start = (ImageButton)findViewById(R.id.start);
        developer = (ImageButton)findViewById(R.id.developer);
    }
    public void Main_AddUser(View view) {
        Intent i = new Intent(this, AddUser.class);
        startActivity(i);
    }
    public void Main_developer(View view) {
        Intent j = new Intent(this, Developer.class);
        startActivity(j);
    }
}
