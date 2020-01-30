package com.example.quoraandroid.pojo.questionAndAnswer;

import java.util.ArrayList;
import java.util.List;

public class AnswerDTO {

    private String answerId;
    private String questionId;
    private String answerValue;
    private String profileIdOfAnswerer;
    private String profileNameOfAnswerer;
    private int numberOfLikes;
    private List<String> likeProfileIdList=new ArrayList<>();
    private int numberOfDislikes;
    private List<String> dislikeProfileIdList=new ArrayList<>();
    private List<String> emojiValue=new ArrayList<>();
    private List<String> emojiProfileIdList=new ArrayList<>();
}
