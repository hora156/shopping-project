package com.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.annotation.Component;
import com.example.model.entity.User;
import com.example.model.network.Header;
import com.example.model.network.request.UserApiRequest;
import com.example.model.network.response.UserApiResponse;

@Component("userDao")
public class UserServiceDaoImpl implements CrudInterface<UserApiRequest, UserApiResponse> {
	DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Header<UserApiResponse> create(Header<UserApiRequest> UserApiRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<UserApiResponse> read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header<UserApiResponse> update(Header<UserApiRequest> UserApiRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Header delete(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Header<ArrayList<UserApiResponse>> userList() throws Exception{
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			rs = stmt.executeQuery("SELECT id,account,status,email,phone_number" +
										" FROM user" +
										" ORDER BY id ASC");

			ArrayList<UserApiResponse> userList = new ArrayList<UserApiResponse>();

			while (rs.next()) {
				new UserApiResponse();
				userList.add(UserApiResponse.builder()
						.id(rs.getInt("id"))
						.account(rs.getString("account"))
						.status(rs.getString("status"))
						.email(rs.getString("email"))
						.phoneNumber(rs.getString("phone_number")).build());
			}

			return Header.OK(userList);

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
	
    private UserApiResponse response(User user) {
        // user -> userApiResponse

        UserApiResponse userApiResponse = UserApiResponse.builder()
                .id(user.getId())
                .account(user.getAccount())
                .password(user.getPassword())       // todo 암호화, 길이
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .status(user.getStatus())
                .registeredAt(user.getRegisteredAt())
                .unregisteredAt(user.getUnregisteredAt())
                .build();

        // Header + data return
        return userApiResponse;

    }
	
}
