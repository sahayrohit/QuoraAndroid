package com.example.quoraandroid.pojo.registration;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SignUp {
    private String channel;
    private String profile;
    private String role;

    public SignUp(String channel, String profile, String role) {
        this.channel = channel;
        this.profile = profile;
        this.role = role;
    }
}
