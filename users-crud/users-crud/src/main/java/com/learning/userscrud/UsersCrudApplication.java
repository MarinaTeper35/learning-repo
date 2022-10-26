package com.learning.userscrud;

import com.learning.userscrud.model.User;
import com.learning.userscrud.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
public class UsersCrudApplication  {

	public static void main(String[] args) {
System.out.println(System.getenv("DB_HOSTNAME"));

		System.out.println(System.getenv("DB_PORT"));
		SpringApplication.run(UsersCrudApplication.class, args);
	}

	@Autowired
	private UsersRepository usersRepository;

}
