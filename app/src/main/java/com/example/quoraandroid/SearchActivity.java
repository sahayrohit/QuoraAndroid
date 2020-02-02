package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.quoraandroid.adapter.PostAdapter;
import com.example.quoraandroid.adapter.SearchAdapter;
import com.example.quoraandroid.pojo.search.SearchPaginatedResponse;
import com.example.quoraandroid.pojo.search.SearchResponse;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    private TextInputEditText searchTxt;
    private Button mSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        searchTxt = findViewById(R.id.search_bar_txt);
        mSearch = findViewById(R.id.search_btn_1);


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
        //ProgressBars
        final ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("Please Wait...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        // progressBar.show();


        mSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search_txt = searchTxt.getText().toString();
                progressBar.show();
                App.getRetrofit().create(RetroAPI.class).getSearch(search_txt).enqueue(new Callback<SearchPaginatedResponse>() {
                    @Override
                    public void onResponse(Call<SearchPaginatedResponse> call, Response<SearchPaginatedResponse> response) {
                        progressBar.dismiss();
                        SearchPaginatedResponse searchPaginatedResponse=response.body();

                        RecyclerView recyclerView = findViewById(R.id.recycle_search);
                        SearchAdapter searchAdapter = new SearchAdapter(searchPaginatedResponse.getContent());
                        recyclerView.setLayoutManager(new LinearLayoutManager(SearchActivity.this,LinearLayoutManager.VERTICAL,false));
                        recyclerView.setAdapter(searchAdapter);



                        Toast.makeText(SearchActivity.this,searchPaginatedResponse.getContent().get(0).getProfileValue(),Toast.LENGTH_LONG).show();



                    }

                    @Override
                    public void onFailure(Call<SearchPaginatedResponse> call, Throwable t) {
                        progressBar.dismiss();
                        Log.d("Fail","Failure");

                    }

                });




            }
        });



    }
}
