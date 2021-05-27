package fr.eql.ticketting.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eql.ticketting.controller.form.TicketForm;
import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.Status;
import fr.eql.ticketting.entity.StatusHistory;
import fr.eql.ticketting.entity.Task;
import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.service.GroupService;
import fr.eql.ticketting.service.MembershipService;
import fr.eql.ticketting.service.StatusHistoryService;
import fr.eql.ticketting.service.StatusService;
import fr.eql.ticketting.service.TaskService;
import fr.eql.ticketting.service.TicketService;
import fr.eql.ticketting.service.UserService;

@Controller
public class TicketController {

	TicketService service;
	StatusService statusService;
	GroupService groupService;
	MembershipService membershipService;
	UserService userService;
	StatusHistoryService historyService;
	TaskService taskService;

	@ModelAttribute("ticketForm")
	public TicketForm addConvAttributeInModel() {
		return new TicketForm();
	}

	public TicketController(TicketService service, StatusService statusService, GroupService groupService,
			MembershipService membershipService, UserService userService, StatusHistoryService historyService,
			TaskService taskService) {
		this.service = service;
		this.statusService = statusService;
		this.groupService = groupService;
		this.membershipService = membershipService;
		this.userService = userService;
		this.historyService = historyService;
		this.taskService = taskService;
	}

	@GetMapping("/list-tickets")
	public String displayUsers(Model model) {
		List<Ticket> tickets = service.getAllTickets();
		model.addAttribute("tickets", tickets);
		return "ticketsDebug";
	}

	@GetMapping("/newTicket")
	public String formAddTicket(Model model) {

		List<Status> status = new ArrayList<Status>();
		status = statusService.getAllStatus();
		model.addAttribute("status", status);

		List<User> users = new ArrayList<User>();
		//Ajouter la sélection du groupe
		users = displayUsersByGroup();
		model.addAttribute("users", users);

		return "newTicket";
	}

	private List<User> displayUsersByGroup() {
		Group group = groupService.getGroupById(1L);
		List<Membership> memberships = membershipService.getMembershipsWithGroup(group);
		List<User> users = new ArrayList<User>();
		for (Membership membership : memberships) {
			users.add(membership.getUser());
		}
		return users;
	}

	@PostMapping("/addNewTicket")
	public String addNewTicket() {
		return "GeneralDashboard";
	}

	//Méthode pour tester la selection sur une liste déroulante
	@GetMapping("/test/test-SelectMenu")
	public String testMenu(Model model){
		List<Status> status = new ArrayList<Status>();
		status = statusService.getAllStatus();
		model.addAttribute("status", status);
		Status selectedStatus = new Status();
		model.addAttribute("aStatus", selectedStatus);
		return "/test/test-SelectMenu";
	}

	//Page renvoyée par le test
	@PostMapping("/test/test-SelectMenu2")
	public String testMenu2(@ModelAttribute("ticketForm") TicketForm ticketForm, Model model2) {
		Long idStatus = ticketForm.getIdStatus();
		String description = ticketForm.getDescription();
		List<Long> idUsers = ticketForm.getIdUsers();


		model2.addAttribute("idUsers", idUsers);
		model2.addAttribute("idStatus", idStatus);
		model2.addAttribute("description", description);

		//Ajout du nouveau ticket en BDD
		//Create ticket
		Ticket ticket = new Ticket();
		ticket.setDetails(description);
		//TO DO: ajouter filtre id
		ticket.setGroup(groupService.getGroupById(1L));
		service.save(ticket);

		//Create status historic
		Status status = statusService.getStatusById(idStatus);
		StatusHistory statusHistory = new StatusHistory(status, ticket, LocalDateTime.now());
		historyService.save(statusHistory);
		Set<StatusHistory> statusHistorys = new HashSet<StatusHistory>();
		statusHistorys.add(statusHistory);
			
		//create task
		Set<Task> tasks = new HashSet<Task>();
		for (Long idUser : idUsers) {
			Task task = new Task(userService.getUserWithId(idUser), ticket, LocalDateTime.now());
			taskService.save(task);
			tasks.add(task);
		}
		
		ticket.setStatusHistory(statusHistorys);
		ticket.setTasks(tasks);
		service.save(ticket);
		
		return "/test/test-SelectMenu2";
	}
}
