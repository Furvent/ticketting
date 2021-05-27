package fr.eql.ticketting.controller.old;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eql.ticketting.entity.Task;
import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.service.TaskService;

@Controller
public class taskController {
	TaskService taskService;

	public taskController(TaskService taskService) {
		super();
		this.taskService = taskService;
	}
	
	@GetMapping("/list-tasks")
	public String displayUsers(Model model) {
		List<Task> tasks = taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		return "taskList";
	}
}
