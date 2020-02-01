package com.example.quoraandroid.pojo.registration;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegistrationDTO {




    String name;
    String emailAddress;
    String password;
    String userId;
    public UserRegistrationDTO(String name, String emailAddress, String password, String userId) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.password = password;
        this.userId = userId;
    }



}
