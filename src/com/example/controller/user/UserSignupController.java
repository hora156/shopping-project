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

import lombok.Setter;

@Component("/clientPage/signupPage.do")
public class UserSignupController implements Controller, DataBinding {

	@Setter
	UserServiceDaoImpl userService;
	
	@SuppressWarnings("null")
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		if(req.getMethod().equalsIgnoreCase("GET")) {
			System.out.println("get");
			return "/clientPage/signupPage.jsp";
			
		} else if(req.getMethod().equalsIgnoreCase("POST")) {
			
//			Header<UserApiRequest> userApiRequest = null;
			
			new UserApiRequest();
			UserApiRequest data = UserApiRequest.builder()
					.account(req.getParameter("account"))
					.password(req.getParameter("psw"))
					.status("REGISTERED")
					.email(req.getParameter("email"))
					.phoneNumber(req.getParameter("phone_number"))
					.build();
			System.out.println(data.toString());
			
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
