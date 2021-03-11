package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.annotation.Component;
import com.example.model.entity.User;
import com.example.model.network.Header;
import com.example.model.network.request.UserApiRequest;
import com.example.model.network.response.ItemApiResponse;
import com.example.model.network.response.UserApiResponse;

@Component("userDao")
public class UserServiceDaoImpl implements CrudInterface<UserApiRequest, UserApiResponse> {
	DataSource ds;

	public void setDataSource(DataSource ds) {
		this.ds = ds;
	}

	@Override
	public Boolean create(Header<UserApiRequest> userApiRequest) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;

		try {
			connection = ds.getConnection();
			stmt = connection.prepareStatement("insert into user "
					+ "(account, password, status, email, "
					+ "phone_number, created_at, created_by)"
					+ "values"
					+ "(?, ?, ?, ?, ?, NOW(), ?)");
			stmt.setString(1, userApiRequest.getData().getAccount());
			stmt.setString(2, userApiRequest.getData().getPassword());
			stmt.setString(3, userApiRequest.getData().getStatus());
			stmt.setString(4, userApiRequest.getData().getEmail());
			stmt.setString(5, userApiRequest.getData().getPhoneNumber());
			stmt.setString(6, "Admin_User");
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
	
	public Header<UserApiResponse> loginUser(String account, String password) throws Exception {
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			connection = ds.getConnection();
			stmt = connection.createStatement();
			System.out.println(account);
			System.out.println(password);
			rs = stmt.executeQuery("SELECT id, account, email, phone_number" +
										" FROM user" +
										" where account = '" + account +
										"' AND password = '" + password + "'");
			UserApiResponse user = new UserApiResponse();
			if(rs.next()) {
				user = UserApiResponse.builder()
						.id(rs.getInt("id"))
						.account(rs.getString("account"))
						.email(rs.getString("email"))
						.phoneNumber(rs.getString("phone_number"))
						.build();
			}else {
				return Header.ERROR("존재하지 않는 아이디입니다.");
			}
			return Header.OK(user);

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
