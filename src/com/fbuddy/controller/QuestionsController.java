package com.fbuddy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fbuddy.dto.Answer;
import com.fbuddy.dto.Question;
import com.fbuddy.service.AnswerService;
import com.fbuddy.service.QuestionService;
import com.fbuddy.util.CommonUtils;
		
@Controller
@RequestMapping(value="questions")
public class QuestionsController {
	
	@Autowired
	QuestionService service;
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	CommonUtils utils;
	
	@GetMapping(value="/")
	public String viewAllQuestions(Model model) {
		List<Question> questions = service.get();
		model.addAttribute("questions",questions);
		return "question/viewAllQuestions";
	}
	
	@GetMapping(value="/view/{questionId}")
	public String getQuestion(@PathVariable int questionId,Model model) {
	
		Question question = service.get(questionId);
		List<Answer> answers = service.getAnswers(questionId);
		question.setAnswers(answers);
		model.addAttribute("question",question);
		return "question/viewQuestion";
	}
	
	@GetMapping(value="/edit/{questionId}")
	public String editQuestion(@PathVariable int questionId,Model model) {
	
		Question question = service.get(questionId);
		model.addAttribute("question",question);
		return "question/editQuestion";
	}
	
	@GetMapping(value="/like/{questionId}")
	public void likeQuestion(@PathVariable int questionId,HttpServletResponse res , Model model) {
		
		service.like(questionId);
		utils.redirect("/Farmers-Buddy/questions/",res);
		
	}
	
	@GetMapping(value="/delete/{questionId}")
	public void deleteQuestion(@PathVariable int questionId, HttpServletResponse res , Model model) {
	
		Question question = service.get(questionId);
		List<Answer> answers = service.getAnswers(questionId);
		service.delete(question);
		
		answers.forEach(answer-> {
			answerService.delete(answer);
		});
		
		try {
			res.sendRedirect("/Farmers-Buddy/questions/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(value="/post")
	public String postQuestion(HttpSession session , Model model) {
		
		model.addAttribute("question",new Question());
		
		return "question/postQuestion";
	}
	
	@PostMapping(value="/post")
	public void postQuestion(@ModelAttribute("question") Question question, HttpServletResponse res, HttpSession session , Model model) {
		
		question.setCreatedBy(session.getAttribute("username").toString());
		service.insert(question);
		model.addAttribute("question",question);
		
		//return "question/postQuestion";
		try {
			res.sendRedirect("/Farmers-Buddy/questions/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@PostMapping(value="/edit")
	public void postEditQuestion(@ModelAttribute("question") Question question, HttpServletResponse res, HttpSession session , Model model) {
		
		//question.(session.getAttribute("username").toString());
		
		service.update(question);
		
		try {
			res.sendRedirect("/Farmers-Buddy/questions/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
