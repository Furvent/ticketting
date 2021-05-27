package fr.eql.ticketting.controller.old;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Status;
import fr.eql.ticketting.service.StatusService;

@Controller
public class StatusController {
	StatusService statusService;

	public StatusController(StatusService statusService) {
		super();
		this.statusService = statusService;
	}
	
	@GetMapping("/list-status")
	public String displayGroups(Model model) {
		List<Status> status = statusService.getAllStatus();
		model.addAttribute("status", status);
		return "statusList"; 
	}
}
