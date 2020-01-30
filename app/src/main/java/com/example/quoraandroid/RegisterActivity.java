package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    private TextView mLoginBtn;
    private TextInputEditText mFirstName;
    private TextInputEditText mLastName;
    private TextInputEditText mEmail;
    private TextInputEditText mPassword;
    private Button mRegBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirstName = (TextInputEditText) findViewById(R.id.reg_first_name);
        mLastName = (TextInputEditText) findViewById(R.id.reg_last_name);
        mEmail = (TextInputEditText) findViewById(R.id.reg_email);
        mPassword = (TextInputEditText) findViewById(R.id.reg_Password);
        mLoginBtn = (TextView) findViewById(R.id.reg_login_txt);
        mRegBtn = (Button) findViewById(R.id.reg_btn);

        mRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToUserPref();
            }
        });
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            sendToLogin();
            }
        });
    }

    private void sendToUserPref() {
        Intent user_pref_intent = new Intent(RegisterActivity.this,UserPrefActivity.class);
        startActivity(user_pref_intent);
        finish();
    }

    private void sendToLogin() {
        Intent login_intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(login_intent);
        finish();
    }
}
