package com.example.quoraandroid.pojo.Profile;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InterestDto {
    private String interestId;
    private String interestName;

    public InterestDto(String interestId, String interestName) {
        this.interestId = interestId;
        this.interestName = interestName;
    }
}
