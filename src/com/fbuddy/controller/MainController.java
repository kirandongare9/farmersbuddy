package com.fbuddy.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.fbuddy.dto.User;

@Controller("/")
public class MainController{
	
	@GetMapping(value="/")
	public void index(HttpServletRequest req,HttpServletResponse res) {
		try {
			res.sendRedirect("questions/");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(value="/logout")
	public void getLogin(HttpServletResponse res , HttpSession session , Model model) {
		session.invalidate();
		try {
			res.sendRedirect("users/login");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}