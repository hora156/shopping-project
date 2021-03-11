package com.example.controller.payment;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annotation.Component;
import com.example.controller.main.Controller;
import com.example.model.network.Header;
import com.example.model.network.response.ItemApiResponse;
import com.service.ItemApiService;

import lombok.Setter;

@Component("/payment/kakao.do")
public class KaKaoPaymentController implements Controller {

	@Setter
	ItemApiService itemService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int id = Integer.parseInt(req.getParameter("item_id"));
		
		Header<ItemApiResponse> item = itemService.read(id);
		BigDecimal price = new BigDecimal(req.getParameter("count"));
		
		req.setAttribute("item", item);
		req.setAttribute("count", req.getParameter("count"));
		
		BigDecimal totalPrice = price.multiply(item.getData().getPrice());
		
		req.setAttribute("totalPrice", totalPrice);
		
		
		return "/paymentPage/kakao.jsp";
		
	}

}
