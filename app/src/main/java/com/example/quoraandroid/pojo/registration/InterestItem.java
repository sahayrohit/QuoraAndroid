package com.example.quoraandroid.pojo.registration;


import com.google.gson.annotations.SerializedName;


public class InterestItem{

	@SerializedName("interestId")
	private int interestId;

	@SerializedName("interestName")
	private String interestName;

	@SerializedName("user")
	private Object user;

	public void setInterestId(int interestId){
		this.interestId = interestId;
	}

	public int getInterestId(){
		return interestId;
	}

	public void setInterestName(String interestName){
		this.interestName = interestName;
	}

	public String getInterestName(){
		return interestName;
	}

	public void setUser(Object user){
		this.user = user;
	}

	public Object getUser(){
		return user;
	}

	@Override
 	public String toString(){
		return 
			"InterestItem{" + 
			"interestId = '" + interestId + '\'' + 
			",interestName = '" + interestName + '\'' + 
			",user = '" + user + '\'' + 
			"}";
		}
}