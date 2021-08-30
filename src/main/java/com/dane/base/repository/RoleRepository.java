package com.dane.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dane.base.model.RoleModel;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
	
	RoleModel findByName(String roleName);
	
}
