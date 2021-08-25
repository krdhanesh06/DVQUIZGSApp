package com.example.dvquizgsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class L5R extends AppCompatActivity {
    TextView tv, tv2, tv3,tvCorrect, tvWrong, tvFinal;
    TextView dispName, dispMobile;
    Button btnRetest,btnFeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l5_r);

        btnFeedback = (Button) findViewById(R.id.btnFeedback);
        btnRetest=(Button) findViewById(R.id.btnRetest);



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



        btnFeedback.setVisibility(View.INVISIBLE);
        btnRetest.setVisibility(View.INVISIBLE);




        tv = (TextView)findViewById(R.id.tvres);
        tv2 = (TextView)findViewById(R.id.tvres2);
        tv3 = (TextView)findViewById(R.id.tvres3);



        tvCorrect = (TextView)findViewById(R.id.tvCorrect);
        tvWrong = (TextView)findViewById(R.id.tvWrong);
        tvFinal = (TextView)findViewById(R.id.tvFinal);



        StringBuffer sb = new StringBuffer();
        sb.append("" + L5Q.correct + "\n");
        StringBuffer sb2 = new StringBuffer();
        sb2.append("" + L5Q.wrong + "\n");
        StringBuffer sb3 = new StringBuffer();
        sb3.append("" + L5Q.correct + "\n");

        tv.setText(sb);
        tv2.setText(sb2);
        tv3.setText(sb3);



        if(L5Q.correct>=6){
            Toast.makeText(this,"Excellent! \n You Cleared Level Fifth.", Toast.LENGTH_LONG).show();
            btnFeedback.setVisibility(View.VISIBLE);

        }
        else {
            Toast.makeText(this, "Oops! \n You Couldn't Clear Level Fifth.", Toast.LENGTH_LONG).show();
            btnRetest.setVisibility(View.VISIBLE);
        }

        L5Q.correct=0;
        L5Q.wrong=0;
    }


    public void btnRetest(View view) {
        String name = dispName.getText().toString();
        String mobile = dispMobile.getText().toString();
        Intent intent = new Intent(getApplicationContext(),L5V.class);
        intent.putExtra("name", name);
        intent.putExtra("mobile", mobile);
        startActivity(intent);
    }


    public void Feedback(View view) {

        String name = dispName.getText().toString();
        String mobile = dispMobile.getText().toString();
        String marks5 = tv3.getText().toString();
        Intent intent = new Intent(getApplicationContext(),Feedback5.class);
        intent.putExtra("name", name);
        intent.putExtra("mobile", mobile);
        intent.putExtra("marks5", marks5);
        startActivity(intent);
    }


}