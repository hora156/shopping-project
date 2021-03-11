package com.example.controller.payment;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annotation.Component;
import com.example.controller.main.Controller;

@Component("/payment/completPayment.do")
public class CompletPayment implements Controller {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int itemId = Integer.parseInt(req.getParameter("item_id"));
		BigDecimal totalPrice = new BigDecimal(req.getParameter("total_price"));
		int userId = Integer.parseInt(req.getParameter("user_id"));
		
		
		
		req.getSession().getAttribute("user.data.id");
		
		return null;
	}

}
