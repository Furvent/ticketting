package fr.eql.ticketting.controller.old;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import fr.eql.ticketting.controller.form.TicketForm;
import fr.eql.ticketting.entity.Status;
import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.service.StatusService;
import fr.eql.ticketting.service.TicketService;

@Controller
public class TicketController {

	TicketService service;
	StatusService statusService;
	
	@ModelAttribute("ticketForm")
	public TicketForm addConvAttributeInModel() {
		return new TicketForm();
	}
	
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
	public String testMenu2(@ModelAttribute("ticketForm") TicketForm ticketForm, Model model2) {
		Long idStatus = ticketForm.getIdStatus();
		model2.addAttribute("idStatus", idStatus);
		System.out.println(idStatus);
		String description = ticketForm.getDescription();
		model2.addAttribute("description", description);
		System.out.println(description);
		return "/test/test-SelectMenu2";
	}
}
