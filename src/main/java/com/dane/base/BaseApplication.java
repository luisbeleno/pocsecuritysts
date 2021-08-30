package com.dane.base;

import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.dane.base.model.RoleModel;
import com.dane.base.model.UserModel;
import com.dane.base.service.UserService;

@SpringBootApplication
public class BaseApplication {

	public static void main(String[] args) {
		SpringApplication.run(BaseApplication.class, args);
	}
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new RoleModel(null, "ROLE_USER"));
			userService.saveRole(new RoleModel(null, "ROLE_MANAGER"));
			userService.saveRole(new RoleModel(null, "ROLE_ADMIN"));
			userService.saveRole(new RoleModel(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new UserModel(null, "Luis", "Beleño", "luis.beleno", "ing.luisfernando@gmail.com",
					"3505930983", "123456789", new ArrayList<>()));
			
			userService.saveUser(new UserModel(null, "Rafael", "Mejia", "rafael.mejia", "rafamejia@gmail.com",
					"3216548974", "123456789", new ArrayList<>()));
			
			userService.addRoleToUser("luis.beleno", "ROLE_MANAGER");
			userService.addRoleToUser("luis.beleno", "ROLE_USER");
			
			userService.addRoleToUser("rafael.mejia", "ROLE_ADMIN");
			userService.addRoleToUser("rafael.mejia", "ROLE_SUPER_ADMIN");

		};
	}
}
