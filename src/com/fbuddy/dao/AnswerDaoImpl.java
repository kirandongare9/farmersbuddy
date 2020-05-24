package com.fbuddy.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fbuddy.dto.Answer;

@Repository
public class AnswerDaoImpl implements AnswerDao{

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public void insert(Answer answer) {
		String sql = "insert into answers(answer,question_id,created_date,created_by) values(?,?,curdate(),?)";
		jt.update(sql,answer.getAnswer(),answer.getQuestionId(),answer.getCreatedBy());
	}

	@Override
	public void delete(Answer answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Answer answer) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Answer get(Answer answer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Answer get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
