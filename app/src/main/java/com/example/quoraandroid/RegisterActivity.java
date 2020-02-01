package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quoraandroid.pojo.registration.Interest;
import com.example.quoraandroid.pojo.registration.UserRegistrationDTO;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterActivity extends AppCompatActivity {
    private TextView mLoginBtn;
    private TextInputEditText mFirstName;
    private TextInputEditText mLastName;
    private TextInputEditText mEmail;
    private TextInputEditText mPassword;
    private Button mRegBtn;


//Access specifier


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mFirstName = findViewById(R.id.reg_first_name);
        mLastName = findViewById(R.id.reg_last_name);
        mEmail = findViewById(R.id.reg_email);
        mPassword = (TextInputEditText) findViewById(R.id.reg_Password);
        mLoginBtn = (TextView) findViewById(R.id.reg_login_txt);
        mRegBtn = (Button) findViewById(R.id.reg_btn);



        mRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String first_name = mFirstName.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();



                final UserRegistrationDTO userRegistrationDTO=new UserRegistrationDTO(first_name,email,password,null);
                App.getRetrofitRegistration().create(RetroAPI.class).registerUser(userRegistrationDTO).enqueue(new Callback<UserRegistrationDTO>() {
                    @Override
                    public void onResponse(Call<UserRegistrationDTO> call, Response<UserRegistrationDTO> response) {

                        UserRegistrationDTO userRegistrationDTO1 = response.body();
                        Toast.makeText(RegisterActivity.this,userRegistrationDTO1.getName(),Toast.LENGTH_LONG).show();
                      //  Log.d("reg",userRegistrationDTO1.getName());
                        Log.d("REG", "reg form " + userRegistrationDTO1.getName());

                    }

                    @Override
                    public void onFailure(Call<UserRegistrationDTO> call, Throwable t) {
                        Log.d("REG", "failure " + t.getMessage());


                    }
                });
                 sendToLogin();

                // sendToUserPref();
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
