package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.annotation.Component;
import com.example.model.entity.User;

@Component("userDao")
public class userServiceDaoImpl implements UserServiceDao {
	DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}
	@Override
	public List<User> userList() throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT id,account,status,email,phone_number" +
										" FROM user" +
										" ORDER BY id ASC");

			ArrayList<User> userList = new ArrayList<User>();

			while (rs.next()) {
				new User();
				userList.add(User.builder()
						.id(rs.getInt("id"))
						.account(rs.getString("account"))
						.status(rs.getString("status"))
						.email(rs.getString("email"))
						.phoneNumber(rs.getString("phone_number")).build());
			}

			return userList;

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
	public int create(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public User detailUser(int no) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(User user) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
