package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quoraandroid.adapter.CategoryAdapter;
import com.example.quoraandroid.adapter.PostAdapter;
import com.example.quoraandroid.adapter.QuestionAdapter;
import com.example.quoraandroid.adapter.UserProfileOptionsAdapter;

import java.util.ArrayList;
import java.util.Objects;

public class MyProfileActivity extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;

    private RecyclerView recyclerView;
    private ArrayList<String> userOptionList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        //toolbar
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        userOptionList = new ArrayList<>();
        userOptionList.add("PROFILE");
        userOptionList.add("ANSWERS");
        userOptionList.add("QUESTIONS");
        userOptionList.add("SHARE");
        userOptionList.add("POST");
        userOptionList.add("FOLLOWING");
        userOptionList.add("FOLLOWERS");


        //RecyclerView for questions
        RecyclerView recyclerView_que = findViewById(R.id.profile_question_recycler);
        QuestionAdapter questionAdapter = new QuestionAdapter();
        recyclerView_que.setLayoutManager(new LinearLayoutManager(MyProfileActivity.this,LinearLayoutManager.VERTICAL,false));
        recyclerView_que.setAdapter(questionAdapter);
    }
}
