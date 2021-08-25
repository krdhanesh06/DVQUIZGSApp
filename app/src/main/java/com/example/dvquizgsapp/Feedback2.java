package com.example.dvquizgsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.speech.RecognitionListener;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.telephony.SmsManager;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.RetryPolicy;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Feedback2 extends AppCompatActivity {

    TextView dispName, dispMobile,dispMarks2;
    EditText message;
    ImageButton sendsms, btnlgt;
    SpeechRecognizer mSpeechRecognizer;
    Intent mSpeechRecognizerIntent;
    TextToSpeech myTTS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback2);



        message=(EditText)findViewById(R.id.message);
        sendsms=(ImageButton)findViewById(R.id.sendsms);
        btnlgt=(ImageButton)findViewById(R.id.btnlgt);


        dispName= (TextView) findViewById(R.id.dispName);
        dispMobile= (TextView) findViewById(R.id.dispMobile);


        dispMarks2= (TextView) findViewById(R.id.dispMarks2);


        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        dispName.setText(name);
        dispName.setTextColor(Color.BLUE);
        dispName.setText(""+name);

        String mobile = intent.getStringExtra("mobile");
        dispMobile.setText(mobile);
        dispMobile.setTextColor(Color.BLUE);
        dispMobile.setText(""+mobile);



        String marks2 = intent.getStringExtra("marks2");
        dispMarks2.setText(marks2);
        dispMarks2.setTextColor(Color.BLUE);
        dispMarks2.setText("Second Level Marks= "+marks2);







        initializeTextToSpeech();
        checkpermission();
        message = findViewById(R.id.message);
        mSpeechRecognizer = SpeechRecognizer.createSpeechRecognizer(this);
        mSpeechRecognizerIntent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        mSpeechRecognizerIntent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        mSpeechRecognizer.setRecognitionListener(new RecognitionListener() {
            @Override
            public void onReadyForSpeech(Bundle params) {
            }
            @Override
            public void onBeginningOfSpeech() {
            }
            @Override
            public void onRmsChanged(float rmsdB) {
            }
            @Override
            public void onBufferReceived(byte[] buffer) {
            }
            @Override
            public void onEndOfSpeech() {
            }
            @Override
            public void onError(int error) {
            }
            @Override
            public void onResults(Bundle bundle) {
                ArrayList<String> matches = bundle.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION);
                if (matches != null){
                    message.setText(matches.get(0));
                }
            }
            @Override
            public void onPartialResults(Bundle partialResults) {
            }
            @Override
            public void onEvent(int eventType, Bundle params) {
            }
        });
        findViewById(R.id.button5).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_UP:
                        mSpeechRecognizer.stopListening();
                        message.setHint("You will see inputs here...");
                        break;
                    case MotionEvent.ACTION_DOWN:
                        message.setText("");
                        message.setHint("Listening...");
                        mSpeechRecognizer.startListening(mSpeechRecognizerIntent);
                        break;
                }
                return false;
            }
        });
    }
    private void initializeTextToSpeech() {
        myTTS = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (myTTS.getEngines().size() == 0) {
                    Toast.makeText(Feedback2.this, "There is no TTS engine on your device", Toast.LENGTH_LONG).show();
                    finish();
                } else {
                    myTTS.setLanguage(new Locale("hi"));
                    //myTTS.setLanguage(Locale.US);
                    myTTS.setSpeechRate(0.9f);
                    speak("यहां बोलकर भी लिख सकते हैं");
                }
            }
        });
    }
    private void speak(String message) {
        if (Build.VERSION.SDK_INT >= 21) {
            myTTS.speak(message, TextToSpeech.QUEUE_FLUSH, null, null);
        } else {
            myTTS.speak(message, TextToSpeech.QUEUE_FLUSH, null);
        }

    }
    private void checkpermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (!(ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO)== PackageManager.PERMISSION_GRANTED)){
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:" + getPackageName()));
                startActivity(intent);
                finish();
            }
        }
    }




    public void Logout(View view) {
        speak(" ");
        Intent dkp = new Intent(Feedback2.this, Thanks.class);
        startActivity(dkp);
        Toast.makeText(Feedback2.this,"Log Out Successfully \n Thank you!", Toast.LENGTH_LONG).show();
        finish();
    }



    public void sendsms(View view) {
        String msg=message.getText().toString();
        if(TextUtils.isEmpty(msg)){
            Toast.makeText(getApplicationContext(), "Feedback is Required.",Toast.LENGTH_LONG).show();
            message.setError("Feedback is Required.");
            return;
        }
        if(message.length()<50){
            Toast.makeText(getApplicationContext(), "Write atleast 50 Letters.",Toast.LENGTH_LONG).show();
            message.setError("Write atleast 50 Letters.");
            return;
        }

        Intent intent=new Intent(getApplicationContext(), L3V.class);
        String name = dispName.getText().toString();
        String mobile = dispMobile.getText().toString();
        intent.putExtra("name", name);
        intent.putExtra("mobile", mobile);
        startActivity(intent);


        PendingIntent pi=PendingIntent.getActivity(getApplicationContext(), 0, intent,0);
        SmsManager sms= SmsManager.getDefault();
        sms.sendTextMessage("7563015402", null, msg, pi,null);
        Toast.makeText(getApplicationContext(), "Message Sent",Toast.LENGTH_LONG).show();
        addUsersToSheet();

    }

    private void addUsersToSheet() {
        final ProgressDialog loading = ProgressDialog.show(this,"Adding Feedback...","Please wait.");
        final String name = dispName.getText().toString().trim();
        final String mobile = dispMobile.getText().toString().trim();
        final String tmarks = dispMarks2.getText().toString().trim();
        final String msg = message.getText().toString().trim();


        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycbx8Wq96CR5lVeaEATevaJIWoJIxFYyh9uK8r2nDODWiC8eCS-UI/exec",new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                loading.dismiss();
                Toast.makeText(Feedback2.this,response,Toast.LENGTH_LONG).show();
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> parmas = new HashMap<>();
                parmas.put("action","addFeedback");
                parmas.put("name",name);
                parmas.put("mobile",mobile);
                parmas.put("tmarks",tmarks);
                parmas.put("msg",msg);
                return parmas;
            }
        };
        int socketTimeOut = 1000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);




















    }
}
