package com.fbuddy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fbuddy.dto.AgriOfficer;
import com.fbuddy.dto.User;
import com.fbuddy.service.UserService;

@Controller
@RequestMapping(value="officers")
public class OfficerController {

	@Autowired
	UserService service;
	
	@GetMapping(value="/signup")
	public String getSignup(Model model) {
		model.addAttribute("officer",new AgriOfficer());
		return "officer/signup";
	}
	
	@PostMapping(value="/signup")
	public String postSignup(@ModelAttribute("officer") AgriOfficer officer,BindingResult result,HttpServletRequest req, HttpServletResponse res,Model model) {
		try {
			service.saveAgriOfficer(officer);
			model.addAttribute("user",officer.getUser());
			
			return "user/login";
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return "officer/signup";
	}
	
	
}
