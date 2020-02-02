package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quoraandroid.adapter.CategoryAdapter;
import com.example.quoraandroid.adapter.PostAdapter;
import com.example.quoraandroid.adapter.QuestionAdapter;
import com.example.quoraandroid.pojo.Profile.ProfileDto;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyProfileActivity extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;

    private RecyclerView recyclerView;
    TextView name,email,level;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        level=findViewById(R.id.level);

        //toolbar
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        String id=sharedPreferences.getString("accessToken","");

        App.getRetrofit().create(RetroAPI.class).getProfile(id).enqueue(new Callback<ProfileDto>() {
            @Override
            public void onResponse(Call<ProfileDto> call, Response<ProfileDto> response) {

                ProfileDto profileDto=response.body();
                Toast.makeText(MyProfileActivity.this,profileDto.getName().toString(), Toast.LENGTH_SHORT).show();
               // Log.d("tag", "name"+profileDto.getName());
                name.setText(profileDto.getName());
                email.setText(profileDto.getEmailAddress());

            }

            @Override
            public void onFailure(Call<ProfileDto> call, Throwable t) {

            }
        });

        //RecyclerView for category
        recyclerView = findViewById(R.id.profile_category_recycler);
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(MyProfileActivity.this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(categoryAdapter);

        //RecyclerView for questions
        RecyclerView recyclerView_que = findViewById(R.id.profile_question_recycler);
        QuestionAdapter questionAdapter = new QuestionAdapter();
        recyclerView_que.setLayoutManager(new LinearLayoutManager(MyProfileActivity.this,LinearLayoutManager.VERTICAL,false));
        recyclerView_que.setAdapter(questionAdapter);
    }
}
