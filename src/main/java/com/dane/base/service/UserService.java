package com.dane.base.service;

import java.util.List;

import com.dane.base.model.RoleModel;
import com.dane.base.model.UserModel;

public interface UserService {

	UserModel saveUser(UserModel user);

	RoleModel saveRole(RoleModel role);

	void addRoleToUser(String userName, String roleName);
	
	UserModel getUser(String userName);
	
	List<UserModel> getUsers();
}
