package com.service;

import com.annotation.Component;
import com.example.model.network.Header;
import com.example.model.network.request.OrderGroupApiRequest;
import com.example.model.network.response.OrderGroupApiResponse;

@Component("paymentDao")
public class PaymentApiService implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

	@Override
	public Boolean create(Header<OrderGroupApiRequest> request) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<OrderGroupApiResponse> read(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<OrderGroupApiResponse> update(Header<OrderGroupApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
