package com.example.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annotation.Component;
import com.example.controller.main.Controller;
import com.service.ItemApiService;

import lombok.Setter;

@Component("/clientPage/payment.do")
public class UserPaymentController implements Controller {

	@Setter
	ItemApiService itemService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int id = Integer.parseInt(req.getParameter("item_id"));
		
		req.setAttribute("item", itemService.read(id));
		req.setAttribute("quantity", req.getParameter("quantity"));
		return "/clientPage/paymentPage.jsp";
	}

}
