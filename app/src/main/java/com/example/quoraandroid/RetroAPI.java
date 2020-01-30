package com.example.quoraandroid;

import com.example.quoraandroid.pojo.Comment.CommentDTO;
import com.example.quoraandroid.pojo.Comment.ResponseDTO;
import com.example.quoraandroid.pojo.Profile.AnswerDto;
import com.example.quoraandroid.pojo.Profile.AnswerResponseDto;
import com.example.quoraandroid.pojo.Profile.AskerDto;
import com.example.quoraandroid.pojo.Profile.AskerResponseDto;
import com.example.quoraandroid.pojo.Profile.BasicDetailsDto;
import com.example.quoraandroid.pojo.Profile.CategoryDto;
import com.example.quoraandroid.pojo.Profile.ExtraDetailsDto;
import com.example.quoraandroid.pojo.Profile.InterestDto;
import com.example.quoraandroid.pojo.Profile.ProfileDto;
import com.example.quoraandroid.pojo.Profile.UserDetailDto;
import com.example.quoraandroid.pojo.questionAndAnswer.CategoryDTO;
import com.example.quoraandroid.pojo.questionAndAnswer.DislikesDTO;
import com.example.quoraandroid.pojo.questionAndAnswer.EmojisDTO;
import com.example.quoraandroid.pojo.questionAndAnswer.LikesDTO;
import com.example.quoraandroid.pojo.questionAndAnswer.QuestionsDTO;
import com.example.quoraandroid.pojo.pagination.ResponsePage;
import com.example.quoraandroid.pojo.questionAndAnswer.SetApprovedAnswerRequestDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface RetroAPI {



//Questions and answer micro service
    @POST("/questions/addQuestion")
    Call<String> addQuestion(@Body QuestionsDTO questionsDTO);

    @PUT("/questions/addLikes")
    Call<String> addLikes(@Body LikesDTO likesDTO);


    @PUT("/questions/addDislikes")
    Call<String> addDislikes(@Body DislikesDTO dislikesDTO);

    @PUT("/questions/addEmojis")
    Call<String> addEmojis(EmojisDTO emojisDTO);

    @POST("/questions/setQuestionStatus/{questionId}/{status}")
    Call<String> setQuestionStatus(@Path("questionId") String questionId,@Path("status")Boolean status);

    @POST("/questions/setApprovedAnswer")
    Call<String> setApprovedAnswer(SetApprovedAnswerRequestDTO setApprovedAnswerRequestDTO);

    @POST("/questions/addQuestionToACategory/")
    Call<String> addQuestionToACategory(CategoryDTO categoryDTO);

//comments

    @POST("/comment/addComment")
    Call<ResponseDTO<CommentDTO>> addComment(@Body CommentDTO commentDTO);

    @GET("comment/getComment/{parentId}")
   Call<ResponsePage> getComment(@Path("parentId") String parentId);

    @POST("/comment/deleteComment/{commentId}")
    Call<ResponseDTO<String>> deleteComment(@Path("commentId") String commentId);


//profile

    @POST("/basicDetails")
    Call<String> addBasicDetails(@Body BasicDetailsDto basicDetailsDto);

    @POST("/extraDetails")
    Call<String> addExtraDetails(@Body ExtraDetailsDto extraDetailsDto);

    @GET("/profile/{userId}")
    Call<ProfileDto> getProfile(@Path("userId") String userId);

    @GET("/followerId")
    Call<AskerResponseDto> getFollowerId(@Body AskerDto askerDto);

    @GET("/answerApproveFollower")
    Call<AnswerResponseDto> getAnswerApprovedFollower(@Body AnswerDto answerDto);

    @GET("/approveFollower")
    Call<AskerResponseDto> getApprovedFollower(@Body AskerDto askerDto);

    @GET("/answerFollowerId")
    Call<AnswerResponseDto> getAnswerFollower(@Body AnswerDto answerDto);

    @PUT("/addFollower/{followerId}/{userId}")
    Call<String> addFollower(@Path("followerId") String followerId , @Path("userId") String userId);

    @PUT("/addFollowing/{followingId}/{userId}")
    Call<String> addFollowing(@Path("followingId") String followingId , @Path("userId") String userId);

    @PUT("/addFollower/{points}/{userId}")
    Call<String> addPoints(@Path("points") int points , @Path("userId") String userId);

    @PUT("/addFollower/{moderatorId}/{userId}")
    Call<String> addModerator(@Path("moderatorId") String moderatorId , @Path("userId") String userId);

    @PUT("/addCategory")
    Call<String> addCategory(@Body CategoryDto categoryDto);

    @GET("/category/{userId}")
    Call<List<InterestDto>> getCategory(@Path("userId") String userId);

    @GET("/follower/{userId}")
    Call<List<UserDetailDto>> getFollower(@Path("userId") String userId);

    @GET("/following/{userId}")
    Call<List<UserDetailDto>> getFollowing(@Path("userId") String userId);

    @GET("/moderator/{userId}")
    Call<List<UserDetailDto>> getModerator(@Path("userId") String userId);

    @DELETE("/follower/{followerId}/{userId}")
    Call<String> removeFollower(@Path("followerId") String followerId,@Path("userId") String userId);

    @DELETE("/following/{followingId}/{userId}")
    Call<String> removeFollowing(@Path("followingId") String followingId,@Path("userId") String userId);

    @DELETE("/moderator/{moderatorId}/{userId}")
    Call<String> removeModerator(@Path("moderatorId") String moderatorId,@Path("userId") String userId);

    @DELETE("/category/{categoryId}/{userId}")
    Call<String> removeCategory(@Path("categoryId") String categoryId,@Path("userId") String userId);










}
