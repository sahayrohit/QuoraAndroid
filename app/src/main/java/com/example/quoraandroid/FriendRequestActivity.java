package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.quoraandroid.adapter.FriendRequestAdapter;
import com.example.quoraandroid.adapter.PostAdapter;

public class FriendRequestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_request);

//Recycle View
        RecyclerView recyclerView = findViewById(R.id.friend_request_recycler);
        FriendRequestAdapter friendRequestAdapter = new FriendRequestAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(FriendRequestActivity.this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(friendRequestAdapter);
    }
}
