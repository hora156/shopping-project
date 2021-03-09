package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.sql.DataSource;

import com.annotation.Component;
import com.example.model.entity.Category;
import com.example.model.network.Header;
import com.example.model.network.request.ItemApiRequest;
import com.example.model.network.response.ItemApiResponse;
import com.example.model.network.response.UserApiResponse;

@Component("itemDao")
public class ItemApiService implements CrudInterface<ItemApiRequest, ItemApiResponse> {

	DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	
	@Override
	public Boolean create(Header<ItemApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<ItemApiResponse> read(int id) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT id,status,name,title,content,price,brand_name" +
										" FROM item" +
										" where id = " + id);
			ItemApiResponse item = new ItemApiResponse();
			if(rs.next()) {
				item = ItemApiResponse.builder()
						.id(rs.getInt("id"))
						.status(rs.getString("status"))
						.name(rs.getString("name"))
						.title(rs.getString("title"))
						.content(rs.getString("content"))
						.price(rs.getBigDecimal("price"))
						.brandName(rs.getString("brand_name"))
						.build();
			}else {
				return Header.ERROR("해당페이지를 찾지 못함");
			}

			return Header.OK(item);

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

	@Override
	public Header<ItemApiResponse> update(Header<ItemApiRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Header<ArrayList<ItemApiResponse>> itemList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT id,status,name,title,content,price,brand_name" +
										" FROM item" +
										" ORDER BY id ASC");
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
	
	
	public Header<ArrayList<Category>> categoryList() throws Exception{
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT id,type,title" +
										" FROM category" +
										" ORDER BY id ASC");
			ArrayList<Category> categoryList = new ArrayList<Category>();

			while (rs.next()) {
				new Category();
				categoryList.add(Category.builder()
						.id(rs.getInt("id"))
						.type(rs.getString("type"))
						.title(rs.getString("title"))
						.build());
			}

			return Header.OK(categoryList);

		} catch (Exception e) {
			throw e;

		}
	}
	
	

}
