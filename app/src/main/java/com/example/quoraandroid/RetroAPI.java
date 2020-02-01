package com.example.quoraandroid;

import com.example.quoraandroid.pojo.AdsDTO;
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
import com.example.quoraandroid.pojo.questionAndAnswer.responseHomePage.ResponseQuestion;
import com.example.quoraandroid.pojo.questionAndAnswer.SetApprovedAnswerRequestDTO;
import com.example.quoraandroid.pojo.registration.ApiResponse;
import com.example.quoraandroid.pojo.registration.LoginPost;
import com.example.quoraandroid.pojo.registration.SignUp;
import com.example.quoraandroid.pojo.registration.TokenDTO;
import com.example.quoraandroid.pojo.registration.UserRegistrationDTO;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetroAPI {


 @GET("ads/getAds/{accessToken}")
Call<List<AdsDTO>> getAllAds(@Path("accessToken") String token);



//login and registration

 @POST("roleController/userRole")
 Call<ApiResponse<SignUp>> getRole(@Body SignUp signUp, @Header("Authorization") String accessToken);

 @POST("/controller/register")
 Call<UserRegistrationDTO> registerUser(@Body UserRegistrationDTO userRegistrationDTO);


 @POST("/controller/login")
 Call<ApiResponse<TokenDTO>> loginUser(@Body LoginPost loginPost);

    //for categories

   @GET("/ads/categories")
   Call<List<String>> getCategories();



//Questions and answer micro service



    @GET("/questions/getAllQuestions")
    Call<ResponseQuestion> homepage(@Query("pageNumber") int page, @Query("pageSize") int pageSize);


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



    @POST("profile/basicDetails")
    Call<String> addBasicDetails(@Body UserRegistrationDTO userRegistrationDTO);

    @POST("profile/extraDetails")
    Call<String> addExtraDetails(@Body ExtraDetailsDto extraDetailsDto);

    @GET("/profile/{userId}")
    Call<ProfileDto> getProfile(@Path("userId") String userId);

    @GET("profile/followerId")
    Call<AskerResponseDto> getFollowerId(@Body AskerDto askerDto);

    @GET("profile/answerApproveFollower")
    Call<AnswerResponseDto> getAnswerApprovedFollower(@Body AnswerDto answerDto);

    @GET("profile/approveFollower")
    Call<AskerResponseDto> getApprovedFollower(@Body AskerDto askerDto);

    @GET("profile/answerFollowerId")
    Call<AnswerResponseDto> getAnswerFollower(@Body AnswerDto answerDto);

    @PUT("profile/addFollower/{followerId}/{userId}")
    Call<String> addFollower(@Path("followerId") String followerId , @Path("userId") String userId);

    @PUT("profile/addFollowing/{followingId}/{userId}")
    Call<String> addFollowing(@Path("followingId") String followingId , @Path("userId") String userId);

    @PUT("profile/addFollower/{points}/{userId}")
    Call<String> addPoints(@Path("points") int points , @Path("userId") String userId);

    @PUT("profile/addFollower/{moderatorId}/{userId}")
    Call<String> addModerator(@Path("moderatorId") String moderatorId , @Path("userId") String userId);

    @PUT("profile/addCategory")
    Call<String> addCategory(@Body CategoryDto categoryDto);

    @GET("profile/category/{userId}")
    Call<List<InterestDto>> getCategory(@Path("userId") String userId);

    @GET("profile/follower/{userId}")
    Call<List<UserDetailDto>> getFollower(@Path("userId") String userId);

    @GET("profile/following/{userId}")
    Call<List<UserDetailDto>> getFollowing(@Path("userId") String userId);

    @GET("profile/moderator/{userId}")
    Call<List<UserDetailDto>> getModerator(@Path("userId") String userId);

    @DELETE("profile/follower/{followerId}/{userId}")
    Call<String> removeFollower(@Path("followerId") String followerId,@Path("userId") String userId);

    @DELETE("profile/following/{followingId}/{userId}")
    Call<String> removeFollowing(@Path("followingId") String followingId,@Path("userId") String userId);

    @DELETE("profile/moderator/{moderatorId}/{userId}")
    Call<String> removeModerator(@Path("moderatorId") String moderatorId,@Path("userId") String userId);

    @DELETE("profile/category/{categoryId}/{userId}")
    Call<String> removeCategory(@Path("categoryId") String categoryId,@Path("userId") String userId);










}
