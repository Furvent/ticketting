package fr.eql.ticketting.controller;

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
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.service.GroupService;
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
	GroupService groupService;
	
	@GetMapping("/list-users-grouped")
	public String displayUsersByGroup(Model model) {
		List<User> users = service.findByGroup(groupService.getGroupById(1L));
		model.addAttribute("users", users);
		return "usersDebug";
	}

}
