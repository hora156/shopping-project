package com.example.controller.item;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annotation.Component;
import com.example.bind.DataBinding;
import com.example.controller.main.Controller;
import com.service.ItemApiService;

import lombok.Setter;

@Component("/clientPage/detailItem.do")
public class ItemDetailController implements Controller, DataBinding {

	@Setter
	ItemApiService itemApiService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String id = req.getParameter("id");
		req.setAttribute("item", itemApiService.read(Integer.parseInt(id)));
		return "/clientPage/detailItem.jsp";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[]{
		        "id", Integer.class
		    };
	}

}
