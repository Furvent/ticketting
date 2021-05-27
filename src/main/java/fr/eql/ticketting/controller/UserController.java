package fr.eql.ticketting.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.service.GroupService;
import fr.eql.ticketting.service.MembershipService;
import fr.eql.ticketting.service.UserService;

@Controller
@SessionAttributes( value={"listUsers","testString"} )
public class UserController {

	UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping({"/list-users", "/", "/bob"}) // Point d'entrée d'url (dans le navigateur)
	public String displayUsers(Model model) {
		List<User> users = service.getAllUsers();
		model.addAttribute("users", users);
		return "usersDebug"; // le nom du template
	}
	
	@GetMapping("signup")
	String displaySignUpPage(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "signUp";
	}
	@PostMapping("/list-users")
	public RedirectView signUpNewUser(@ModelAttribute("user") User user) {
		service.save(user);
		return new RedirectView("/list-users");
	}
	
	@Autowired
	MembershipService serviceMembership;
	
	@Autowired
	GroupService serviceGroup;
		
	@GetMapping("/list-users-grouped")
	public String displayUsersByGroup(Model model) {
		Group group = serviceGroup.getGroupById(1L);
		System.out.println(group.getName());
		List<Membership> memberships = serviceMembership.getMembershipsWithGroup(group);
		List<User> users = new ArrayList<User>();
		for (Membership membership : memberships) {
			 users.add(membership.getUser());
		}
		model.addAttribute("users", users);
		return "usersDebug";
	}

}
