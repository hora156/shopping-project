package com.example.controller.user;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annotation.Component;
import com.example.controller.main.Controller;
import com.service.UserServiceDaoImpl;

import lombok.Setter;

@Component("/user/list.do")
public class UserListController implements Controller {
	
	@Setter
	UserServiceDaoImpl userServiceDaoImpl;
	

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setAttribute("user", userServiceDaoImpl.userList());
		return "/test.jsp";
	}
	
	
	
}
