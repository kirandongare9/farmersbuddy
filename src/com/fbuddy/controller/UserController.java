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

import com.fbuddy.dto.User;
import com.fbuddy.service.UserService;

@Controller
@RequestMapping(value="users")
public class UserController {

	@Autowired
	UserService service;
	
	@GetMapping(value="/login")
	public String getLogin(Model model) {
		model.addAttribute("user",new User());
		return "user/login";
	}
	
	@PostMapping(value="/login")
	public void login(@ModelAttribute("user") User user,BindingResult result,HttpServletRequest req, HttpServletResponse res,Model model) {
		
		try {
			user = service.doAuth(user);
			if(user!=null) {
				HttpSession session = req.getSession(true);
				session.setAttribute("username", user.getUserName());
				res.sendRedirect("/Farmers-Buddy");
			}else {
				res.sendRedirect("/Farmers-Buddy/users/login");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	@GetMapping(value="/signup")
	public String getSignup(Model m) {
		m.addAttribute("user",new User());
		return "user/signup";
	}

	@PostMapping(value="/signup")
	public String signup(@ModelAttribute("user") User user,BindingResult result,HttpServletRequest req, HttpServletResponse res,Model model) {
		
		try {
			service.save(user);
			//res.sendRedirect("/Farmers-Buddy");
			model.addAttribute("user",user);
			return "user/login";
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		return "user/signup";
	}
	
	
	@GetMapping(value="/save")
	public String saveUser( HttpServletRequest req,HttpServletResponse res) {
		
		User user = new User();
		user.setName("Kiran ");
		user.setUserName("Kiran");
		user.setPswd("1234");
		user.setEmail("kiran@gmail.com");
		
		service.save(user);
		
		return "user/save";
	}
}
