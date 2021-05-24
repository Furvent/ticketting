package fr.eql.ticketting.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.service.MembershipService;

@Controller
public class MembershipController {
	MembershipService membershipService;

	public MembershipController(MembershipService membershipService) {
		super();
		this.membershipService = membershipService;
	}
	
	@GetMapping("/list-membership")
	public String displayGroups(Model model) {
		List<Membership> memberships = membershipService.getAllMemberships();
		model.addAttribute("memberships", memberships);
		return "membershipList"; 
	}
}
