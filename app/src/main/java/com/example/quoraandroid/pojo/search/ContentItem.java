package com.example.quoraandroid.pojo.search;


import com.google.gson.annotations.SerializedName;


public class ContentItem{

	@SerializedName("profileValue")
	private String profileValue;

	@SerializedName("questionId")
	private Object questionId;

	@SerializedName("questionValue")
	private Object questionValue;

	@SerializedName("askerProfileId")
	private Object askerProfileId;

	@SerializedName("numberOfLikes")
	private int numberOfLikes;

	@SerializedName("numberOfDislikes")
	private int numberOfDislikes;

	@SerializedName("questionStatus")
	private Object questionStatus;

	@SerializedName("categoryName")
	private Object categoryName;

	@SerializedName("approvedAnswerId")
	private Object approvedAnswerId;

	@SerializedName("approvedAnswer")
	private Object approvedAnswer;

	@SerializedName("approvedAnswererProfile")
	private Object approvedAnswererProfile;

	@SerializedName("profileType")
	private String profileType;

	@SerializedName("searchId")
	private String searchId;

	@SerializedName("profileId")
	private String profileId;

	@SerializedName("valueType")
	private String valueType;

	@SerializedName("askerProfileName")
	private Object askerProfileName;

	@SerializedName("approvedAnswererId")
	private Object approvedAnswererId;

	@SerializedName("categoryId")
	private Object categoryId;

	public void setProfileValue(String profileValue){
		this.profileValue = profileValue;
	}

	public String getProfileValue(){
		return profileValue;
	}

	public void setQuestionId(Object questionId){
		this.questionId = questionId;
	}

	public Object getQuestionId(){
		return questionId;
	}

	public void setQuestionValue(Object questionValue){
		this.questionValue = questionValue;
	}

	public Object getQuestionValue(){
		return questionValue;
	}

	public void setAskerProfileId(Object askerProfileId){
		this.askerProfileId = askerProfileId;
	}

	public Object getAskerProfileId(){
		return askerProfileId;
	}

	public void setNumberOfLikes(int numberOfLikes){
		this.numberOfLikes = numberOfLikes;
	}

	public int getNumberOfLikes(){
		return numberOfLikes;
	}

	public void setNumberOfDislikes(int numberOfDislikes){
		this.numberOfDislikes = numberOfDislikes;
	}

	public int getNumberOfDislikes(){
		return numberOfDislikes;
	}

	public void setQuestionStatus(Object questionStatus){
		this.questionStatus = questionStatus;
	}

	public Object getQuestionStatus(){
		return questionStatus;
	}

	public void setCategoryName(Object categoryName){
		this.categoryName = categoryName;
	}

	public Object getCategoryName(){
		return categoryName;
	}

	public void setApprovedAnswerId(Object approvedAnswerId){
		this.approvedAnswerId = approvedAnswerId;
	}

	public Object getApprovedAnswerId(){
		return approvedAnswerId;
	}

	public void setApprovedAnswer(Object approvedAnswer){
		this.approvedAnswer = approvedAnswer;
	}

	public Object getApprovedAnswer(){
		return approvedAnswer;
	}

	public void setApprovedAnswererProfile(Object approvedAnswererProfile){
		this.approvedAnswererProfile = approvedAnswererProfile;
	}

	public Object getApprovedAnswererProfile(){
		return approvedAnswererProfile;
	}

	public void setProfileType(String profileType){
		this.profileType = profileType;
	}

	public String getProfileType(){
		return profileType;
	}

	public void setSearchId(String searchId){
		this.searchId = searchId;
	}

	public String getSearchId(){
		return searchId;
	}

	public void setProfileId(String profileId){
		this.profileId = profileId;
	}

	public String getProfileId(){
		return profileId;
	}

	public void setValueType(String valueType){
		this.valueType = valueType;
	}

	public String getValueType(){
		return valueType;
	}

	public void setAskerProfileName(Object askerProfileName){
		this.askerProfileName = askerProfileName;
	}

	public Object getAskerProfileName(){
		return askerProfileName;
	}

	public void setApprovedAnswererId(Object approvedAnswererId){
		this.approvedAnswererId = approvedAnswererId;
	}

	public Object getApprovedAnswererId(){
		return approvedAnswererId;
	}

	public void setCategoryId(Object categoryId){
		this.categoryId = categoryId;
	}

	public Object getCategoryId(){
		return categoryId;
	}

	@Override
 	public String toString(){
		return 
			"ContentItem{" + 
			"profileValue = '" + profileValue + '\'' + 
			",questionId = '" + questionId + '\'' + 
			",questionValue = '" + questionValue + '\'' + 
			",askerProfileId = '" + askerProfileId + '\'' + 
			",numberOfLikes = '" + numberOfLikes + '\'' + 
			",numberOfDislikes = '" + numberOfDislikes + '\'' + 
			",questionStatus = '" + questionStatus + '\'' + 
			",categoryName = '" + categoryName + '\'' + 
			",approvedAnswerId = '" + approvedAnswerId + '\'' + 
			",approvedAnswer = '" + approvedAnswer + '\'' + 
			",approvedAnswererProfile = '" + approvedAnswererProfile + '\'' + 
			",profileType = '" + profileType + '\'' + 
			",searchId = '" + searchId + '\'' + 
			",profileId = '" + profileId + '\'' + 
			",valueType = '" + valueType + '\'' + 
			",askerProfileName = '" + askerProfileName + '\'' + 
			",approvedAnswererId = '" + approvedAnswererId + '\'' + 
			",categoryId = '" + categoryId + '\'' + 
			"}";
		}
}