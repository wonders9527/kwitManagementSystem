package com.kwit.service;

import java.util.List;

import com.kwit.model.UserTable;

public interface UserService {

	List<UserTable> getAll();
	
	List<UserTable> getUser(String userName,String passWord);
	
	List<UserTable> login(String userName,String passWord);

}
