package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quoraandroid.adapter.CategoryAdapter;
import com.example.quoraandroid.adapter.PostAdapter;
import com.example.quoraandroid.adapter.QuestionAdapter;

public class MyProfileActivity extends AppCompatActivity {
    private androidx.appcompat.widget.Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        //toolbar
        toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.profile_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //RecyclerView for category
        RecyclerView recyclerView_cat = findViewById(R.id.profile_category_recycler);
        CategoryAdapter categoryAdapter = new CategoryAdapter();
        recyclerView_cat.setLayoutManager(new LinearLayoutManager(MyProfileActivity.this,LinearLayoutManager.HORIZONTAL,false));
        recyclerView_cat.setAdapter(categoryAdapter);

        //RecyclerView for questions
        RecyclerView recyclerView_que = findViewById(R.id.profile_question_recycler);
        QuestionAdapter questionAdapter = new QuestionAdapter();
        recyclerView_que.setLayoutManager(new LinearLayoutManager(MyProfileActivity.this,LinearLayoutManager.VERTICAL,false));
        recyclerView_que.setAdapter(questionAdapter);
    }
}
