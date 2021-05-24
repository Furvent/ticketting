package fr.eql.ticketting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.repository.GroupRepository;
import fr.eql.ticketting.repository.UserRepository;

@SpringBootApplication
public class TickettingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TickettingApplication.class, args);
	}

	@Autowired
	UserRepository userRepository;
	@Autowired
	GroupRepository groupRepository;

	@Override
	public void run(String... args) throws Exception {
//		createUsers();
		User user1 = new User("login1", "password1", "pseudo1");
		createOneGroup(user1);
	}

	private void createUsers() {
		User user1 = new User("login1", "password1", "pseudo1");
		User user2 = new User("login2", "password2", "pseudo2");
		User user3 = new User("login3", "password3", "pseudo3");
		User user4 = new User("login4", "password4", "pseudo4");
		userRepository.save(user1);
		userRepository.save(user2);
		userRepository.save(user3);
		userRepository.save(user4);
	}

	private void createOneGroup(User user) {
		Group group1 = new Group("Group1", user);
		groupRepository.save(group1);
	}

}
