package fr.eql.ticketting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fr.eql.ticketting.controller.form.UserForm;
import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.service.MembershipService;
import fr.eql.ticketting.service.UserService;

@Controller
@SessionAttributes(value = { "user"})
public class GeneralDashboardController {

	UserService userService;
	MembershipService membershipService;
	
	@ModelAttribute("userForm")
	public UserForm addConvAttributeInModel() {
		return new UserForm();
	}

	public GeneralDashboardController(UserService userService, MembershipService membershipService) {
		this.userService = userService;
		this.membershipService = membershipService;
	}

	@GetMapping({ "dashboard" })
	public String displayGeneralDashboard(Model model) {
		System.err.println("I'm in displayGeneralDashboard");
		// On recup les groupes de l'utilisateurs
		model.addAttribute("userGroups", getUserGroups(model));

		return "dashboard/general-dashboard.html";
	}

	private List<Group> getUserGroups(Model model) {
		User user = (User) model.getAttribute("user");
		System.err.println("In getUserGroups, user : " + user);
		List<Membership> memberships = membershipService.getMembershipsWithUser(user);
		List<Group> userGroups = new ArrayList<Group>();
		for (Membership membership : memberships) {
			userGroups.add(membership.getGroup());
		}
		return userGroups;
	}
	
	@PostMapping("/edit")
	public RedirectView updateUser(@ModelAttribute("user") User user,@ModelAttribute("userForm") UserForm userForm ,Model model) {
		if (userForm.getOldPassword().equals(user.getPassword())) {
			user.setPassword(userForm.getNewPassword());
			userService.save(user);
		}
		return new RedirectView("/dashboard");
		
	}
}
