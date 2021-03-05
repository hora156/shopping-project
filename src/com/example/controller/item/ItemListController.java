package com.example.controller.item;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annotation.Component;
import com.example.controller.main.Controller;
import com.service.ItemApiService;

import lombok.Setter;

@Component("/mainPage/MainPage.do")
public class ItemListController implements Controller {

	@Setter
	ItemApiService itemApiService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		req.setAttribute("item", itemApiService.itemList());
		req.setAttribute("category", itemApiService.categoryList());
		return "/mainPage/MainPage.jsp";
	}

}
