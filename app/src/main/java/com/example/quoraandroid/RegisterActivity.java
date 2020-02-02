package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quoraandroid.pojo.RegisterResponse;
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
    UserRegistrationDTO userRegistrationDTO1;
    private String userId;
    SharedPreferences sharedPreferences;

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
        sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);



        //ProgressBars
        final ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("Please Wait...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        // progressBar.show();





        mRegBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String first_name = mFirstName.getText().toString();
                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO(first_name, email, password, null);
                progressBar.show();
                App.getRetrofitRegistration().create(RetroAPI.class).registerUser(userRegistrationDTO).enqueue(new Callback<RegisterResponse>() {
                    @Override
                    public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                        progressBar.hide();
                        RegisterResponse registerResponse = response.body();
                        userId = registerResponse.getData().getUserId();
                        String first_name = response.body().getData().getName();
                        String email = response.body().getData().getEmailAddress();
                        String password = response.body().getData().getPassword();
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        editor.putString("userId",userId);
                        editor.apply();
                        Log.d("userid","user id:"+ userId);
                        UserRegistrationDTO userRegistrationDTO2 = new UserRegistrationDTO(first_name, email, password, userId);
                        progressBar.show();
                       App.getRetrofit().create(RetroAPI.class).addBasicDetails(userRegistrationDTO2).enqueue(new Callback<String>() {
                            @Override
                            public void onResponse(Call<String> call, Response<String> response) {

                                progressBar.hide();
                                String responseString=response.body();
                                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                                startActivity(intent);

                            }

                            @Override
                            public void onFailure(Call<String> call, Throwable t) {
                                progressBar.hide();

                                Log.d("fail","failure",t);
                            }
                        });





                    }

                    @Override
                    public void onFailure(Call<RegisterResponse> call, Throwable t) {
                        System.out.println("register api callback error");
                    }

                });


//                Log.d("id:", "id: " + userRegistrationDTO1.getUserId());
//                Log.d("id", userRegistrationDTO1.getUserId());
//                UserRegistrationDTO userRegistrationDTO2 = new UserRegistrationDTO(first_name, email, password, userId);
//                App.getRetrofitProfile().create(RetroAPI.class).addBasicDetails(userRegistrationDTO2).enqueue(new Callback<String>() {
//                    @Override
//                    public void onResponse(Call<String> call, Response<String> response) {
//
//                        String responseString = response.body();
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<String> call, Throwable t) {
//                        Log.d("fail", "failure");
//                    }
//                });


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
        Intent user_pref_intent = new Intent(RegisterActivity.this, UserPrefActivity.class);
        startActivity(user_pref_intent);
        finish();
    }

    private void sendToLogin() {
        Intent login_intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(login_intent);
        finish();
    }
}
