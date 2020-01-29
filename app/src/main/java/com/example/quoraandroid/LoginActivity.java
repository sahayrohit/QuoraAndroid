package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    private TextView mRegButton;
    private TextInputEditText mEmail;
    private TextInputEditText mPassword;
    private Button mLoginBtn;
    private Button mGuestBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mEmail = (TextInputEditText) findViewById(R.id.login_email);
        mPassword = (TextInputEditText) findViewById(R.id.login_password);
        mRegButton = (TextView) findViewById(R.id.reg_txt_btn);
        mGuestBtn = (Button) findViewById(R.id.login_guest_btn);
        mLoginBtn = (Button) findViewById(R.id.login_login_btn);


       //onClickListeners
        mRegButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToRegister();
            }
        });
        mGuestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendToMain();
            }
        });

    }

    private void sendToRegister() {
        Intent reg_intent = new Intent(LoginActivity.this,RegisterActivity.class);
        startActivity(reg_intent);
    }
    private void sendToMain(){
        Intent main_intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(main_intent);
        finish();

    }
}
