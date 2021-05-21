package fr.eql.ticketting.controller;

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
	
	@GetMapping
	public String displayUser(Model model) {
		User userBefore = new User();
		User userSaved = service.save(userBefore);
		System.out.println(userSaved);
		return "";
	}
	
	

}
