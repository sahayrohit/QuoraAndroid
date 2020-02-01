package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.quoraandroid.pojo.registration.UserRegistrationDTO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        UserRegistrationDTO userRegistrationDTO=new UserRegistrationDTO("naman","naman@","1234","12");
        App.getRetrofitProfile().create(RetroAPI.class).addBasicDetails(userRegistrationDTO).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                String responseString=response.body();
                Toast.makeText(TestActivity.this,responseString,Toast.LENGTH_LONG).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Log.d("fail","failure");
            }
        });





    }
}
