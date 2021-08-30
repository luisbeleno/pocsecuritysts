package com.dane.base.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "parameters")
@NoArgsConstructor
@AllArgsConstructor
public class ParameterModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nameparam", length = 100, nullable = false)
	private String name;
	
	@Column(name = "typeparam", length = 30, nullable = false)
	private String type;
	
	@Column(name = "valueparam", length = 250, nullable = false)
	private String value;
	
	@Column(name = "active", length = 1, nullable = false)
	private String active;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public ParameterModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ParameterModel(Long id, String name, String type, String value, String active) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.value = value;
		this.active = active;
	}
	
	

}
