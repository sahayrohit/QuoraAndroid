package com.example.quoraandroid.pojo.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

    private String commentId;
    private String parentId;
    private String comment;
    private int level;
}
