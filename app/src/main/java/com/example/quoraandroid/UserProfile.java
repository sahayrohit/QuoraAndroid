package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quoraandroid.adapter.UserProfileOptionsAdapter;
import com.example.quoraandroid.pojo.registration.Interest;

import java.util.ArrayList;
import java.util.List;

public class UserProfile extends AppCompatActivity {
    private ArrayList<String> optionList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        optionList = new ArrayList<>();
        optionList.add("Share");
        optionList.add("Post");
        optionList.add("Followers");
        optionList.add("Followings");
        optionList.add("Questions");
        optionList.add("Answers");


        //Recycle View
        RecyclerView recyclerView = findViewById(R.id.user_profile_options);
        UserProfileOptionsAdapter userProfileOptionsAdapter = new UserProfileOptionsAdapter(optionList);
        recyclerView.setLayoutManager(new LinearLayoutManager(UserProfile.this, LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(userProfileOptionsAdapter);



    }





}
