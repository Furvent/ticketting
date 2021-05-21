package fr.eql.ticketting.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.service.UserService;

@Controller
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

}
