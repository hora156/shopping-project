package com.example.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.annotation.Component;
import com.example.controller.main.Controller;

@Component("/clientPage/logout.do")
public class UserLogoutController implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		HttpSession session = req.getSession();
		
		session.setAttribute("user", null);
		
		return "redirect:/shopping/mainPage/MainPage.do";
	}

}
