package com.example.quoraandroid.pojo.registration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Interest {

    String interestId;
    String interestName;

    public Interest(String interestId, String interestName) {
        this.interestId = interestId;
        this.interestName = interestName;
    }
}
