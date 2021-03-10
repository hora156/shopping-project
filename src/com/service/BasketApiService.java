package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.annotation.Component;
import com.example.model.network.Header;
import com.example.model.network.request.BasketApiRequest;
import com.example.model.network.response.BasketApiResponse;
import com.example.model.network.response.ItemApiResponse;
import com.example.model.network.response.UserApiResponse;

@Component("basketDao")
public class BasketApiService implements CrudInterface<BasketApiRequest, BasketApiResponse> {
	DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	@Override
	public Boolean create(Header<BasketApiRequest> request) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement("insert into basket "
					+ "(status, quantity, created_at, user_id, item_id)"
					+ "values"
					+ "(?, ?, NOW(), ?, ?)");
			stmt.setString(1, request.getData().getStatus());
			stmt.setInt(2, request.getData().getQuantity());
			stmt.setInt(3, request.getData().getUserId());
			stmt.setInt(4, request.getData().getItemId());
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

	@Override
	public Header<BasketApiResponse> read(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<BasketApiResponse> update(Header<BasketApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Header<ArrayList<ItemApiResponse>> basketList(int id) throws Exception{
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT id,status,name,title,content,price,brand_name " 
										+ "from item where id = "
										+ "any("
										+ "select item_id from basket where user_id = " + id 
										+ ")");

			ArrayList<ItemApiResponse> itemList = new ArrayList<ItemApiResponse>();

			while (rs.next()) {
				new ItemApiResponse();
				itemList.add(ItemApiResponse.builder()
						.id(rs.getInt("id"))
						.status(rs.getString("status"))
						.name(rs.getString("name"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.price(rs.getBigDecimal("price"))
						.brandName(rs.getString("brand_name"))
						.build());
			}

			return Header.OK(itemList);

		} catch (Exception e) {
			throw e;

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (Exception e) {
			}
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
