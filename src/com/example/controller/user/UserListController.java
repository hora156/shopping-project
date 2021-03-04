package com.example.controller.user;

import java.util.Map;

import com.annotation.Component;
import com.service.UserServiceDao;

import lombok.Setter;

@Component("/user/list.do")
public class UserListController implements Controller {
	
	@Setter
	UserServiceDao userSrivceDao;
	

	@Override
	public String execute(Map<String, Object> model) throws Exception {
		model.put("user", userSrivceDao.read());
		return "/test.jsp";
	}

}
