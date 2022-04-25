package io.getarrays.userservice;

import io.getarrays.userservice.domain.Appuser;
import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run (UserService userService){
		return args -> {

			Role user = new Role(null,"ROLE_USER");
			Role manager = new Role(null,"ROLE_MANAGER");
			Role admin = new Role(null,"ROLE_ADMIN");
			Role superadmin = new Role(null,"ROLE_SUPER_ADMIN");

			Appuser john = new Appuser(null, "John Travolta", "john", "1234", new ArrayList<>());
			Appuser will = new Appuser(null, "Will Smith", "will", "1234", new ArrayList<>());
			Appuser jim = new Appuser(null, "Jim Carry", "jim", "1234", new ArrayList<>());
			Appuser arnold = new Appuser(null, "Arnold Schwarzenegger", "arnold", "1234", new ArrayList<>());

			userService.saveRole(user);
			userService.saveRole(manager);
			userService.saveRole(admin);
			userService.saveRole(superadmin);

			userService.saveAppuser(john);
			userService.saveAppuser(will);
			userService.saveAppuser(jim);
			userService.saveAppuser(arnold);

			userService.addRoleToUser(john.getUsername(), user.getName());
			userService.addRoleToUser(john.getUsername(), manager.getName());
			userService.addRoleToUser(will.getUsername(), manager.getName());
			userService.addRoleToUser(jim.getUsername(), admin.getName());
			userService.addRoleToUser(arnold.getUsername(), superadmin.getName());
			userService.addRoleToUser(arnold.getUsername(), admin.getName());
			userService.addRoleToUser(arnold.getUsername(), user.getName());
		};
	}

}
