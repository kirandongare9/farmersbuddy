package com.fbuddy.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fbuddy.dto.Question;
import com.fbuddy.dto.User;
import com.fbuddy.service.AnswerService;
import com.fbuddy.service.UserService;
import com.fbuddy.util.CommonUtils;




@Controller
@RequestMapping(value="admin")
public class AdminController {

	@Autowired
	UserService service;
	
	@Autowired
	CommonUtils utils;
	
	@GetMapping(value="/")
	public String getAdmin(Model model) {
		List<User> users = service.get();
		model.addAttribute("users",users);
		return "admin/adminOptions";
	}
	
	@GetMapping(value="/delete/{userId}")
	public void deleteUser(@PathVariable("userId") int userId, HttpServletResponse res , Model model) {
		service.delete(userId);
		utils.redirect("/Farmers-Buddy/admin/", res);
	}
	
	@GetMapping(value="/give/{userId}")
	public void give(@PathVariable int userId, HttpServletResponse res , Model model) {
		User user = service.get(userId);
		user.setRole("admin");
		service.update(user);
		utils.redirect("/Farmers-Buddy/admin/", res);
	}
	
	@GetMapping(value="/revoke/{userId}")
	public void revoke(@PathVariable int userId, HttpServletResponse res , Model model) {
		User user = service.get(userId);
		user.setRole("");
		service.update(user);
		utils.redirect("/Farmers-Buddy/admin/", res);
	}
	
}

