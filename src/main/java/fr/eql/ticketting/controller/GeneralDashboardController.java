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
@SessionAttributes(value = { "user", "userForm"})
public class GeneralDashboardController {

	UserService userService;
	MembershipService membershipService;
	
	public GeneralDashboardController(UserService userService, MembershipService membershipService) {
		this.userService = userService;
		this.membershipService = membershipService;
	}

	@GetMapping({ "dashboard" })
	public String displayGeneralDashboard(Model model) {
		// On recup les groupes de l'utilisateurs
		model.addAttribute("userGroups", getUserGroups(model));
		return "dashboard/general-dashboard.html";
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
	
	@PostMapping("/editUserProfile")
	public RedirectView updateUser(@ModelAttribute("user") User user,@ModelAttribute("userForm") UserForm userForm ,Model model) {
		RedirectView redirection;
		if(!userForm.getOldPassword().equals(user.getPassword())) {
			userForm.setErrorMessage("Wrong password entered");
			model.addAttribute("userForm", userForm);
			redirection = new RedirectView("/userProfile");
			
		} else if (!userForm.getNewPassword().equals(userForm.getPasswordConfirmation())) {
			userForm.setErrorMessage("The passwords do not match");
			model.addAttribute("userForm", userForm);
			redirection = new RedirectView("/userProfile");
			
		} else {
			user.setPassword(userForm.getNewPassword());
			user.setPseudo(userForm.getPseudo());
			userService.save(user);
			redirection = new RedirectView("/dashboard");
			model.addAttribute("userForm", null);
		}
		return redirection;
		
	}
	@GetMapping({"userProfile"})
	public String displayOrModifyUserProfile(Model model) {
		String connectedUserPseudo = ((User) model.getAttribute("user")).getPseudo();
		if (((UserForm) model.getAttribute("userForm"))== null) {
			model.addAttribute("userForm", new UserForm(connectedUserPseudo, "", "", "", ""));
			}
				return "profilEdition";
	}
}
