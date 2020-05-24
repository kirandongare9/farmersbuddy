package com.fbuddy.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.fbuddy.dto.Answer;
import com.fbuddy.dto.Question;

@Repository
public class QuestionDaoImpl implements QuestionDao{

	@Autowired
	JdbcTemplate jt;
	
	@Override
	public void insert(Question question) {
		String sql = "insert into questions(question,created_date,created_by) values(?,curdate(),?)";
		jt.update(sql,question.getQuestion(),question.getCreatedBy());
	}

	@Override
	public void update(Question question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Question question) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Question get(int questionId) {

		String sql = "select * from questions where question_id = ? ";
		List<Map<String, Object>> result = jt.queryForList(sql,questionId);
		
			Question question = new Question();
			Map<String,Object> row1 = result.get(0);
			question.setQuestionId(Integer.parseInt(row1.get("question_id").toString()));
			question.setCreatedBy(row1.get("created_by").toString());
			question.setCreatedDate(row1.get("created_date").toString());
			question.setQuestion(row1.get("question").toString());
		
		return question;
	}

	@Override
	public List<Question> get() {
		
		String sql = "select * from questions";
		List<Map<String, Object>> result = jt.queryForList(sql);
		List<Question> questions = new ArrayList<Question>();
		
		result.forEach(row -> {
			Question question = new Question();
			question.setQuestionId(Integer.parseInt(row.get("question_id").toString()));
			question.setCreatedBy(row.get("created_by").toString());
			question.setCreatedDate(row.get("created_date").toString());
			question.setQuestion(row.get("question").toString());
			questions.add(question);
		});
		
		return questions;
	}

	@Override
	public List<Answer> getAnswers(int questionId) {
		String sql = "select * from answers where question_id = ? ";
		List<Map<String, Object>> result = jt.queryForList(sql,questionId);
		List<Answer> answers = new ArrayList<Answer>();
		
		result.forEach(row -> {
			
			Answer answer = new Answer();
			answer.setQuestionId(Integer.parseInt(row.get("answer_id")+""));
			answer.setQuestionId(Integer.parseInt(row.get("question_id")+""));
			answer.setCreatedBy(row.get("created_by")+"");
			answer.setCreatedDate(row.get("created_date")+"");
			answer.setAnswer(row.get("answer")+"");
			
			answers.add(answer);
		});
		
		return answers;
	}

}
