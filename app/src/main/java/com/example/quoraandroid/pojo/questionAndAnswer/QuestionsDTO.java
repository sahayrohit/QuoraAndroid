package com.example.quoraandroid.pojo.questionAndAnswer;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class QuestionsDTO {

    private String questionId;
    private String questionValue;
    private boolean questionStatus;
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
    private boolean isThreadOpen;
    private List<String> answerIdList=new ArrayList<>();
    private String approvedAnswerId;
}
