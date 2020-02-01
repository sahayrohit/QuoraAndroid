package com.example.quoraandroid.pojo.questionAndAnswer;

import java.util.List;

public class GetQuestionsOfSelectedCategoriesRequestDto {

    List<String> categoryIdList;
    Integer pageNumber;
    Integer pageSize;
    String sortBy = "date";
}
