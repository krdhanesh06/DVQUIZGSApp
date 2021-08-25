package com.example.dvquizgsapp;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
import java.util.HashMap;
import java.util.Map;

public class AddUser extends AppCompatActivity  {
    TextView tvMendetory;
    EditText user_Name,user_Mobile,user_Email,user_Gender,user_Dateofbirth,user_Profession,user_Address,user_Additionalinformation;
    Button user_Submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        tvMendetory= (TextView)findViewById(R.id.tvMendetory);
        user_Name= (EditText)findViewById(R.id.user_Name);
        user_Mobile= (EditText)findViewById(R.id.user_Mobile);
        user_Email= (EditText)findViewById(R.id.user_Email);
        user_Gender= (EditText)findViewById(R.id.user_Gender);
        user_Dateofbirth = (EditText)findViewById(R.id.user_Dateofbirth);
        user_Profession = (EditText)findViewById(R.id.user_Profession);
        user_Address = (EditText)findViewById(R.id.user_Address);
        user_Additionalinformation = (EditText)findViewById(R.id.user_Additionalinformation);
        user_Submit= (Button)findViewById(R.id.user_Submit);
    }
    private void addUsersToSheet() {
        final ProgressDialog loading = ProgressDialog.show(this,"Adding User...","Please wait.");
        final String name = user_Name.getText().toString().trim();
        final String mobile = user_Mobile.getText().toString().trim();
        final String email = user_Email.getText().toString().trim();
        final String gender = user_Gender.getText().toString().trim();
        final String dob = user_Dateofbirth.getText().toString().trim();
        final String profession = user_Profession.getText().toString().trim();
        final String address = user_Address.getText().toString().trim();
        final String info = user_Additionalinformation.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, "https://script.google.com/macros/s/AKfycby5XfTh51QJVYznfHemjIy6TGX3cEETXohJFjCN0wLll3SvGZgp/exec",new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        loading.dismiss();
                        Toast.makeText(AddUser.this,response,Toast.LENGTH_LONG).show();
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
                parmas.put("action","addUser");
                parmas.put("name",name);
                parmas.put("mobile",mobile);
                parmas.put("email",email);
                parmas.put("gender",gender);
                parmas.put("dob",dob);
                parmas.put("profession",profession);
                parmas.put("address",address);
                parmas.put("info",info);
                return parmas;
            }
        };
        int socketTimeOut = 1000;
        RetryPolicy retryPolicy = new DefaultRetryPolicy(socketTimeOut, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
        stringRequest.setRetryPolicy(retryPolicy);
        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(stringRequest);
    }
    public void addUser(View view) {
        String name = user_Name.getText().toString().trim();
        String mobile = user_Mobile.getText().toString().trim();
        String email = user_Email.getText().toString().trim();
        String gender = user_Gender.getText().toString().trim();
        String dob = user_Dateofbirth.getText().toString().trim();
        String profession = user_Profession.getText().toString().trim();
        String address = user_Address.getText().toString().trim();
        String info = user_Additionalinformation.getText().toString().trim();

     if(TextUtils.isEmpty(name)){
            user_Name.setError("Name is Required.");
            return;
        }
        if(name.length()>20){
            user_Name.setError("Name should be Less than 20 letters");
            return;
        }

     if(TextUtils.isEmpty(mobile)){
            user_Mobile.setError("Mobile Number is required.");
            return;
        }
     if(mobile.length()<10){
          user_Mobile.setError("Mobile no should be 10 digits");
            return;
        }

     if(TextUtils.isEmpty(email)){
            user_Email.setError("Email is required.");
            return;
        }
     if(email.length()>25){
            user_Email.setError("Email should be Less than 25 letters");
            return;
        }
    if(TextUtils.isEmpty(gender)){
            user_Gender.setError("Gender is required.");
            return;
        }
     if(TextUtils.isEmpty(dob)){
            user_Dateofbirth.setError("Date of birth is Required.");
            return;
        }
     if(TextUtils.isEmpty(dob)){
            user_Dateofbirth.setError("Date of birth is Required.");
            return;
        }
     if(TextUtils.isEmpty(profession)){
            user_Profession.setError("Profession is Required.");
            return;
        }
     if(profession.length()>30){
            user_Profession.setError("Profession should beLess than 20 letters");
            return;
        }
     if(TextUtils.isEmpty(address)){
            user_Address.setError("Address is Required.");
            return;
        }
     if(address.length()>50){
            user_Address.setError("Address should beLess than 20 letters");
            return;
        }
      if(TextUtils.isEmpty(info)){
            user_Additionalinformation.setError("Additional information is Required.");
            return;
        }
      if(info.length()>50){
            user_Additionalinformation.setError("Additional information should beLess than 20 letters");
            return;
        }

        addUsersToSheet();
        Intent intent = new Intent(this, Welcome.class);
        intent.putExtra("mobile", mobile);
        intent.putExtra("name", name);
        startActivity(intent);
    }
}
