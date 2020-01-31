package com.example.quoraandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import com.example.quoraandroid.adapter.PostAdapter;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {


    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = (Toolbar) findViewById(R.id.main_toolbar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        setSupportActionBar(toolbar);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                this,
                drawerLayout,
                toolbar,
                R.string.openNavDrawer,
                R.string.closeNavDrawer

        );
          drawerLayout.addDrawerListener(actionBarDrawerToggle);
          actionBarDrawerToggle.syncState();
          navigationView.setNavigationItemSelectedListener(this);

        RecyclerView recyclerView = findViewById(R.id.top_question_recycler);
        PostAdapter postAdapter = new PostAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this,LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(postAdapter);


        FirebaseMessaging.getInstance().subscribeToTopic("weather")
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        String msg = getString(R.string.msg_subscribed);
                        if (!task.isSuccessful()) {
                            msg = getString(R.string.msg_subscribe_failed);
                        }
                        Log.d("token", msg);
                        System.out.println();
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
//        // [END subscribe_topics]
    }




    private void sendToLogin() {
        Intent login_intent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(login_intent);
        finish();
    }
    private void sendToMyProfile() {
        Intent profile_intent = new Intent(MainActivity.this,MyProfileActivity.class);
        startActivity(profile_intent);
    }
    private void sendToFriendRequest() {
        Intent friend_request_intent = new Intent(MainActivity.this,FriendRequestActivity.class);
        startActivity(friend_request_intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_login:
                sendToLogin();
                break;
            case R.id.nav_my_profile:
                sendToMyProfile();
                break;
            case R.id.nav_follow:
                sendToFriendRequest();
                break;
            default:
                return true;
        }
        return false;
    }




    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
