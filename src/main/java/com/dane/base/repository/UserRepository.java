package com.dane.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dane.base.model.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
	
	UserModel findByUserName(String userName);
}
