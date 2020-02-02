package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.quoraandroid.pojo.search.SearchPaginatedResponse;
import com.example.quoraandroid.pojo.search.SearchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);


//        App.getRetrofit().create(RetroAPI.class).getSearch("naman").enqueue(new Callback<SearchPaginatedResponse>() {
//            @Override
//            public void onResponse(Call<SearchPaginatedResponse> call, Response<SearchPaginatedResponse> response) {
//                SearchPaginatedResponse searchPaginatedResponse=response.body();
//                Toast.makeText(SearchActivity.this,searchPaginatedResponse.getContent().get(2).getQuestionValue().toString(),Toast.LENGTH_LONG).show();
//
//
//            }
//
//            @Override
//            public void onFailure(Call<SearchPaginatedResponse> call, Throwable t) {
//                Log.d("Fail","Failure");
//
//            }
//
//        });





    }
}
