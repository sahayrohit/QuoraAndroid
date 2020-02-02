package com.example.quoraandroid.pojo.questionAndAnswer.getAllAnsOfQuestionId;

import java.util.List;

import com.google.gson.annotations.SerializedName;


public class ContentItem{

	@SerializedName("answerId")
	private String answerId;

	@SerializedName("date")
	private String date;

	@SerializedName("answerStatus")
	private boolean answerStatus;

	@SerializedName("likeProfileIdList")
	private List<Object> likeProfileIdList;

	@SerializedName("emojiValue")
	private List<Object> emojiValue;

	@SerializedName("profileWhereAskedName")
	private Object profileWhereAskedName;

	@SerializedName("questionId")
	private String questionId;

	@SerializedName("question")
	private String question;

	@SerializedName("numberOfLikes")
	private int numberOfLikes;

	@SerializedName("numberOfDislikes")
	private int numberOfDislikes;

	@SerializedName("profileWhereAskedId")
	private Object profileWhereAskedId;

	@SerializedName("profileNameOfAnswerer")
	private String profileNameOfAnswerer;

	@SerializedName("profileIdOfAnswerer")
	private String profileIdOfAnswerer;

	@SerializedName("dislikeProfileIdList")
	private List<Object> dislikeProfileIdList;

	@SerializedName("questionAskerId")
	private Object questionAskerId;

	@SerializedName("answerValue")
	private String answerValue;

	@SerializedName("emojiProfileIdList")
	private List<Object> emojiProfileIdList;

	@SerializedName("questionAskerName")
	private Object questionAskerName;

	@SerializedName("profileWhereAskedType")
	private Object profileWhereAskedType;

	public void setAnswerId(String answerId){
		this.answerId = answerId;
	}

	public String getAnswerId(){
		return answerId;
	}

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setAnswerStatus(boolean answerStatus){
		this.answerStatus = answerStatus;
	}

	public boolean isAnswerStatus(){
		return answerStatus;
	}

	public void setLikeProfileIdList(List<Object> likeProfileIdList){
		this.likeProfileIdList = likeProfileIdList;
	}

	public List<Object> getLikeProfileIdList(){
		return likeProfileIdList;
	}

	public void setEmojiValue(List<Object> emojiValue){
		this.emojiValue = emojiValue;
	}

	public List<Object> getEmojiValue(){
		return emojiValue;
	}

	public void setProfileWhereAskedName(Object profileWhereAskedName){
		this.profileWhereAskedName = profileWhereAskedName;
	}

	public Object getProfileWhereAskedName(){
		return profileWhereAskedName;
	}

	public void setQuestionId(String questionId){
		this.questionId = questionId;
	}

	public String getQuestionId(){
		return questionId;
	}

	public void setQuestion(String question){
		this.question = question;
	}

	public String getQuestion(){
		return question;
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

	public void setProfileWhereAskedId(Object profileWhereAskedId){
		this.profileWhereAskedId = profileWhereAskedId;
	}

	public Object getProfileWhereAskedId(){
		return profileWhereAskedId;
	}

	public void setProfileNameOfAnswerer(String profileNameOfAnswerer){
		this.profileNameOfAnswerer = profileNameOfAnswerer;
	}

	public String getProfileNameOfAnswerer(){
		return profileNameOfAnswerer;
	}

	public void setProfileIdOfAnswerer(String profileIdOfAnswerer){
		this.profileIdOfAnswerer = profileIdOfAnswerer;
	}

	public String getProfileIdOfAnswerer(){
		return profileIdOfAnswerer;
	}

	public void setDislikeProfileIdList(List<Object> dislikeProfileIdList){
		this.dislikeProfileIdList = dislikeProfileIdList;
	}

	public List<Object> getDislikeProfileIdList(){
		return dislikeProfileIdList;
	}

	public void setQuestionAskerId(Object questionAskerId){
		this.questionAskerId = questionAskerId;
	}

	public Object getQuestionAskerId(){
		return questionAskerId;
	}

	public void setAnswerValue(String answerValue){
		this.answerValue = answerValue;
	}

	public String getAnswerValue(){
		return answerValue;
	}

	public void setEmojiProfileIdList(List<Object> emojiProfileIdList){
		this.emojiProfileIdList = emojiProfileIdList;
	}

	public List<Object> getEmojiProfileIdList(){
		return emojiProfileIdList;
	}

	public void setQuestionAskerName(Object questionAskerName){
		this.questionAskerName = questionAskerName;
	}

	public Object getQuestionAskerName(){
		return questionAskerName;
	}

	public void setProfileWhereAskedType(Object profileWhereAskedType){
		this.profileWhereAskedType = profileWhereAskedType;
	}

	public Object getProfileWhereAskedType(){
		return profileWhereAskedType;
	}

	@Override
 	public String toString(){
		return 
			"ContentItem{" + 
			"answerId = '" + answerId + '\'' + 
			",date = '" + date + '\'' + 
			",answerStatus = '" + answerStatus + '\'' + 
			",likeProfileIdList = '" + likeProfileIdList + '\'' + 
			",emojiValue = '" + emojiValue + '\'' + 
			",profileWhereAskedName = '" + profileWhereAskedName + '\'' + 
			",questionId = '" + questionId + '\'' + 
			",question = '" + question + '\'' + 
			",numberOfLikes = '" + numberOfLikes + '\'' + 
			",numberOfDislikes = '" + numberOfDislikes + '\'' + 
			",profileWhereAskedId = '" + profileWhereAskedId + '\'' + 
			",profileNameOfAnswerer = '" + profileNameOfAnswerer + '\'' + 
			",profileIdOfAnswerer = '" + profileIdOfAnswerer + '\'' + 
			",dislikeProfileIdList = '" + dislikeProfileIdList + '\'' + 
			",questionAskerId = '" + questionAskerId + '\'' + 
			",answerValue = '" + answerValue + '\'' + 
			",emojiProfileIdList = '" + emojiProfileIdList + '\'' + 
			",questionAskerName = '" + questionAskerName + '\'' + 
			",profileWhereAskedType = '" + profileWhereAskedType + '\'' + 
			"}";
		}
}