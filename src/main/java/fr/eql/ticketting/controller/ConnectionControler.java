package fr.eql.ticketting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.service.UserService;

@Controller
@SessionAttributes("user")
public class ConnectionControler {

	private UserService userService;

	public ConnectionControler(UserService userService) {
		this.userService = userService;
	}

	@GetMapping({ "/connect", "/" })
	public String personneForm(Model model) {
		model.addAttribute("user", new User());
		return "ConnectionPage";
	}

	@PostMapping("/list-users")
	public RedirectView signUpNewUser(@ModelAttribute("user") User user) {
		userService.save(user);
		return new RedirectView("/dashboard");
	}

	@PostMapping("/connexionSubmit")
	public RedirectView connexionSubmit(@ModelAttribute("user") User user, Model model) {
		RedirectView retour;
		User userConnected = userService.getUserForConnection(user.getLogin(), user.getPassword());
		if (userConnected != null) {
			model.addAttribute("user", userConnected);
			retour = new RedirectView("/dashboard");
		} else {
			retour = new RedirectView("/connect");
		}
		return retour;
	}
}
