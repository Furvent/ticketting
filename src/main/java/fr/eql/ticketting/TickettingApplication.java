package fr.eql.ticketting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.repository.UserRepository;

@SpringBootApplication
public class TickettingApplication implements CommandLineRunner {

	public static void main(String[] args)  {
		SpringApplication.run(TickettingApplication.class, args);
	}
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		User user = new User("login", "password", "pseudo");
		User user1 = new User("login1", "password1", "pseudo1");
		userRepository.save(user);
		userRepository.save(user1);
//		userIdTest();
	}
	
//	private void userIdTest() {
//		User user2 = new User("login2", "password2", "pseudo2");
//		userRepository.save(user2);
//		System.out.println(user2);
//	}

}
