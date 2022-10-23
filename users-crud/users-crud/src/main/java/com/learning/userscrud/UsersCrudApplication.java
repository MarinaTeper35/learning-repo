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
public class UsersCrudApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(UsersCrudApplication.class, args);
	}

	@Autowired
	private UsersRepository usersRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User();
		user.setFirstName("Marina");
		user.setLastName("Teper");
		usersRepository.save(user);

		User user1 = new User();
		user1.setFirstName("Sergey");
		user1.setLastName("Teper");
		usersRepository.save(user1);
	}
}
