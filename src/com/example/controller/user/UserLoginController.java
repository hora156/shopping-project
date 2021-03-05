package com.example.controller.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annotation.Component;

import com.example.controller.main.Controller;

@Component("/clientPage/loginPage.do")
public class UserLoginController implements Controller{

	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		return "/clientPage/loginPage.jsp";
	}
	

}
