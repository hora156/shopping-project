package com.example.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annotation.Component;
import com.example.bind.DataBinding;
import com.example.controller.main.Controller;
import com.example.model.network.Header;
import com.example.model.network.request.UserApiRequest;
import com.example.model.network.request.UserApiRequest.UserApiRequestBuilder;
import com.service.UserServiceDaoImpl;
import com.util.SHA256Util;

import lombok.Setter;

@Component("/clientPage/signupPage.do")
public class UserSignupController implements Controller, DataBinding {

	@Setter
	UserServiceDaoImpl userService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return "/clientPage/signupPage.jsp";
		} 
		else if(req.getMethod().equalsIgnoreCase("POST")) {
			
			
			new UserApiRequest();
			UserApiRequest data = UserApiRequest.builder()
					.account(req.getParameter("account"))
					.password(req.getParameter("psw"))
					.status("REGISTERED")
					.email(req.getParameter("email"))
					.phoneNumber(req.getParameter("phone_number"))
					.build();
			// 암호화 작업
			String salt = SHA256Util.generateSalt();
			String newPassword = SHA256Util.getEncrypt(data.getPassword(), salt);
			
			data.setPassword(newPassword);
			data.setSalt(salt);
			
			userService.create(Header.OK(data));
			return "redirect:/shopping/clientPage/loginPage.do";
			
		}else {
			Header.ERROR("페이지를 찾을 수 없습니다.");
			return null;
		}
		
	}
	
	@Override
	public Object[] getDataBinders() {
		return new Object[]{
				"account", String.class,
				"psw", String.class,
				"phone_number", String.class,
		        "email", String.class
		    };
	}

}
