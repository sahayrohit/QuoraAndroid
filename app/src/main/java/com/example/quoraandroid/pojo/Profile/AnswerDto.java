package com.example.quoraandroid.pojo.Profile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerDto {
    private String questionAskerId;
    private String taggedProfileId;
    private String taggedProfileType;
    private String category;
    private String answerUserId;
}
