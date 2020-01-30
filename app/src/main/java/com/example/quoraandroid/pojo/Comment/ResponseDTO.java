package com.example.quoraandroid.pojo.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {
    private Boolean success;
    private String message;
    private T data;
}
