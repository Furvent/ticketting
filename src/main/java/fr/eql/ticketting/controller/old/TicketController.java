package fr.eql.ticketting.controller.old;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eql.ticketting.entity.Status;
import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.service.StatusService;
import fr.eql.ticketting.service.TicketService;

//@Controller
public class TicketController {

	TicketService service;
	StatusService statusService;

	public TicketController(TicketService service, StatusService statusService) {
		super();
		this.service = service;
		this.statusService = statusService;
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
		model.addAttribute("ticket", new Ticket());
		for(Status s : status) {
			System.out.println(s.getLabel());
		}
		return "newTicket";
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
	public String testMenu2(@ModelAttribute("aStatus")Status selectedStatus, Model model2) {
		Status status2 = new Status(selectedStatus.getId(), selectedStatus.getLabel());
		System.out.println(selectedStatus.getId());
		System.out.println(selectedStatus.getLabel());
		model2.addAttribute("aStatus", status2);
		return "/test/test-SelectMenu2";
	}
}
