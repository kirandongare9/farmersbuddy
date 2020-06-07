package com.fbuddy.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fbuddy.dto.Answer;
import com.fbuddy.dto.Question;

@Repository
public class AnswerDaoImpl implements AnswerDao{

	@Autowired
	JdbcTemplate jt;
	
	public void insert(Answer answer) {
		String sql = "insert into answers(answer,question_id,created_date,created_by) values(?,?,curdate(),?)";
		jt.update(sql,answer.getAnswer(),answer.getQuestionId(),answer.getCreatedBy());
	}


	public void delete(Answer answer) {
		String sql = "delete from answers where answer_id = ?";
		jt.update(sql,answer.getAnswerId());
	}

	public void update(Answer answer) {
		String sql = "update answers set answer = ? where answer_id = ?";
		jt.update(sql,answer.getAnswer(),answer.getAnswerId());
		
	}

	public Answer get(Answer answer) {
		// TODO Auto-generated method stub
		return null;
	}

	public Answer get(int id) {

		String sql = "select * from answers where answer_id = ? ";
		List<Map<String, Object>> result = jt.queryForList(sql,id);
		
			Answer answer = new Answer();
			Map<String,Object> row1 = result.get(0);
			answer.setQuestionId(Integer.parseInt(row1.get("question_id").toString()));
			answer.setCreatedBy(row1.get("created_by").toString());
			answer.setCreatedDate(row1.get("created_date").toString());
			answer.setAnswer(row1.get("answer").toString());
			answer.setAnswerId(Integer.parseInt(row1.get("answer_id").toString()));
			answer.setLikes(Integer.parseInt(row1.get("likes").toString()));
			
		return answer;
	}


	@Override
	public void like(int answerId) {
		String sql = "update answers set likes = likes+1 where answer_id = ?";
		jt.update(sql,answerId);
		
	}

}
