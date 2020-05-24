package com.fbuddy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbuddy.dao.QuestionDao;
import com.fbuddy.dto.Answer;
import com.fbuddy.dto.Question;

@Service
public class QuestionServiceImpl implements QuestionService{

	@Autowired
	QuestionDao dao;
	
	@Override
	public void insert(Question question) {
		dao.insert(question);
		
	}

	@Override
	public void update(Question question) {
		dao.update(question);
	}

	@Override
	public void delete(Question question) {
		dao.delete(question);
	}

	@Override
	public Question get(int questionId) {
		return dao.get(questionId);
	}

	@Override
	public List<Question> get() {
		return dao.get();
	}

	@Override
	public List<Answer> getAnswers(int questionId) {
		return dao.getAnswers(questionId);
	}

}
