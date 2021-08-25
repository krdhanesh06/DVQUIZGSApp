package com.example.dvquizgsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class QuizLevels extends AppCompatActivity {
    TextView dispName, dispMobile;
    RadioButton rdblbl1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_levels);


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


        rdblbl1 = (RadioButton) findViewById(R.id.rdblbl1);

    }

    public void onRadioButtonClicked(View view) {
        Toast.makeText(getApplicationContext(), "Quiz Level First Video", Toast.LENGTH_SHORT).show();
        String name = dispName.getText().toString();
        String mobile = dispMobile.getText().toString();
        Intent intent = new Intent(this, L1V.class);
        intent.putExtra("name", name);
        intent.putExtra("mobile", mobile);
        startActivity(intent);
    }

}
