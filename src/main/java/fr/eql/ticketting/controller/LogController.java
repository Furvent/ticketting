package fr.eql.ticketting.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Log;
import fr.eql.ticketting.service.LogService;

@Controller
public class LogController {
	LogService logService;

	public LogController(LogService logService) {
		super();
		this.logService = logService;
	}
	
	@GetMapping("/list-log")
	public String displayGroups(Model model) {
		List<Log> logs = logService.getAllLogs();
		model.addAttribute("logs", logs);
		return "logList"; 
	}	
}
