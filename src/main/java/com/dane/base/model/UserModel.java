package com.dane.base.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@Entity
@Table(name = "users")
@AllArgsConstructor
public class UserModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "firstname", length = 30, nullable = false)
	private String firstName;

	@Column(name = "lastname", length = 30, nullable = false)
	private String lastName;

	@Column(name = "username", unique = true, length = 30, nullable = false)
	private String userName;

	@Column(name = "email", unique = true, length = 200, nullable = false)
	private String email;

	@Column(name = "phone", length = 50, nullable = false)
	private String phone;

	@Column(name = "password", length = 200, nullable = false)
	private String password;

	@ManyToMany(fetch = FetchType.EAGER)
	private Collection<RoleModel> roles = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Collection<RoleModel> getRoles() {
		return roles;
	}

	public void setRoles(Collection<RoleModel> roles) {
		this.roles = roles;
	}

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(Long id, String firstName, String lastName, String userName, String email, String phone,
			String password, Collection<RoleModel> roles) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.roles = roles;
	}
	
	

}
