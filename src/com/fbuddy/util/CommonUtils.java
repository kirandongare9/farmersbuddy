package com.fbuddy.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

@Component
public class CommonUtils {

	public void redirect(String url,HttpServletResponse response) {
		try {
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
