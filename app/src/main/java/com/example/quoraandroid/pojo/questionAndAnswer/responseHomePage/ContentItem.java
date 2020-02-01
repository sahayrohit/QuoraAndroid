package com.example.quoraandroid.pojo.questionAndAnswer.responseHomePage;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ContentItem{

	@SerializedName("date")
	private String date;

	@SerializedName("likeProfileIdList")
	private List<Object> likeProfileIdList;

	@SerializedName("answerIdList")
	private List<String> answerIdList;

	@SerializedName("profileWhereAskedName")
	private String profileWhereAskedName;

	@SerializedName("questionId")
	private String questionId;

	@SerializedName("questionValue")
	private String questionValue;

	@SerializedName("askerProfileId")
	private String askerProfileId;

	@SerializedName("numberOfLikes")
	private int numberOfLikes;

	@SerializedName("numberOfDislikes")
	private int numberOfDislikes;

	@SerializedName("profileWhereAskedId")
	private String profileWhereAskedId;

	@SerializedName("questionStatus")
	private boolean questionStatus;

	@SerializedName("approvedAnswerId")
	private String approvedAnswerId;

	@SerializedName("emojisProfileIdList")
	private List<Object> emojisProfileIdList;

	@SerializedName("dislikeProfileIdList")
	private List<Object> dislikeProfileIdList;

	@SerializedName("approvedAnswer")
	private Object approvedAnswer;

	@SerializedName("approvedAnswererProfile")
	private String approvedAnswererProfile;

	@SerializedName("emojisValue")
	private List<Object> emojisValue;

	@SerializedName("isThreadOpen")
	private boolean isThreadOpen;

	@SerializedName("askerProfileName")
	private String askerProfileName;

	@SerializedName("profileWhereAskedType")
	private String profileWhereAskedType;

	@SerializedName("approvedAnswererId")
	private String approvedAnswererId;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setLikeProfileIdList(List<Object> likeProfileIdList){
		this.likeProfileIdList = likeProfileIdList;
	}

	public List<Object> getLikeProfileIdList(){
		return likeProfileIdList;
	}

	public void setAnswerIdList(List<String> answerIdList){
		this.answerIdList = answerIdList;
	}

	public List<String> getAnswerIdList(){
		return answerIdList;
	}

	public void setProfileWhereAskedName(String profileWhereAskedName){
		this.profileWhereAskedName = profileWhereAskedName;
	}

	public String getProfileWhereAskedName(){
		return profileWhereAskedName;
	}

	public void setQuestionId(String questionId){
		this.questionId = questionId;
	}

	public String getQuestionId(){
		return questionId;
	}

	public void setQuestionValue(String questionValue){
		this.questionValue = questionValue;
	}

	public String getQuestionValue(){
		return questionValue;
	}

	public void setAskerProfileId(String askerProfileId){
		this.askerProfileId = askerProfileId;
	}

	public String getAskerProfileId(){
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

	public void setProfileWhereAskedId(String profileWhereAskedId){
		this.profileWhereAskedId = profileWhereAskedId;
	}

	public String getProfileWhereAskedId(){
		return profileWhereAskedId;
	}

	public void setQuestionStatus(boolean questionStatus){
		this.questionStatus = questionStatus;
	}

	public boolean isQuestionStatus(){
		return questionStatus;
	}

	public void setApprovedAnswerId(String approvedAnswerId){
		this.approvedAnswerId = approvedAnswerId;
	}

	public String getApprovedAnswerId(){
		return approvedAnswerId;
	}

	public void setEmojisProfileIdList(List<Object> emojisProfileIdList){
		this.emojisProfileIdList = emojisProfileIdList;
	}

	public List<Object> getEmojisProfileIdList(){
		return emojisProfileIdList;
	}

	public void setDislikeProfileIdList(List<Object> dislikeProfileIdList){
		this.dislikeProfileIdList = dislikeProfileIdList;
	}

	public List<Object> getDislikeProfileIdList(){
		return dislikeProfileIdList;
	}

	public void setApprovedAnswer(Object approvedAnswer){
		this.approvedAnswer = approvedAnswer;
	}

	public Object getApprovedAnswer(){
		return approvedAnswer;
	}

	public void setApprovedAnswererProfile(String approvedAnswererProfile){
		this.approvedAnswererProfile = approvedAnswererProfile;
	}

	public String getApprovedAnswererProfile(){
		return approvedAnswererProfile;
	}

	public void setEmojisValue(List<Object> emojisValue){
		this.emojisValue = emojisValue;
	}

	public List<Object> getEmojisValue(){
		return emojisValue;
	}

	public void setIsThreadOpen(boolean isThreadOpen){
		this.isThreadOpen = isThreadOpen;
	}

	public boolean isIsThreadOpen(){
		return isThreadOpen;
	}

	public void setAskerProfileName(String askerProfileName){
		this.askerProfileName = askerProfileName;
	}

	public String getAskerProfileName(){
		return askerProfileName;
	}

	public void setProfileWhereAskedType(String profileWhereAskedType){
		this.profileWhereAskedType = profileWhereAskedType;
	}

	public String getProfileWhereAskedType(){
		return profileWhereAskedType;
	}

	public void setApprovedAnswererId(String approvedAnswererId){
		this.approvedAnswererId = approvedAnswererId;
	}

	public String getApprovedAnswererId(){
		return approvedAnswererId;
	}

	@Override
 	public String toString(){
		return 
			"ContentItem{" + 
			"date = '" + date + '\'' + 
			",likeProfileIdList = '" + likeProfileIdList + '\'' + 
			",answerIdList = '" + answerIdList + '\'' + 
			",profileWhereAskedName = '" + profileWhereAskedName + '\'' + 
			",questionId = '" + questionId + '\'' + 
			",questionValue = '" + questionValue + '\'' + 
			",askerProfileId = '" + askerProfileId + '\'' + 
			",numberOfLikes = '" + numberOfLikes + '\'' + 
			",numberOfDislikes = '" + numberOfDislikes + '\'' + 
			",profileWhereAskedId = '" + profileWhereAskedId + '\'' + 
			",questionStatus = '" + questionStatus + '\'' + 
			",approvedAnswerId = '" + approvedAnswerId + '\'' + 
			",emojisProfileIdList = '" + emojisProfileIdList + '\'' + 
			",dislikeProfileIdList = '" + dislikeProfileIdList + '\'' + 
			",approvedAnswer = '" + approvedAnswer + '\'' + 
			",approvedAnswererProfile = '" + approvedAnswererProfile + '\'' + 
			",emojisValue = '" + emojisValue + '\'' + 
			",isThreadOpen = '" + isThreadOpen + '\'' + 
			",askerProfileName = '" + askerProfileName + '\'' + 
			",profileWhereAskedType = '" + profileWhereAskedType + '\'' + 
			",approvedAnswererId = '" + approvedAnswererId + '\'' + 
			"}";
		}
}