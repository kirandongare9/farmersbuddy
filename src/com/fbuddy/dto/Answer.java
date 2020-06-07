package com.fbuddy.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Answer {

	private int answerId;
	private String answer;
	private int questionId;
	private String createdBy;
	private String createdDate;
	private List<AnswerAttribute> attributes;
	
	private int likes;
	
	public int getAnswerId() {
		return answerId;
	}
	public void setAnswerId(int answerId) {
		this.answerId = answerId;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public List<AnswerAttribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<AnswerAttribute> attributes) {
		this.attributes = attributes;
	}
	public int getLikes() {
		return likes;
	}
	public void setLikes(int likes) {
		this.likes = likes;
	}
	
	
	
}
