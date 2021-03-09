package com.example.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annotation.Component;
import com.example.controller.main.Controller;
import com.service.ItemApiService;

import lombok.Setter;

@Component("/clientPage/basketPage.do")
public class UserBasketController implements Controller{

	@Setter
	ItemApiService itemService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		
		
		return null;
	}

}
