package fr.eql.ticketting.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eql.ticketting.service.GroupService;
import fr.eql.ticketting.service.MembershipService;
import fr.eql.ticketting.service.UserService;

@Controller
public class GroupDashboardController {

	GroupService groupService;
	MembershipService membershipService;
	UserService userService;

	public GroupDashboardController(GroupService groupService, MembershipService membershipService,
			UserService userService) {
		this.groupService = groupService;
		this.membershipService = membershipService;
		this.userService = userService;
	}
	
	@GetMapping("/group")
	public String getGroup(Model model, @RequestParam(name = "groupId", required = true) String groupID) {
		System.out.println("groupID " + groupID);
		model.addAttribute("groupId", groupID);
		return "dashboard/group-dashboard.html"; // Send back to group dashboard
	}

}
