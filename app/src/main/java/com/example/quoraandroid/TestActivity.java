package com.example.quoraandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.quoraandroid.pojo.Profile.ExtraDetailsDto;
import com.example.quoraandroid.pojo.Profile.InterestDto;
import com.example.quoraandroid.pojo.questionAndAnswer.AnswerDTO;
import com.example.quoraandroid.pojo.questionAndAnswer.DislikesDTO;
import com.example.quoraandroid.pojo.questionAndAnswer.LikesDTO;
import com.example.quoraandroid.pojo.questionAndAnswer.QuestionsDTO;
import com.example.quoraandroid.pojo.questionAndAnswer.ResponseAnswerCategory;
import com.example.quoraandroid.pojo.questionAndAnswer.getAllAnsOfQuestionId.AnsOfAQuesIdResponse;
import com.example.quoraandroid.pojo.questionAndAnswer.getAllQuestionsOfSelectedCategories.GetAllQuestionsOdCatResponse;
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



        App.getRetrofit().create(RetroAPI.class).getAllAnswerOfQuestion("5e3692510cd8774e97bbe748").enqueue(new Callback<AnsOfAQuesIdResponse>() {
            @Override
            public void onResponse(Call<AnsOfAQuesIdResponse> call, Response<AnsOfAQuesIdResponse> response) {

                AnsOfAQuesIdResponse ansOfAQuesIdResponse=response.body();
                Toast.makeText(TestActivity.this,ansOfAQuesIdResponse.getContent().get(0).getAnswerValue(),Toast.LENGTH_LONG);

            }

            @Override
            public void onFailure(Call<AnsOfAQuesIdResponse> call, Throwable t) {

            }
        });

        //dislike Dto(working)

//        DislikesDTO dislikesDTO=new DislikesDTO();
//        dislikesDTO.setQuestionOrAnswerId("5e3692510cd8774e97bbe748");
//
//        App.getRetrofit().create(RetroAPI.class).addDislikes(token,dislikesDTO).enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });









//  likes to questions and answers(Working)
//        LikesDTO likesDTO=new LikesDTO();
//        likesDTO.setQuestionOrAnswerId("5e3692510cd8774e97bbe748");
//
//
//
//        App.getRetrofit().create(RetroAPI.class).addLikes(token,likesDTO).enqueue(new Callback<String>() {
//            @Override
//            public void onResponse(Call<String> call, Response<String> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<String> call, Throwable t) {
//
//            }
//        });


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


        List<String> list=new ArrayList<>();
        list.add("coding");
        ResponseAnswerCategory responseAnswerCategory=new ResponseAnswerCategory();
        responseAnswerCategory.setCategoryIdList(list);

App.getRetrofit().create(RetroAPI.class).getQuestionsOfSelectedCategories(responseAnswerCategory).enqueue(new Callback<GetAllQuestionsOdCatResponse>() {
    @Override
    public void onResponse(Call<GetAllQuestionsOdCatResponse> call, Response<GetAllQuestionsOdCatResponse> response) {

        GetAllQuestionsOdCatResponse getAllQuestions=response.body();
        Toast.makeText(TestActivity.this,getAllQuestions.getContent().get(1).getQuestionValue(),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onFailure(Call<GetAllQuestionsOdCatResponse> call, Throwable t) {

    }
});





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
