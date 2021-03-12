package com.example.controller.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annotation.Component;
import com.example.controller.main.Controller;
import com.example.model.network.Header;
import com.example.model.network.request.OrderDetailApiRequest;
import com.example.model.network.request.OrderGroupApiRequest;
import com.service.PaymentApiService;

import lombok.Setter;

@Component("/paymentPage/completPayment.do")
public class CompletPayment implements Controller {

	@Setter
	PaymentApiService paymentApiService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int itemId = Integer.parseInt(req.getParameter("item_id"));
		BigDecimal totalPrice = new BigDecimal(req.getParameter("total_price"));
		int userId = Integer.parseInt(req.getParameter("user_id"));
		String nowDay = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
		String plusDay = LocalDateTime.now().plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss"));
		new OrderGroupApiRequest();
		OrderGroupApiRequest orderGroupApiRequest = 
				OrderGroupApiRequest.builder()
					.status("REGISTERED")
					.orderType("Kakao Pay")
					.arrivalDate(plusDay)
					.userId(userId)
					.totalPrice(totalPrice)
					.totalQuantity(1)
					.build();
		
		int orderGroupId = paymentApiService.createOrderGroup(Header.OK(orderGroupApiRequest));
		
		new OrderDetailApiRequest();
		OrderDetailApiRequest orderDetail = OrderDetailApiRequest.builder()
				.status("REGISTERED")
				.arrivalDate(plusDay)
				.quantity(Integer.parseInt(req.getParameter("quantity")))
				.totalPrice(totalPrice)
				.createdAt(nowDay)
				.createdBy("AdminUser")
				.orderGroupId(orderGroupId)
				.itemId(itemId)
				.build();
		
		paymentApiService.createOrderDetail(Header.OK(orderDetail));
		
		
		return "redirect:completePayment.jsp";
	}

}
