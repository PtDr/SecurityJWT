package com.example.securityCannevas;

import com.example.securityCannevas.entity.Authority;
import com.example.securityCannevas.entity.Users;
import com.example.securityCannevas.service.AuthorityService;
import com.example.securityCannevas.service.UsersService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SecurityCannevasApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityCannevasApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AuthorityService authorityService, UsersService usersService){
		return args -> {
			List<Authority> authorities = new ArrayList<>();

			authorities.add(authorityService.save(new Authority(null, "CREATE_USER")));
			authorities.add(authorityService.save(new Authority(null, "LIST_USER")));

			if (usersService.findByUserName("user")==null)
				usersService.save(new Users(null, "user", "user", "1", "user@mail.mail", "1234567", authorities));
		};
	}

}
