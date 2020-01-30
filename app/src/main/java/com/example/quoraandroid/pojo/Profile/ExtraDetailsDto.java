package com.example.quoraandroid.pojo.Profile;

import java.util.List;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ExtraDetailsDto {


    String userId;
    String phoneNumber;
    String imageURL;
    String profileType;
    List<String> moderatorId;
}