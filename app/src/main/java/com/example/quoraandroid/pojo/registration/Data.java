package com.example.quoraandroid.pojo.registration;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class Data{

	@SerializedName("emailAddress")
	private String emailAddress;

	@SerializedName("password")
	private String password;

	@SerializedName("role")
	private String role;


	@SerializedName("name")
	private String name;

	@SerializedName("channel")
	private String channel;

	@SerializedName("userId")
	private String userId;

	public void setEmailAddress(String emailAddress){
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress(){
		return emailAddress;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setRole(String role){
		this.role = role;
	}

	public String getRole(){
		return role;
	}





	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setChannel(String channel){
		this.channel = channel;
	}

	public String getChannel(){
		return channel;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}


}