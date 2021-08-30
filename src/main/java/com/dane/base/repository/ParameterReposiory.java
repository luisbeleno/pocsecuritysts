package com.dane.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dane.base.model.ParameterModel;

public interface ParameterReposiory extends JpaRepository<ParameterModel, Long> {
	
	ParameterModel findByName(String name);

}
