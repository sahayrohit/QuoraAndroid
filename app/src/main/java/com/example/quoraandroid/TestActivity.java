package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.quoraandroid.pojo.Profile.ExtraDetailsDto;
import com.example.quoraandroid.pojo.Profile.InterestDto;
import com.example.quoraandroid.pojo.questionAndAnswer.AnswerDTO;
import com.example.quoraandroid.pojo.questionAndAnswer.LikesDTO;
import com.example.quoraandroid.pojo.questionAndAnswer.QuestionsDTO;
import com.example.quoraandroid.pojo.questionAndAnswer.ResponseAnswerCategory;
import com.example.quoraandroid.pojo.questionAndAnswer.responseHomePage.ResponseQuestion;
import com.example.quoraandroid.pojo.registration.Interest;
import com.example.quoraandroid.pojo.registration.UserRegistrationDTO;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        SharedPreferences sharedPreferences=getSharedPreferences("login",MODE_PRIVATE);
        QuestionsDTO questionsDTO=new QuestionsDTO();



        String token=sharedPreferences.getString("accessToken","");


        LikesDTO likesDTO=new LikesDTO();
        likesDTO.setQuestionOrAnswerId("5e3692510cd8774e97bbe748");



        App.getRetrofit().create(RetroAPI.class).addLikes(token,likesDTO).enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


        //Add a answer (Working)

//        AnswerDTO answerDTO=new AnswerDTO();
//        answerDTO.setAnswerValue("my name is ananya");
//        answerDTO.setQuestionId("5e3692510cd8774e97bbe748");
//



//        App.getRetrofit().create(RetroAPI.class).addAnswer(token,"naman",answerDTO).enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//
//                Log.d("Answer","received");
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//                Log.d("Fail","Failure");
//            }
//        });






//TODO: working code for getAll categories of a give user

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



//working (Ask question)

//        questionsDTO.setCategoryId("Coding");
//        questionsDTO.setQuestionValue("what is your name?");
//        questionsDTO.setAskerProfileId("320");
//        questionsDTO.setCategoryName("general");
//        questionsDTO.setAskerProfileName("Raghav");
//        questionsDTO.setProfileWhereAskedName("Arnav");
//        questionsDTO.setProfileWhereAskedId("2");
//        questionsDTO.setProfileWhereAskedType("public");
//
//
//
//
//
//
//        String id=sharedPreferences.getString("accessToken","");
//
//        App.getRetrofit().create(RetroAPI.class).addQuestion(questionsDTO,id).enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });


        //not working
//        List<String> list=new ArrayList<>();
//        list.add("coding");

//        ResponseAnswerCategory responseAnswerCategory=new ResponseAnswerCategory();
//        responseAnswerCategory.setCategoryIdList(list);
//        App.getRetrofit().create(RetroAPI.class).getAllCategoryQuestion(responseAnswerCategory).enqueue(new Callback<ResponseQuestion>() {
//            @Override
//            public void onResponse(Call<ResponseQuestion> call, Response<ResponseQuestion> response) {
//                ResponseQuestion responseQuestion=response.body();
//                Toast.makeText(TestActivity.this,responseQuestion.getNumberOfElements(),Toast.LENGTH_LONG).show();
//
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<ResponseQuestion> call, Throwable t) {
//
//            }
//        });




   //get  All Categories
 /*    App.getRetrofitCategories().create(RetroAPI.class).getAllCategories().enqueue(new Callback<List<String>>() {
         @Override
         public void onResponse(Call<List<String>> call, Response<List<String>> response) {
             List<String> list=response.body();
             Toast.makeText(TestActivity.this,list.get(0).toString(),Toast.LENGTH_LONG).show();

         }

         @Override
         public void onFailure(Call<List<String>> call, Throwable t) {

             Log.d("Fail","failure");
         }
     });

  */









    }
}
