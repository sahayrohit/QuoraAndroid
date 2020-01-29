package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class RegisterActivity extends AppCompatActivity {
    private TextView mLoginBtn;
    private TextInputEditText mFirstName;
    private TextInputEditText mLastName;
    private TextInputEditText mPhone;
    private TextInputEditText mEmail;
    private TextInputEditText mPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirstName = (TextInputEditText) findViewById(R.id.reg_first_name);
        mLastName = (TextInputEditText) findViewById(R.id.reg_last_name);
        mPhone = (TextInputEditText) findViewById(R.id.reg_phone);
        mEmail = (TextInputEditText) findViewById(R.id.reg_email);
        mPassword = (TextInputEditText) findViewById(R.id.reg_Password);
        mLoginBtn = (TextView) findViewById(R.id.reg_login_txt);
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            sendToLogin();
            }
        });
    }
    private void sendToLogin() {
        Intent login_intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(login_intent);
        finish();
    }
}
