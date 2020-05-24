package com.fbuddy.dto;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Question {

	private int questionId;
	private String question;
	private String createdBy;
	private String createdDate;
	private List<QuestionAttribute> attributes;
	private List<Answer> answers;
	
	public int getQuestionId() {
		return questionId;
	}
	public void setQuestionId(int question_id) {
		this.questionId = question_id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String created_by) {
		this.createdBy = created_by;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String created_date) {
		this.createdDate = created_date;
	}
	public List<QuestionAttribute> getAttributes() {
		return attributes;
	}
	public void setAttributes(List<QuestionAttribute> attributes) {
		this.attributes = attributes;
	}
	public List<Answer> getAnswers() {
		return answers;
	}
	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}
	
	
	
	
}
