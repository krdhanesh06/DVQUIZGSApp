package com.example.dvquizgsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Thanks extends AppCompatActivity {
    TextView dispName, dispMobile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanks);



        dispName= (TextView) findViewById(R.id.dispName);
        dispMobile= (TextView) findViewById(R.id.dispMobile);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        dispName.setText(name);
        dispName.setTextColor(Color.BLUE);
        dispName.setText(""+ name);


        String mobile = intent.getStringExtra("mobile");
        dispMobile.setText(mobile);
        dispMobile.setTextColor(Color.BLUE);
        dispMobile.setText(""+ mobile);

    }
    public void Logouttwo(View view) {
        Intent intent = new Intent(Thanks.this, MainActivity.class);
        startActivity(intent);
        Toast.makeText(Thanks.this,"Log Out Successfully \n Thank you!", Toast.LENGTH_LONG).show();
        finish();
    }

}
