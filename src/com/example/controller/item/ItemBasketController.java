package com.example.controller.item;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.annotation.Component;
import com.example.bind.DataBinding;
import com.example.controller.main.Controller;
import com.example.model.entity.User;
import com.example.model.network.Header;
import com.example.model.network.request.BasketApiRequest;
import com.example.model.network.request.ItemApiRequest;
import com.service.BasketApiService;
import com.service.ItemApiService;

import lombok.Setter;

@Component("/clientPage/basket.do")
public class ItemBasketController implements Controller, DataBinding {

	@Setter
	BasketApiService basketService;
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		int id = 0;
		
		if(req.getMethod().equalsIgnoreCase("GET")) {
			
			 req.setAttribute("itemList", basketService.basketList( 
					Integer.parseInt(req.getParameter("user_id")) 
					) 
			);
			return "/clientPage/basketPage.jsp";
			
		}else if(req.getMethod().equalsIgnoreCase("POST")) {
			
			new BasketApiRequest();
			BasketApiRequest itemRequest = BasketApiRequest.builder()
					.status("basket")
					.quantity(Integer.parseInt(req.getParameter("quantity")))
					.userId(Integer.parseInt(req.getParameter("user_id")))
					.itemId(Integer.parseInt(req.getParameter("item_id")))
					.build();
			
			if(basketService.create(Header.OK(itemRequest))) {
				id =  Integer.parseInt(req.getParameter("item_id"));
				
				return "redirect:detailItem.do?id="+id;
			}else {
				return "에러 페이지";
			}
			
			
			
		}
		
		return "redirect:detailItem.do";
	}

	@Override
	public Object[] getDataBinders() {
		return new Object[]{
		        "item_id", Integer.class,
		        "quantity", Integer.class,
		        "user_id", Integer.class
		    };
	}

}
