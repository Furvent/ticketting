package fr.eql.ticketting.controller.old;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.service.TicketService;

@Controller
public class TicketController {

	TicketService service;
	
	public TicketController(TicketService service) {
		super();
		this.service = service;
	}

	@GetMapping("/list-tickets")
	public String displayUsers(Model model) {
		List<Ticket> tickets = service.getAllTickets();
		model.addAttribute("tickets", tickets);
		return "ticketsDebug";
	}
}
