package com.fbuddy.util;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor{

	@Override
	   public boolean preHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	      HttpSession session = request.getSession();
	      String url = request.getRequestURI();
	      
	      List<Function<String, Boolean>> allowedPaths = new ArrayList<Function<String,Boolean>> ();
	      
	      List<Function<String, Boolean>> nonAllowedPaths = new ArrayList<Function<String,Boolean>> ();
	      nonAllowedPaths.add( path -> path.contains("/post"));
	      nonAllowedPaths.add( path -> path.contains("/give/"));
	      nonAllowedPaths.add( path -> path.contains("/edit"));
	      nonAllowedPaths.add( path -> path.contains("/delete"));
	      nonAllowedPaths.add( path -> path.contains("/admin"));
	  	  
	      boolean restricted = false;
	      for(int i=0;i<nonAllowedPaths.size();i++) {
	    	  if(nonAllowedPaths.get(i).apply(url))
	    		  restricted = true;  
	      }
	      
	      
	      if( restricted )
	    	  if(session!=null && session.getAttribute("username")!=null)
	    		  return true;
	    	  else {
	    		  response.sendRedirect("/Farmers-Buddy/users/login");   
	    		  return false;
	    	  }
	      
	      return true;
	   }
	
	   @Override
	   public void postHandle(
	      HttpServletRequest request, HttpServletResponse response, Object handler, 
	      ModelAndView modelAndView) throws Exception {}
	   
	   @Override
	   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
	      Object handler, Exception exception) throws Exception {}
}
