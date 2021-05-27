package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.Task;
import fr.eql.ticketting.entity.Ticket;

public interface TaskService {
	public Task save(Task task);
	public List<Task> getAllTasks();
	public Task getTaskById(Long taskId);
	public void delete(Task task);
	public Task update(Task task);
	public List<Task> getTasksByTicket(Ticket ticket);
}
