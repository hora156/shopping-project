package com.example.controller.user;

import java.util.Map;

import com.annotation.Component;
import com.service.UserServiceDaoImpl;

import lombok.Setter;

@Component("/user/list.do")
public class UserListController implements Controller {
	
	@Setter
	UserServiceDaoImpl userServiceDaoImpl;
	

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("user", userServiceDaoImpl.UserList());
		return "/test.jsp";
	}

}
