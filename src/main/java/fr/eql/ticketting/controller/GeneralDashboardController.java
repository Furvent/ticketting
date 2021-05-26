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
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.service.GroupService;
import fr.eql.ticketting.service.MembershipService;
import fr.eql.ticketting.service.UserService;

@Controller
@SessionAttributes(value = { "user" })
public class GeneralDashboardController {

	UserService userService;
	MembershipService membershipService;

	public GeneralDashboardController(UserService userService, MembershipService membershipService) {
		this.userService = userService;
		this.membershipService = membershipService;
	}

	@GetMapping({ "dashboard" })
	public String displayGeneralDashboard(Model model) {
		generateMockedUser(model);
		// On recup les groupes de l'utilisateurs
		model.addAttribute("userGroups", getUserGroups(model));

		return "dashboard/general-dashboard.html";
	}

	private void generateMockedUser(Model model) {
		User user = userService.getUserWithId(1L);
		model.addAttribute("user", user);
	}

	private List<Group> getUserGroups(Model model) {
		User user = (User) model.getAttribute("user");
		List<Membership> memberships = membershipService.getMembershipsWithUser(user);
		List<Group> userGroups = new ArrayList<Group>();
		for (Membership membership : memberships) {
			userGroups.add(membership.getGroup());
		}
		return userGroups;
	}
}
