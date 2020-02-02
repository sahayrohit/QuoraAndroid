package com.example.quoraandroid.pojo.Profile;

import com.google.gson.annotations.SerializedName;

public class ProfileResponse{

	@SerializedName("string")
	private String string;

	public void setString(String string){
		this.string = string;
	}

	public String getString(){
		return string;
	}

	@Override
 	public String toString(){
		return 
			"ProfileResponse{" + 
			"string = '" + string + '\'' + 
			"}";
		}
}