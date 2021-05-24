package fr.eql.ticketting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.repository.GroupRepository;
import fr.eql.ticketting.repository.UserRepository;
import fr.eql.ticketting.service.GroupService;
import fr.eql.ticketting.service.MembershipService;
import fr.eql.ticketting.service.UserService;

@SpringBootApplication
public class TickettingApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TickettingApplication.class, args);
	}

	@Autowired
	UserService userService;
	@Autowired
	GroupService groupService;
	@Autowired
	MembershipService membershipService;

	@Override
	public void run(String... args) throws Exception {
		createUsers();
		createGroup();
		createMembership();
	}

	private void createUsers() {
		User user1 = new User("login1", "password1", "pseudo1");
		userService.save(user1);
		User user2 = new User("login2", "password2", "pseudo2");
		userService.save(user2);
		User user3 = new User("login3", "password3", "pseudo3");
		userService.save(user3);
		User user4 = new User("login4", "password4", "pseudo4");
		userService.save(user4);
	}

	public void createGroup() {
		// Get my first user
		User user1 = userService.getUserWithId(1l);
		System.out.println(user1);
		// Create a group with it
		Group group = new Group("group1", user1);
		groupService.save(group);
	}

	public void createMembership() {
		// Get my first user
		User user1 = userService.getUserWithId(1l);
		User user2 = userService.getUserWithId(2l);
		User user3 = userService.getUserWithId(3l);
		// Get my first group
		Group group1 = groupService.getGroupById(1l);
		// Create Membership
		Membership membership1 = new Membership(user1, group1);
		Membership membership2 = new Membership(user2, group1);
		Membership membership3 = new Membership(user3, group1);
		membershipService.save(membership1);
		membershipService.save(membership2);
		membershipService.save(membership3);
	}

}
