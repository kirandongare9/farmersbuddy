package com.fbuddy.dao;

import com.fbuddy.dto.Answer;

public interface AnswerDao {

	public void insert(Answer answer);
	public void delete(Answer answer);
	public void update(Answer answer);
	public Answer get(Answer answer);
	public Answer get(int id);
}
