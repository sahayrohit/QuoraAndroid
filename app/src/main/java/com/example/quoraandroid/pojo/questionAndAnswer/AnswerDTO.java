package com.example.quoraandroid.pojo.questionAndAnswer;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDTO {



    private String answerId;
    private String questionId;
    private String question;
    private String questionAskerId;
    private String questionAskerName;
    private String answerValue;
    private String profileWhereAskedId;
    private String profileWhereAskedName;
    private String profileWhereAskedType;
    private String profileIdOfAnswerer;
    private String profileNameOfAnswerer;
    private int numberOfLikes;
    private List<String> likeProfileIdList=new ArrayList<>();
    private int numberOfDislikes;
    private List<String> dislikeProfileIdList=new ArrayList<>();
    private List<String> emojiValue=new ArrayList<>();
    private List<String> emojiProfileIdList=new ArrayList<>();
}
