package com.dane.base.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dane.base.model.RoleModel;
import com.dane.base.model.UserModel;
import com.dane.base.repository.RoleRepository;
import com.dane.base.repository.UserRepository;
import com.dane.base.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserServiceImp implements UserService, UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserModel user = userRepo.findByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}

		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
		});

		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
				authorities);
	}

	@Override
	public UserModel saveUser(UserModel user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}

	@Override
	public RoleModel saveRole(RoleModel role) {
		// TODO Auto-generated method stub
		return roleRepo.save(role);
	}

	@Override
	public void addRoleToUser(String userName, String roleName) {
		UserModel user = userRepo.findByUserName(userName);
		RoleModel role = roleRepo.findByName(roleName);

		user.getRoles().add(role);

	}

	@Override
	public UserModel getUser(String userName) {
		// TODO Auto-generated method stub
		return userRepo.findByUserName(userName);
	}

	@Override
	public List<UserModel> getUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

}
