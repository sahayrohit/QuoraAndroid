package com.example.quoraandroid.pojo.questionAndAnswer;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DislikesDTO {
    private String profileId;
    private String questionOrAnswerId;
    private String profileName;
    private String askerOrAnswererId;
}
