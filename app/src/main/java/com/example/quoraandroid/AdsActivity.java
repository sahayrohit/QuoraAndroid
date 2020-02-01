package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.example.quoraandroid.pojo.AdsDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AdsActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ads);
        sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        String token=sharedPreferences.getString("accessToken","");
        App.getRetrofitAds().create(RetroAPI.class).getAllAds("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJjaGlyYWcxMkBnbWFpbC5jb20iLCJ1c2VySWQiOiI2OTlmMzc5Zi02MGM3LTRkNTktYjFjMS1kNjVjYWRjMGZkOGQgIn0.TQ2I_x9CCd2R0wg-ru4ZhoB_8PtSMffg5jBYZ33Ueo-DzWDNfUkq01M1U5lSLwBgn0_sZwG5zYUvZu2ecsGtOA").enqueue(new Callback<List<AdsDTO>>() {
            @Override
            public void onResponse(Call<List<AdsDTO>> call, Response<List<AdsDTO>> response) {


                List<AdsDTO> list=response.body();
                Toast.makeText(AdsActivity.this,list.get(1).getAdvertiserId(),Toast.LENGTH_LONG).show();


            }

            @Override
            public void onFailure(Call<List<AdsDTO>> call, Throwable t) {

            }
        });



    }
}
