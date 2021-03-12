package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import com.annotation.Component;
import com.example.model.network.Header;
import com.example.model.network.request.OrderDetailApiRequest;
import com.example.model.network.request.OrderGroupApiRequest;
import com.example.model.network.response.OrderGroupApiResponse;

@Component("paymentDao")
public class PaymentApiService implements CrudInterface<OrderGroupApiRequest, OrderGroupApiResponse> {

	DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
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
	
	public int createOrderGroup(Header<OrderGroupApiRequest> request) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		int orderGroupId = 0;

		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement("insert into order_group "
					+ "(status, order_type, total_price, total_quantity, "
					+ "order_at, arrival_date, user_id)"
					+ "values"
					+ "(?, ?, ?, ?, NOW(), NOW() + INTERVAL 1 DAY, ?)");
			stmt.setString(1, request.getData().getStatus());
			stmt.setString(2, request.getData().getOrderType());
			stmt.setBigDecimal(3, request.getData().getTotalPrice());
			stmt.setLong(4, request.getData().getTotalQuantity());
			stmt.setLong(5, request.getData().getUserId());
			if(stmt.executeUpdate() == 1) {
				rs = stmt.executeQuery("select MAX(id) from order_group");
				if(rs.next()) {
					orderGroupId = rs.getInt("MAX(id)");
					return orderGroupId;
				}else {
					return -1;
				}
			}
			else
				return orderGroupId;

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
			try {
				if(rs != null)
					rs.close();
			} catch (Exception e) {
			}
		}
	}
	
	public boolean createOrderDetail(Header<OrderDetailApiRequest> request) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement("insert into order_detail "
					+ "(status, arrival_date, quantity, total_price, created_at, created_by, "
					+ "order_group_id, item_id)"
					+ "values"
					+ "(?, ?, ?, ?, ?, ?, ?, ?)");
			stmt.setString(1, request.getData().getStatus());
			stmt.setString(2, request.getData().getArrivalDate());
			stmt.setInt(3, request.getData().getQuantity());
			stmt.setBigDecimal(4, request.getData().getTotalPrice());
			stmt.setString(5, request.getData().getCreatedAt());
			stmt.setString(6, request.getData().getCreatedBy());
			stmt.setInt(7, request.getData().getOrderGroupId());
			stmt.setInt(8, request.getData().getItemId());
			if(stmt.executeUpdate() == 1) 
				return true;
			else
				return false;

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
			}
			try {
				if (connection != null)
					connection.close();
			} catch (Exception e) {
			}
		}
	}

}
