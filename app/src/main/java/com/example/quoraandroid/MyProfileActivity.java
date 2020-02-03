package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

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
    TextView name,email,role;
    public static final String myPreference = "login";
    //SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        role = findViewById(R.id.level);


       SharedPreferences sharedPreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE);
        String account = sharedPreferences.getString("accessToken", null);

        App.getRetrofit().create(RetroAPI.class).getProfile(account).enqueue(new Callback<ProfileDto>() {
            @Override
            public void onResponse(Call<ProfileDto> call, Response<ProfileDto> response) {

                ProfileDto profileDto=response.body();
                name.setText(profileDto.getName());
                email.setText(profileDto.getEmailAddress());
                role.setText(profileDto.getRole());

            }

            @Override
            public void onFailure(Call<ProfileDto> call, Throwable t) {

            }
        });

        //toolbar
        toolbar = findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);





        //        App.getRetrofit().create(RetroAPI.class).getCategory(token).enqueue(new Callback<List<InterestDto>>() {
//            @Override
//            public void onResponse(Call<List<InterestDto>> call, Response<List<InterestDto>> response) {
//
//                List<InterestDto> interestDto=response.body();
//                Toast.makeText(TestActivity.this,interestDto.get(0).getInterestName(),Toast.LENGTH_LONG).show();
//
//            }
//
//            @Override
//            public void onFailure(Call<List<InterestDto>> call, Throwable t) {
//
//                Log.d("Fail","failure");
//            }
//        });




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
