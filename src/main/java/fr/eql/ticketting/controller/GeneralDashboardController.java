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

import fr.eql.ticketting.controller.form.UserProfileForm;
import fr.eql.ticketting.controller.form.UserForm;
import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.service.MembershipService;
import fr.eql.ticketting.service.UserService;

@Controller
@SessionAttributes(value = { "user", "userModif"})
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
	

	@GetMapping({"userProfile"})
	public String displayOrModifyUserProfile(Model model) {
		String connectedUserPseudo = ((User) model.getAttribute("user")).getPseudo();
		if(model.getAttribute("userModif") == null) {
			model.addAttribute("userModif", new UserProfileForm(connectedUserPseudo, "", "", "", ""));
		}
		return "dashboard/userProfile";
	}
	
	@PostMapping({"/profilChangeConfirmation"})
	public RedirectView profilChangeVerification(@ModelAttribute("userModif") UserProfileForm userModif, 
			Model model) {
//		System.err.println("arrivé dans le mapping de confirmation" + userModif.toString());
//		System.out.println(userModif.getPseudo());
//		System.out.println(((UserProfileForm) model.getAttribute("userModif")).getPseudo());
		User user = (User) model.getAttribute("user");
		RedirectView redirection;
		
		if(!userModif.getPasswordCheck().equals(user.getPassword())) {
			userModif.setErrorMessage("Wrong password entered");
			redirection = new RedirectView("/userProfile");
			
		} else if (!userModif.getPassword().equals(userModif.getPasswordConfirmation())) {
			userModif.setErrorMessage("The passwords do not match");
			redirection = new RedirectView("/userProfile");
			
		} else {
//			System.err.println("IAM IN THE ESLE");
			user.setPassword(userModif.getPassword());
			user.setPseudo(userModif.getPseudo());
			
			redirection = new RedirectView("/dashboard");
			model.addAttribute("userModif", null);
		}
		System.err.println(user);
		System.err.println("avant la redirection du mapping"  + userModif.toString());
		return redirection;
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
