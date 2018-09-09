package com.metademy.microservices.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "RequestComments")
public class RequestComments {

	private String commentId;
	private String requestId;
	private String personnelId;
	private String dateTime;
	private String comment;
	private Long id;	

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public String getPersonnelId() {
		return personnelId;
	}

	public void setPersonnelId(String personnelId) {
		this.personnelId = personnelId;
	}

	public String getDateTime() {
		return dateTime;
	}

	public void setDateTime(String dateTime) {
		this.dateTime = dateTime;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
