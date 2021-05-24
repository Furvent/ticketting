package fr.eql.ticketting.controller.debug;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.service.GroupService;

public class DebugGroupController {

	GroupService groupService;

	public DebugGroupController(GroupService groupService) {
		this.groupService = groupService;
	}
	
//	@GetMapping({"/debug-group"}) // Point d'entrée d'url (dans le navigateur)
//	public String displayGroups(Model model) {
//		List<Group> users = groupService.();
//		model.addAttribute("users", users);
//		return "usersDebug"; // le nom du template
//	}

}
