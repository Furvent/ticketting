package fr.eql.ticketting.controller.old;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.StatusHistory;
import fr.eql.ticketting.service.StatusHistoryService;

@Controller
public class StatusHistoryController {
	StatusHistoryService logService;

	public StatusHistoryController(StatusHistoryService logService) {
		super();
		this.logService = logService;
	}
	
	@GetMapping("/list-log")
	public String displayGroups(Model model) {
		List<StatusHistory> statusHistories = logService.getAllStatusHistories();
		model.addAttribute("logs", statusHistories);
		return "logList"; 
	}	
}
