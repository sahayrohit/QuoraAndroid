package com.example.quoraandroid;

import com.example.quoraandroid.pojo.DislikesDTO;
import com.example.quoraandroid.pojo.LikesDTO;
import com.example.quoraandroid.pojo.QuestionsDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.PUT;

public interface RetroAPI {



//Questions and answer micro service
    @POST("/questions/addQuestion")
    Call<String> addQuestion(@Body QuestionsDTO questionsDTO);

    @PUT("/questions/addLikes")
    Call<String> addLikes(@Body LikesDTO likesDTO);


    @PUT("/questions/addDislikes")
    Call<String> addDislikes(@Body DislikesDTO dislikesDTO);











}
