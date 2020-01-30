package com.example.quoraandroid.pojo.Profile;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerResponseDto {
    List<String> askerFollowerList;
    List<String> categoryFollowerList;
    List<String> tagFollowerList;
    List<String> moderatorList;
    List<String> answerFollowerList;
}
