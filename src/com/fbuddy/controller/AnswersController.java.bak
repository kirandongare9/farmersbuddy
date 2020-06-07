package com.fbuddy.controller;

import java.io.IOException;

import java.net.http.HttpResponse;
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
import com.fbuddy.util.CommonUtils;

@Controller
@RequestMapping(value="answers")
public class AnswersController {

	@Autowired
	AnswerService service;
	
	@Autowired
	CommonUtils utils;
	
	@GetMapping(value="/{answerId}")
	public String viewAnswer(@PathVariable int answerId) {
		
		return "answer/answer";
	}
	
	@GetMapping(value="/like/{answerId}")
	public void likeAnswer(@PathVariable int answerId,HttpServletResponse res , Model model) {
		
		Answer answer = service.get(answerId);
		
		service.like(answerId);
		utils.redirect("/Farmers-Buddy/questions/view/"+answer.getQuestionId(),res);
		
	}
	
	@GetMapping(value="/give/{questionId}")
	public String giveAnswer(@PathVariable int questionId, HttpSession session, Model model) {
		
		Answer answer = new Answer();
		answer.setQuestionId(questionId);
		answer.setCreatedBy(session.getAttribute("username").toString());
		model.addAttribute("answer" , answer);
		
		return "answer/giveAnswer";
	}
	
	@GetMapping(value="/edit/{answerId}")
	public String editAnswer(@PathVariable int answerId, HttpSession session, Model model) {
		
		Answer answer = service.get(answerId);
		model.addAttribute("answer" , answer);
		return "answer/editAnswer";
	}

	@GetMapping(value="/delete/{answerId}")
	public void deleteAnswer(@PathVariable int answerId, HttpServletResponse res , Model model) {

		Answer answer = service.get(answerId);
		service.delete(answer);

		try {
			res.sendRedirect("/Farmers-Buddy/questions/view/"+answer.getQuestionId());
		} catch (IOException e) {
			e.printStackTrace();
		}
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
	
	@PostMapping(value="/edit")
	public void postEditAnswer(@ModelAttribute("answer") Answer answer,HttpServletResponse res, HttpSession session, Model model) {
		
		//answer.setCreatedBy(session.getAttribute("username").toString());
		service.update(answer);
		
		try {
			res.sendRedirect("/Farmers-Buddy/questions/view/"+answer.getQuestionId());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
