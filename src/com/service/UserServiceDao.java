package com.service;

import java.util.List;

import com.example.model.entity.User;


public interface UserServiceDao {
	  List<User> userList() throws Exception;
	  int create(User user) throws Exception;
	  int delete(int no) throws Exception;
	  User detailUser(int no) throws Exception;
	  int update(User user) throws Exception;
//	  User exist(String email, String password) throws Exception;
}
