package com.example.quoraandroid.pojo;

//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class Data{

	@SerializedName("emailAddress")
	private String emailAddress;

	@SerializedName("password")
	private String password;

	@SerializedName("name")
	private String name;

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

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"emailAddress = '" + emailAddress + '\'' + 
			",password = '" + password + '\'' + 
			",name = '" + name + '\'' + 
			",userId = '" + userId + '\'' + 
			"}";
		}
}