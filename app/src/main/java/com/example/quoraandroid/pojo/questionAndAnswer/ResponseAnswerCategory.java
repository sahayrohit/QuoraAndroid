package com.example.quoraandroid.pojo.questionAndAnswer;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ResponseAnswerCategory{

	@SerializedName("categoryIdList")
	private List<String> categoryIdList;

	public void setCategoryIdList(List<String> categoryIdList){
		this.categoryIdList = categoryIdList;
	}

	public List<String> getCategoryIdList(){
		return categoryIdList;
	}

	@Override
 	public String toString(){
		return 
			"ResponseAnswerCategory{" + 
			"categoryIdList = '" + categoryIdList + '\'' + 
			"}";
		}
}