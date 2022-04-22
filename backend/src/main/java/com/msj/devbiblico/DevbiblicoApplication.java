package com.msj.devbiblico;

import com.msj.devbiblico.domain.enums.RoleEnum;
import com.msj.devbiblico.domain.model.User;
import com.msj.devbiblico.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@SpringBootApplication
@EnableFeignClients
public class DevbiblicoApplication {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(DevbiblicoApplication.class, args);
	}

	@Bean
	CommandLineRunner runner (UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args -> {
			initCreateUser(userRepository, passwordEncoder);
		};
	}

	private void initCreateUser(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		User admin = new User();
		admin.setEmail("user2@emial.com");
		admin.setUsername("user2");
		admin.setPassword("123");
		admin.setRole(RoleEnum.ROLE_USER);

//		Optional<User> find = userRepository.findByUsername("admin");
//		if (find == null) {
//			userRepository.save(admin);
//		}

		//userRepository.save(admin);
	}

}
