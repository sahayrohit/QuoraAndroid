package com.example.quoraandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quoraandroid.adapter.PostAdapter;
import com.example.quoraandroid.pojo.registration.ApiResponse;
import com.example.quoraandroid.pojo.registration.LoginPost;
import com.example.quoraandroid.pojo.registration.TokenDTO;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
        final SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        mEmail = findViewById(R.id.login_email);
        mPassword = findViewById(R.id.login_password);
        mRegButton = findViewById(R.id.reg_txt_btn);
        mGuestBtn = findViewById(R.id.login_guest_btn);
        mLoginBtn = findViewById(R.id.login_login_btn);


        //ProgressBars
        final ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("Please Wait...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        // progressBar.show();



//String token=sharedPreferences.getString("accessToken","");

        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String token;

                //Firebase FCM token
                FirebaseInstanceId.getInstance().getInstanceId()
                        .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                            @Override
                            public void onComplete(@NonNull Task<InstanceIdResult> task) {
                                if (!task.isSuccessful()) {
                                    Log.w("token", "getInstanceId failed", task.getException());
                                    return;
                                }
                                // Get new Instance ID token
                                String token = task.getResult().getToken();


                                String email=mEmail.getText().toString();
                                String password= mPassword.getText().toString();


                                LoginPost loginPost=new LoginPost(email,password,token,"quora");

                                progressBar.show();
                                App.getRetrofitRegistration().create(RetroAPI.class).loginUser(loginPost).enqueue(new Callback<ApiResponse<TokenDTO>>() {
                                    @Override
                                    public void onResponse(Call<ApiResponse<TokenDTO>> call, Response<ApiResponse<TokenDTO>> response) {
                                        progressBar.hide();
                                        ApiResponse<TokenDTO> response1=response.body();
                                        SharedPreferences.Editor editor=sharedPreferences.edit();
                                        editor.putString("accessToken",response1.getData().getAccessToken());
                                        editor.apply();

                                        Toast.makeText(LoginActivity.this, "response "+ response1.getData().getProfile(), Toast.LENGTH_SHORT).show();

                                        if(response1.getData().getProfile().toString().equals("")) {
                                            Intent intent = new Intent(LoginActivity.this, UserPrefActivity.class);
                                            intent.putExtra("token", response1.getData().getAccessToken());

                                            startActivity(intent);
                                        }
                                        else{

                                            Intent intent=new Intent(LoginActivity.this,MainActivity.class);

                                            startActivity(intent);
                                        }
                                    }

                                    @Override
                                    public void onFailure(Call<ApiResponse<TokenDTO>> call, Throwable t) {
                                        Toast.makeText(LoginActivity.this, "login failed", Toast.LENGTH_SHORT).show();
                                        progressBar.hide();
                                    }
                                });




                                // Log and toast
                                String msg = getString(R.string.msg_token_fmt, token);
                                //   Log.d("token", msg);
                            }
                        });












            }
        });


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
        finish();
    }
    private void sendToMain(){
        Intent main_intent = new Intent(LoginActivity.this,MainActivity.class);
        startActivity(main_intent);
        finish();

    }
}
