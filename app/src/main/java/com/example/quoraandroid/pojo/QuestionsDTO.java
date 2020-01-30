package com.example.quoraandroid.pojo;

import java.util.ArrayList;
import java.util.List;



public class QuestionsDTO {

    private String questionId;
    private String questionValue;
    private boolean questionStatus;
    private String profileId;
    private String profileName;
    private int numberOfLikes;
    private List<String> likeProfileIdList=new ArrayList<>();
    private int numberOfDislikes;
    private List<String> dislikeProfileIdList=new ArrayList<>();
    private List<String> emojiValue=new ArrayList<>();
    private List<String> emojiProfileIdList=new ArrayList<>();
    private boolean isThreadOpen;
    private List<String> answerIdList=new ArrayList<>();
    private String approvedAnswerId;
}
