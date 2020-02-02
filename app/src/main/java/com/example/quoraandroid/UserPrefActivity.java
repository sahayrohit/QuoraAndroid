package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.quoraandroid.pojo.Profile.ExtraDetailsDto;
import com.example.quoraandroid.pojo.Profile.InterestDto;
import com.example.quoraandroid.pojo.registration.ApiResponse;
import com.example.quoraandroid.adapter.FriendRequestAdapter;
import com.example.quoraandroid.adapter.UserProfileOptionsAdapter;

import com.example.quoraandroid.pojo.registration.Interest;
import com.example.quoraandroid.pojo.registration.SignUp;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserPrefActivity extends AppCompatActivity {



    private Button register;
    List<InterestDto> interests;
    RadioGroup radioGroup;
    RadioButton publicButton,privateButton;
    private CheckBox lifeStyle,cartoons,literature,cricket,coding,politics,movies,web,booze,food;

    private  String role,channel="quora",profile;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_pref);


        register=findViewById(R.id.finalRegister);
        lifeStyle=(CheckBox)findViewById(R.id.cb_lifestyle);
        cartoons=(CheckBox)findViewById(R.id.cb_cartoon);
        literature=(CheckBox)findViewById(R.id.cb_literature);
        cricket=(CheckBox)findViewById(R.id.cb_cricket);
        coding=(CheckBox)findViewById(R.id.cb_coding);
        politics=(CheckBox)findViewById(R.id.cb_Politics);
        movies=(CheckBox)findViewById(R.id.cb_movies);
        web=(CheckBox)findViewById(R.id.cb_web);
        booze=(CheckBox)findViewById(R.id.cb_booze);
        food=(CheckBox)findViewById(R.id.cb_food);

        radioGroup=findViewById(R.id.rg_pref);
        publicButton=findViewById(R.id.rb_public);
        privateButton=findViewById(R.id.rb_private);







        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(lifeStyle.isChecked())
                {
                       interests.add(new InterestDto(lifeStyle.getText().toString(),lifeStyle.getText().toString()));

                }
                if(cartoons.isChecked())
                {
                    interests.add(new InterestDto(cartoons.getText().toString(),cartoons.getText().toString()));
                }
                if(literature.isChecked())
                {
                    interests.add( new InterestDto(literature.getText().toString(),literature.getText().toString()));
                }
                if(cricket.isChecked())
                {
                    interests.add(new InterestDto(cricket.getText().toString(),cricket.getText().toString()));
                }
                if(coding.isChecked())
                {
                    interests.add(new InterestDto(String.valueOf(coding.getId()),coding.getText().toString()));
                }
                if(politics.isChecked())
                {
                    interests.add(new InterestDto(String.valueOf(politics.getId()),politics.getText().toString()));
                }
                if(movies.isChecked())
                {
                    interests.add(new InterestDto(String.valueOf(movies.getId()),movies.getText().toString()));
                }
                if(web.isChecked())
                {

                    interests.add( new InterestDto(String.valueOf(web.getId()),web.getText().toString()));
                }
                if(booze.isChecked())
                {
                    interests.add(new InterestDto(String.valueOf(booze.getId()),booze.getText().toString()));
                }
                if(food.isChecked())
                {
                    interests.add(new InterestDto(String.valueOf(food.getId()),food.getText().toString()));

                }





                int selectedId=radioGroup.getCheckedRadioButtonId();
                if(selectedId==publicButton.getId()) {
                    profile="public";
                    role="nonModerator";
                    Toast.makeText(UserPrefActivity.this, "public", Toast.LENGTH_LONG).show();
                }
                else {
                    profile="private";
                    role="moderator";
                    Toast.makeText(UserPrefActivity.this, "private", Toast.LENGTH_LONG).show();

                }



               String id=getIntent().getStringExtra("token");

                ExtraDetailsDto extraDetailsDto=new ExtraDetailsDto(id,channel,profile,role,interests);

                App.getRetrofit().create(RetroAPI.class).addExtraDetails(extraDetailsDto,id).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {


                        String resonseString=response.body();



                    }


                    @Override
                    public void onFailure(Call<String> call, Throwable t) {

                    }
                });
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {


                    }
                }, 3000);


                SignUp signUp=new SignUp(channel,profile,role);
                App.getRetrofitRegistration().create(RetroAPI.class).getRole(signUp,"Bearer "+getIntent().getStringExtra("token")).enqueue(new Callback<ApiResponse<SignUp>>() {
                    @Override
                    public void onResponse(Call<ApiResponse<SignUp>> call, Response<ApiResponse<SignUp>> response) {
                        Toast.makeText(UserPrefActivity.this,"success",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(UserPrefActivity.this,MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<ApiResponse<SignUp>> call, Throwable t) {

                    }
                });








            }






        });

    }
}
