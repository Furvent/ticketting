package fr.eql.ticketting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eql.ticketting.controller.ViewModels.ViewUserTaskTicket;
import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.StatusHistory;
import fr.eql.ticketting.entity.Task;
import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.enums.TicketStatus;
import fr.eql.ticketting.service.GroupService;
import fr.eql.ticketting.service.MembershipService;
import fr.eql.ticketting.service.StatusHistoryService;
import fr.eql.ticketting.service.TaskService;
import fr.eql.ticketting.service.TicketService;
import fr.eql.ticketting.service.UserService;

@Controller
@SessionAttributes(value = { "user", "groupSelectedByUserId", "isUserAdmin"})
public class GroupDashboardController {
	GroupService groupService;
	MembershipService membershipService;
	UserService userService;
	TicketService ticketService;
	StatusHistoryService statusHistoryService;
	TaskService taskService;

	public GroupDashboardController(GroupService groupService, MembershipService membershipService,
			UserService userService, TicketService ticketService, StatusHistoryService statusHistoryService,
			TaskService taskService) {
		super();
		this.groupService = groupService;
		this.membershipService = membershipService;
		this.userService = userService;
		this.ticketService = ticketService;
		this.statusHistoryService = statusHistoryService;
		this.taskService = taskService;
	}

	@GetMapping("group")
	public String displayGroupDashboard(Model model, @RequestParam(name = "groupId", required = true) String groupID) {
		String templateName = "";
		// On ajoute le groupId en session
		model.addAttribute("groupSelectedByUserId", groupID);
		// On vérifie que l'utilisateur appartienne bien à ce groupe
		User user = (User) model.getAttribute("user");
		List<Membership> userMemberships = membershipService.getMembershipsWithUser(user);
		Boolean isUserBelongToGroup = false;
		Long groupIdLong = Long.parseLong(groupID);
		for (Membership membership : userMemberships) {
			if (membership.getGroup().getId() == groupIdLong) {
				isUserBelongToGroup = true;
			}
		}
		if (isUserBelongToGroup) {
			// On récupère le group en db
			Group currUserGroup = groupService.getGroupById(groupIdLong);
			model.addAttribute("currUserGroup", currUserGroup);
			// On vérifie si l'utilisateur est administrateur et on rajoute l'information dans le model
			model.addAttribute("isUserAdmin", checkIfUserIsAdmin(user, currUserGroup));
			// On récupère tous les tickets du groupe
			List<Ticket> groupTickets = getGroupTickets(currUserGroup);
			model.addAttribute("allTickets", groupTickets);
			// On trie les tickets selon leur dernier statut
			sortGroupTicketsByLastStatusAndAddThemToModel(model, groupTickets);
			// On ajoute au modèle les tickets attribués à l'utilisateur (task)
			addToModelUserOnTaskTickets(model, user, groupIdLong);
			// On ajoute les titres de status au model
			addStatusTitleToModel(model);

			templateName = "/dashboard/group-dashboard.html";
		} else {
			templateName = "/dashboard/general-dashboard.html";
		}
		return templateName;
	}

	private List<Ticket> getGroupTickets(Group group) {
		return ticketService.getTicketsWithGroup(group);
	}

	private void sortGroupTicketsByLastStatusAndAddThemToModel(Model model, List<Ticket> tickets) {
		List<Ticket> openedTickets = new ArrayList<Ticket>();
		List<Ticket> allocatedTickets = new ArrayList<Ticket>();
		List<Ticket> doneTickets = new ArrayList<Ticket>();
		List<Ticket> closedTickets = new ArrayList<Ticket>();
		for (Ticket ticket : tickets) {
			// On récupère le dernier Statut / NB : pas du tout optimisé puisque une
			// ouverture
			// de requête SQL est coûteux, peut être récupérer prélablement les
			// HistoricsStatus
			StatusHistory lastStatusHistory = statusHistoryService.getLastStatusHistoryFromThisTicket(ticket);
			if (lastStatusHistory != null) {
				switch (lastStatusHistory.getStatus().getLabel()) {
				case TicketStatus.OPENED:
					openedTickets.add(ticket);
					break;
				case TicketStatus.ALLOCATED:
					allocatedTickets.add(ticket);
					break;
				case TicketStatus.DONE:
					doneTickets.add(ticket);
					break;
				case TicketStatus.CLOSED:
					closedTickets.add(ticket);
					break;
				}
			}
		}
		model.addAttribute("openedTickets", openedTickets);
		model.addAttribute("allocatedTickets", allocatedTickets);
		model.addAttribute("doneTickets", doneTickets);
		model.addAttribute("closedTickets", closedTickets);
	}

	private void addStatusTitleToModel(Model model) {
		model.addAttribute("statusTitleOpened", "Opened");
		model.addAttribute("statusTitleAllocated", "Allocated");
		model.addAttribute("statusTitleDone", "Done");
		model.addAttribute("statusTitleClosed", "Closed");
	}

	private void addToModelUserOnTaskTickets(Model model, User user, Long groupId) {
		List<ViewUserTaskTicket> userTicketsView = new ArrayList<ViewUserTaskTicket>();
		// On va chercher les task de l'utilisateur
		List<Task> userTasks = taskService.getTasksByUser(user);
		// On sélection les tickets appartenant uniquement au groupe sélectionné
		List<Ticket> userTicketsOfThisGroup = new ArrayList<Ticket>();
		for (Task task : userTasks) {
			if (task.getTicket().getGroup().getId() == groupId) {
				userTicketsOfThisGroup.add(task.getTicket());
			}
		}
		for (Ticket ticket : userTicketsOfThisGroup) {
			// Pour créer notre TicketView on a besoin du ticket, du dernier statut, et des
			// utilisateurs en tâche dessus
			// On commence par récupérer les task d'un ticket
			List<Task> ticketTasks = taskService.getTasksByTicket(ticket);
			// et on récupère les pseudos
			List<String> usersPseudo = getUsersPseudoFromListTasks(ticketTasks);
			// Et enfin on récupère le dernier statut
			String status = getLastStatusOfTheTicket(ticket);
			userTicketsView.add(new ViewUserTaskTicket(ticket, status, usersPseudo));
		}
		model.addAttribute("userTickets", userTicketsView);
	}

	private String getLastStatusOfTheTicket(Ticket ticket) {
		StatusHistory lastStatusHistory = statusHistoryService.getLastStatusHistoryFromThisTicket(ticket);
		if (lastStatusHistory != null) {
			return lastStatusHistory.getStatus().getLabel();
		}
		return "No status found";
	}
	
	private List<String> getUsersPseudoFromListTasks(List<Task> tasks) {
		List<String> pseudos = new ArrayList<String>();
		for (Task task : tasks) {
			pseudos.add(task.getUser().getPseudo());
		}
		return pseudos;
	}
	
	private boolean checkIfUserIsAdmin(User user, Group group) {
		return user.getId() == group.getCreatedBy().getId();
	}

}
