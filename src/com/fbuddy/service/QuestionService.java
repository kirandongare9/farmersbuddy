package com.fbuddy.service;

import java.util.List;

import com.fbuddy.dto.Answer;
import com.fbuddy.dto.Question;

public interface QuestionService {
	
	public void insert(Question question);
	public void update(Question question);
	public void delete(Question question);
	public Question get(int questionId);
	public List<Question> get();
	public List<Answer> getAnswers(int questionId);

	public void like(int questionId);
}