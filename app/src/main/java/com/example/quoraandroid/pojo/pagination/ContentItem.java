package com.example.quoraandroid.pojo.pagination;


import com.google.gson.annotations.SerializedName;


public class ContentItem{

	@SerializedName("level")
	private int level;

	@SerializedName("commentId")
	private String commentId;

	@SerializedName("comment")
	private String comment;

	@SerializedName("userId")
	private String userId;

	@SerializedName("parentId")
	private String parentId;

	public void setLevel(int level){
		this.level = level;
	}

	public int getLevel(){
		return level;
	}

	public void setCommentId(String commentId){
		this.commentId = commentId;
	}

	public String getCommentId(){
		return commentId;
	}

	public void setComment(String comment){
		this.comment = comment;
	}

	public String getComment(){
		return comment;
	}

	public void setUserId(String userId){
		this.userId = userId;
	}

	public String getUserId(){
		return userId;
	}

	public void setParentId(String parentId){
		this.parentId = parentId;
	}

	public String getParentId(){
		return parentId;
	}

	@Override
 	public String toString(){
		return 
			"ContentItem{" + 
			"level = '" + level + '\'' + 
			",commentId = '" + commentId + '\'' + 
			",comment = '" + comment + '\'' + 
			",userId = '" + userId + '\'' + 
			",parentId = '" + parentId + '\'' + 
			"}";
		}
}