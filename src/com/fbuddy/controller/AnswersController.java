package com.fbuddy.controller;

import java.io.IOException;
import java.net.http.HttpResponse;

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
import com.fbuddy.service.AnswerService;

@Controller
@RequestMapping(value="answers")
public class AnswersController {

	@Autowired
	AnswerService service;
	
	@GetMapping(value="/{answerId}")
	public String viewAnswer(@PathVariable int answerId) {
		
		return "answer/answer";
	}
	
	@GetMapping(value="/give/{questionId}")
	public String giveAnswer(@PathVariable int questionId, HttpSession session, Model model) {
		
		Answer answer = new Answer();
		answer.setQuestionId(questionId);
		answer.setCreatedBy(session.getAttribute("username").toString());
		model.addAttribute("answer" , answer);
		
		return "answer/giveAnswer";
	}
	
	@PostMapping(value="/give")
	public void giveAnswer(@ModelAttribute("answer") Answer answer,HttpServletResponse res, HttpSession session, Model model) {
		
		answer.setCreatedBy(session.getAttribute("username").toString());
		service.insert(answer);
		
		try {
			res.sendRedirect("/Farmers-Buddy/questions/view/"+answer.getQuestionId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
