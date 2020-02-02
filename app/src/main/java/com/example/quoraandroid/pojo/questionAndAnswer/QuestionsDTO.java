package com.example.quoraandroid.pojo.questionAndAnswer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class QuestionsDTO {
    private String questionId;
    private String questionValue;
    private Boolean questionStatus;
    private String categoryId;
    private String categoryName;
    private Date date=new Date();
    private String askerProfileId;
    private String askerProfileName;
    private String profileWhereAskedId;
    private String profileWhereAskedName;
    private String profileWhereAskedType;
    private int numberOfLikes;
    private List<String> likeProfileIdList=new ArrayList<>();
    private int numberOfDislikes;
    private List<String> dislikeProfileIdList=new ArrayList<>();
    private List<String> emojisValue=new ArrayList<>();
    private List<String> emojisProfileIdList=new ArrayList<>();
    private Boolean isThreadOpen;
    private List<String> answerIdList=new ArrayList<>();
    private String approvedAnswerId;
    private String approvedAnswer;
    private String approvedAnswererId;
    private String approvedAnswererProfile;
}
