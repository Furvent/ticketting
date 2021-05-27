package fr.eql.ticketting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fr.eql.ticketting.controller.form.TicketForm;
import fr.eql.ticketting.entity.StatusHistory;
import fr.eql.ticketting.entity.Task;
import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.enums.TicketStatus;
import fr.eql.ticketting.service.StatusHistoryService;
import fr.eql.ticketting.service.TaskService;
import fr.eql.ticketting.service.TicketService;

@Controller
@SessionAttributes(value = { "isUserAdmin", "groupSelectedByUserId", "ticket" })
public class EditTicketDisplayController {

	TicketService ticketService;
	TaskService taskService;
	StatusHistoryService statusHistoryService;

	public EditTicketDisplayController(TicketService ticketService, TaskService taskService,
			StatusHistoryService statusHistoryService) {
		this.ticketService = ticketService;
		this.taskService = taskService;
		this.statusHistoryService = statusHistoryService;
	}

	@GetMapping({ "ticket-admin" })
	public String displayEditTicket(Model model, @RequestParam(name = "ticketId", required = true) String ticketId) {
		if ((boolean) model.getAttribute("isUserAdmin")) {
			Ticket ticket = ticketService.getTicketById(Long.parseLong(ticketId));
			model.addAttribute("ticket", ticket);
			// On veut les pseudos des personnes qui bossent dessus (Task)
			List<Task> tasksLinkedWithTicket = taskService.getTasksByTicket(ticket);
			List<String> usersPseudoWorkingOnTicket = new ArrayList<String>();
			for (Task task : tasksLinkedWithTicket) {
				usersPseudoWorkingOnTicket.add(task.getUser().getPseudo());
			}
			model.addAttribute("usersPseudo", usersPseudoWorkingOnTicket);
			// On veut l'historique (Status, StatusHistory)
			List<StatusHistory> statusHistoricOfTicket = statusHistoryService.getStatusHistoriesFromThisTicket(ticket);
			model.addAttribute("historic", statusHistoricOfTicket);
			// On ajoute un objet intermédiaire pour gérer le formulaire du ticket
			TicketForm ticketForm = new TicketForm();
			model.addAttribute("ticketForm", ticketForm);
			return "ticket/admin.html";
		} else { // Si utilisateur n'est pas admin
			return "/";
		}
	}

	@PostMapping({ "/modifTicket" })
	public RedirectView editTicketbyPost(Model model, @ModelAttribute("ticketForm") TicketForm ticketForm) {
		Ticket ticket = (Ticket) model.getAttribute("ticket");
		if (ticketForm.getDescription() != "" && ticket != null) {
			System.err.println("ticketForm: " + ticketForm);
			ticket.setDetails(ticketForm.getDescription());
			ticketService.save(ticket);
			return new RedirectView("ticket-admin?ticketId=" + ticket.getId());
		} else {
			return new RedirectView("/");
		}

	}

	private void setNewStatusOnTicket(String newStatus, Ticket ticket) {
		switch (newStatus) {
		case TicketStatus.DONE:
			
			StatusHistory statusHistory = new StatusHistory(null, ticket, null)
			break;
		case TicketStatus.CLOSED:

			break;
		default:
			break;
		}
	}
	

}
