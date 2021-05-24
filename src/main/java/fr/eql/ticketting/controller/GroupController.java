package fr.eql.ticketting.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.service.GroupService;

@Controller
public class GroupController {
	GroupService groupService;

	public GroupController(GroupService groupService) {
		super();
		this.groupService = groupService;
	}
	
	@GetMapping("/list-group")
	public String displayGroups(Model model) {
		List<Group> groups = groupService.getAllGroups();
		model.addAttribute("groups", groups);
		return "groupList"; 
	}
}
