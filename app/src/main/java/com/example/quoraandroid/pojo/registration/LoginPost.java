package com.example.quoraandroid.pojo.registration;

public class LoginPost {

    String emailAddress;
    String password;
    String fcmToken;
    String channel;

    public LoginPost(String emailAddress, String password, String fcmToken, String channel) {
        this.emailAddress = emailAddress;
        this.password = password;
        this.fcmToken = fcmToken;
        this.channel = channel;
    }
}
