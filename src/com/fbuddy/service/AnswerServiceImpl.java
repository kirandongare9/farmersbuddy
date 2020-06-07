package com.fbuddy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fbuddy.dao.AnswerDao;
import com.fbuddy.dto.Answer;

@Service
public class AnswerServiceImpl implements AnswerService{

	@Autowired
	AnswerDao dao;
	
	@Override
	public void insert(Answer answer) {
		dao.insert(answer);
	}

	@Override
	public void delete(Answer answer) {
		dao.delete(answer);
	}

	@Override
	public void update(Answer answer) {
		dao.update(answer);
	}

	@Override
	public Answer get(Answer answer) {
		return dao.get(answer);
	}

	@Override
	public Answer get(int id) {
		return dao.get(id);
	}

	@Override
	public void like(int answerId) {
		dao.like(answerId);
	}

}
