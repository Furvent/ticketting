package fr.eql.ticketting;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.eql.ticketting.entity.Comment;
import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.Status;
import fr.eql.ticketting.entity.StatusHistory;
import fr.eql.ticketting.entity.Task;
import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.enums.TicketStatus;
import fr.eql.ticketting.service.CommentService;
import fr.eql.ticketting.service.GroupService;
import fr.eql.ticketting.service.MembershipService;
import fr.eql.ticketting.service.StatusHistoryService;
import fr.eql.ticketting.service.StatusService;
import fr.eql.ticketting.service.TaskService;
import fr.eql.ticketting.service.TicketService;
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
	@Autowired
	TicketService ticketService;
	@Autowired
	TaskService taskService;
	@Autowired
	StatusService statusService;
	@Autowired
	StatusHistoryService statusHistoryService;
	@Autowired
	CommentService commentService;

	@Override
	public void run(String... args) throws Exception {
		createUsers();
		createGroup();
		createMembership();
		createTickets();
	}

	private void createUsers() {
		User user1 = new User("testLogin", "testPassword", "testPseudo", LocalDateTime.now());
		userService.save(user1);
		User user2 = new User("login2", "password2", "pseudo2", LocalDateTime.now());
		userService.save(user2);
		User user3 = new User("login3", "password3", "pseudo3", LocalDateTime.now());
		userService.save(user3);
		User user4 = new User("login4", "password4", "pseudo4", LocalDateTime.now());
		userService.save(user4);
	}

	private void createGroup() {
		// Get my first user
		User user1 = userService.getUserWithId(1l);
		User user2 = userService.getUserWithId(2l);
		System.out.println(user1);
		// Create a group with it
		Group group1 = new Group("group1", user1, LocalDateTime.now());
		Group group2 = new Group("group2", user2, LocalDateTime.now());
		groupService.save(group1);
		groupService.save(group2);
	}

	private void createMembership() {
		// Get my first user
		User user1 = userService.getUserWithId(1l);
		User user2 = userService.getUserWithId(2l);
		User user3 = userService.getUserWithId(3l);
		User user4 = userService.getUserWithId(4l);
		// Get my first group
		Group group1 = groupService.getGroupById(1l);
		Group group2 = groupService.getGroupById(2l);
		// Create Membership to group 1
		Membership membership1ToGroup1 = new Membership(user1, group1, LocalDateTime.now());
		Membership membership2ToGroup1 = new Membership(user2, group1, LocalDateTime.now());
		Membership membership3ToGroup1 = new Membership(user3, group1, LocalDateTime.now());
		membershipService.save(membership1ToGroup1);
		membershipService.save(membership2ToGroup1);
		membershipService.save(membership3ToGroup1);
		// Create Membership to group 2
		Membership membership1ToGroup2 = new Membership(user2, group2, LocalDateTime.now());
		Membership membership2ToGroup2 = new Membership(user3, group2, LocalDateTime.now());
		Membership membership3ToGroup2 = new Membership(user1, group2, LocalDateTime.now());
		membershipService.save(membership1ToGroup2);
		membershipService.save(membership2ToGroup2);
		membershipService.save(membership3ToGroup2);

	}

	private void createTickets() {
		// Create 3 tickets
		Group group1 = groupService.getGroupById(1l);
		Ticket ticket1 = new Ticket("Ticket 1 details", group1);
		Ticket ticket2 = new Ticket("Ticket 2 details", group1);
		Ticket ticket3 = new Ticket("Ticket 3 details", group1);
		Ticket ticket4 = new Ticket("Ticket 4 details", group1);
		Ticket ticket5 = new Ticket("Ticket 5 details", group1);
		Ticket ticket6 = new Ticket("Ticket 6 details", group1);
		ticketService.save(ticket1);
		ticketService.save(ticket2);
		ticketService.save(ticket3);
		ticketService.save(ticket4);
		ticketService.save(ticket5);
		ticketService.save(ticket6);
		// Create task between ticket and user
		// Get users
		User user1 = userService.getUserWithId(1l);
		User user2 = userService.getUserWithId(2l);
		// Create new status
		Status statusOpened = new Status(TicketStatus.OPENED);
		Status statusAllocated = new Status(TicketStatus.ALLOCATED);
		Status statusDone = new Status(TicketStatus.DONE);
		Status statusClosed = new Status(TicketStatus.CLOSED);
		Status statusCanceled = new Status(TicketStatus.CANCELED);
		statusService.save(statusOpened);
		statusService.save(statusAllocated);
		statusService.save(statusDone);
		statusService.save(statusClosed);
		statusService.save(statusCanceled);
		// Populate ticket 1
		addStatusHistoryOnTicket(ticket1, statusOpened, LocalDateTime.of(2021, 5, 20, 10, 10));
		addTaskBetweenUserAndTicket(user1, ticket1, statusAllocated, LocalDateTime.of(2021, 5, 21, 10, 10));
		addStatusHistoryOnTicket(ticket1, statusDone, LocalDateTime.of(2021, 5, 22, 10, 10));
		addStatusHistoryOnTicket(ticket1, statusClosed, LocalDateTime.of(2021, 5, 23, 10, 10));
		// Populate ticket2
		addStatusHistoryOnTicket(ticket2, statusOpened, LocalDateTime.of(2021, 5, 18, 10, 10));
		addTaskBetweenUserAndTicket(user1, ticket2, statusAllocated, LocalDateTime.of(2021, 5, 19, 10, 10));
		addStatusHistoryOnTicket(ticket2, statusDone, LocalDateTime.of(2021, 5, 20, 10, 10));
		// Populate ticket3
		addStatusHistoryOnTicket(ticket3, statusOpened, LocalDateTime.of(2021, 5, 22, 10, 10));
		addTaskBetweenUserAndTicket(user1, ticket3, statusAllocated, LocalDateTime.of(2021, 5, 22, 11, 10));
		// Populate ticket4
		addStatusHistoryOnTicket(ticket4, statusOpened, LocalDateTime.of(2021, 5, 22, 10, 10));
		addTaskBetweenUserAndTicket(user1, ticket4, statusAllocated, LocalDateTime.of(2021, 5, 22, 11, 10));
		// Populate ticket5
		addStatusHistoryOnTicket(ticket5, statusOpened, LocalDateTime.of(2021, 5, 22, 10, 10));
		addTaskBetweenUserAndTicket(user2, ticket5, statusAllocated, LocalDateTime.of(2021, 5, 22, 11, 10));
		// Populate ticket6
		addStatusHistoryOnTicket(ticket6, statusOpened, LocalDateTime.of(2021, 5, 22, 10, 10));
		addTaskBetweenUserAndTicket(user2, ticket6, statusAllocated, LocalDateTime.of(2021, 5, 22, 11, 10));
		// Add comments on ticket 2 from user1 and user2;
		// Create new comment
		// Create parent comment
		Comment comment1 = new Comment("Comment 1 from user 1", LocalDateTime.now());
		comment1.setTicket(ticket2);
		comment1.setUser(user1);
		commentService.save(comment1);
		// Create child comment
		Comment commentChild1of1 = new Comment("Comment child 1 of comment 1, from user 2", LocalDateTime.now());
		commentChild1of1.setTicket(ticket2);
		commentChild1of1.setUser(user2);
		commentChild1of1.setParent(comment1);
		comment1.getChildren().add(commentChild1of1);
		commentService.save(commentChild1of1);
		commentService.save(comment1);
	}

	private void addTaskBetweenUserAndTicket(User user, Ticket ticket, Status statusAllocated, LocalDateTime taskTime) {
		// Create a task
		Task task = new Task(user, ticket, taskTime);
		// Add StatusHistory on ticket
		StatusHistory sh = new StatusHistory(statusAllocated, ticket, taskTime);
		// Save entity
		taskService.save(task);
		statusHistoryService.save(sh);
	}

	private void addStatusHistoryOnTicket(Ticket ticket, Status status, LocalDateTime taskTime) {
		// Add StatusHistory on ticket
		StatusHistory sh = new StatusHistory(status, ticket, taskTime);
		// Save entity
		statusHistoryService.save(sh);
	}

}
