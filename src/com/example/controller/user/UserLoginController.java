package com.example.controller.user;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.annotation.Component;
import com.example.bind.DataBinding;
import com.example.controller.main.Controller;
import com.example.model.network.Header;
import com.example.model.network.response.UserApiResponse;
import com.service.UserServiceDaoImpl;
import com.util.SHA256Util;

import lombok.Setter;

@Component("/clientPage/loginPage.do")
public class UserLoginController implements Controller, DataBinding {

	@Setter
	UserServiceDaoImpl userService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return "/clientPage/loginPage.jsp";
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			
			String account = req.getParameter("account");
			String password = req.getParameter("password");
			HttpSession session = req.getSession();
			
			String userSalt = userService.getSalt(account);
			String newPassword = SHA256Util.getEncrypt(password, userSalt);
			
			Header<UserApiResponse> user = userService.loginUser(account, newPassword);
			
			if(user.getResultCode().equals("ERROR")) {
				req.setAttribute("error", "아이디 또는 비밀번호가 일치하지 않습니다.");
				
				
				return "/clientPage/loginPage.jsp";
			}else {
				
				session.setAttribute("user", user);
				return "redirect:/shopping/mainPage/MainPage.do";
			}
		}else
			return null;
		
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[]{
				"account", String.class,
				"password", String.class
		    };
	}
	

}
