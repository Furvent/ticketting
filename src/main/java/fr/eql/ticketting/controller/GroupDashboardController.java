package fr.eql.ticketting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.service.GroupService;
import fr.eql.ticketting.service.MembershipService;
import fr.eql.ticketting.service.TicketService;
import fr.eql.ticketting.service.UserService;

@Controller
@SessionAttributes(value = { "user" })
public class GroupDashboardController {

	GroupService groupService;
	MembershipService membershipService;
	UserService userService;
	TicketService ticketService;

	public GroupDashboardController(GroupService groupService, MembershipService membershipService,
			UserService userService, TicketService ticketService) {
		super();
		this.groupService = groupService;
		this.membershipService = membershipService;
		this.userService = userService;
		this.ticketService = ticketService;
	}

	@GetMapping("group")
	public String displayGroupDashboard(Model model, @RequestParam(name = "groupId", required = true) String groupID) {
		String templateName = "";
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
			// On récupère tous les tickets du groupe
			model.addAttribute("allTickets", getGroupTickets(currUserGroup));
			templateName = "/dashboard/group-dashboard.html";
		} else {
			templateName = "/dashboard/general-dashboard.html";
		}
		return templateName;
	}

	private List<Ticket> getGroupTickets(Group group) {
		return ticketService.getTicketsWithGroup(group);
	}

}
