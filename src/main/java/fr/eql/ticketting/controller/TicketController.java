package fr.eql.ticketting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eql.ticketting.entity.Status;
import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.service.StatusService;
import fr.eql.ticketting.service.TicketService;

@Controller
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
		//envoit des status sur la page
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
}
