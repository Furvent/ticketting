package fr.eql.ticketting.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.repository.UserRepository;
import fr.eql.ticketting.service.UserService;

@Controller
@SessionAttributes("user")
public class ConnectionControler {
	
	private UserService userService;
	
	public ConnectionControler(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/connect")
	public String personneForm(Model model) {
		model.addAttribute("user", new User());
		return "connectForm";
	}	
	
	@PostMapping("/connexionSubmit")
	public String connexionSubmit(@ModelAttribute("user") User user, Model model) {
		String retour = "";
		User userConnected = userService.getUserForConnection(user.getLogin(), user.getPassword());
		if(userConnected != null) {
			retour = "GeneralDashboard.html";
		}else {
			retour = "connectForm";
		}
		return retour;
	}
}
