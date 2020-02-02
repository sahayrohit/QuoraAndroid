package com.example.quoraandroid;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quoraandroid.adapter.PostAdapter;
import com.example.quoraandroid.pojo.questionAndAnswer.responseHomePage.ContentItem;
import com.example.quoraandroid.pojo.questionAndAnswer.responseHomePage.ResponseQuestion;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener ,PostAdapter.PostClick{


    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    LinearLayoutManager layoutManager;
    PostAdapter postAdapter;
    int position;
    RecyclerView recyclerView;
    SharedPreferences sharedPreferences;
    public static final String myPreference = "login";

    List<ContentItem> list=new ArrayList<>();

    int page=0;
    int totalPages;
    int totalElements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //ProgressBars
        final ProgressDialog progressBar = new ProgressDialog(this);
        progressBar.setCancelable(true);
        progressBar.setMessage("Please Wait...");
        progressBar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressBar.setProgress(0);
        progressBar.setMax(100);
        // progressBar.show();









            progressBar.show();
        App.getRetrofit().create(RetroAPI.class).homepage(page,3).enqueue(new Callback<ResponseQuestion>() {
            @Override
            public void onResponse(Call<ResponseQuestion> call, Response<ResponseQuestion> response) {
            progressBar.hide();
                ResponseQuestion responseQuestion=response.body();
                list=responseQuestion.getContent();
                Toast.makeText(MainActivity.this,list.get(0).getQuestionValue(),Toast.LENGTH_LONG).show();
                layoutManager=new LinearLayoutManager(MainActivity.this);
                recyclerView = findViewById(R.id.top_question_recycler);
                recyclerView.setLayoutManager(layoutManager);
                postAdapter = new PostAdapter(list,MainActivity.this);
                recyclerView.setAdapter(postAdapter);
                totalPages=response.body().getTotalPages();



                recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                        super.onScrolled(recyclerView, dx, dy);
                        position =layoutManager.findLastCompletelyVisibleItemPosition();
                        if ((position == list.size()-1)&&(page!=totalPages)){
                            // End has been reached
                            page++;
                            apiCall(page,3);
                            Log.i("Yaeye!", "end called");
                        }
                    }
                });
                apiCall(page,3);


            }

            @Override
            public void onFailure(Call<ResponseQuestion> call, Throwable t) {
                progressBar.hide();
                Log.d("Fail","failure");
            }
        });


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





//        FirebaseMessaging.getInstance().subscribeToTopic("weather")
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        String msg = getString(R.string.msg_subscribed);
//                        if (!task.isSuccessful()) {
//                            msg = getString(R.string.msg_subscribe_failed);
//                        }
//                        Log.d("token", msg);
//                        System.out.println();
//                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
//                    }
//                });
        // [END subscribe_topics]

        FirebaseInstanceId.getInstance().getInstanceId()
                .addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                    @Override
                    public void onComplete(@NonNull Task<InstanceIdResult> task) {
                        if (!task.isSuccessful()) {
                            Log.w("token", "getInstanceId failed", task.getException());
                            return;
                        }
                        // Get new Instance ID token
                        String token = task.getResult().getToken();
                        // Log and toast
                        String msg = getString(R.string.msg_token_fmt, token);
                        Log.d("token", msg);
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
    private void sendToUserProfile() {
        Intent user_profile_intent = new Intent(MainActivity.this,UserProfile.class);
        startActivity(user_profile_intent);
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
            case R.id.nav_cat:
                sendToUserProfile();
                break;
            default:
                return true;
        }
        return false;
    }




    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClickSend() {

        Intent intent=new Intent(MainActivity.this, AnswerActivity.class);
        startActivity(intent);

    }
    public void apiCall(int page, int size){

        App.getRetrofit().create(RetroAPI.class).homepage(page,size).enqueue(new Callback<ResponseQuestion>() {
            @Override
            public void onResponse(Call<ResponseQuestion> call, Response<ResponseQuestion> response) {

                int length=list.size();
                list.addAll(response.body().getContent());
                totalPages=response.body().getTotalPages();
                totalElements=response.body().getTotalElements();
                postAdapter=new PostAdapter(list,MainActivity.this);
                recyclerView.setAdapter(postAdapter);
                postAdapter.notifyItemRangeInserted(length,response.body().getContent().size());


            }

            @Override
            public void onFailure(Call<ResponseQuestion> call, Throwable t) {

            }
        });


    }

    @Override
    protected void onStart() {
        super.onStart();
        sharedPreferences = getSharedPreferences(myPreference, Context.MODE_PRIVATE);
        String account = sharedPreferences.getString("accessToken", null);
        //SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        //String token=sharedPreferences.getString("accessToken","");
        updateUI(account);
    }

    private void updateUI(String account) {

        if(account!=null){


        }

    }


}
