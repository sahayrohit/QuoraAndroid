package com.example.quoraandroid.pojo.Profile;

import com.example.quoraandroid.pojo.registration.Interest;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ExtraDetailsDto {


    String token;


    String channel;
    String profile;
    String role;
    List<InterestDto> category;


    public ExtraDetailsDto(String token, String channel, String profile, String role, List<InterestDto> category) {
        this.token = token;
        this.channel = channel;
        this.profile = profile;
        this.role = role;
        this.category = category;
    }
}