package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.Task;

public interface TaskService {
	public Task save(Task task);
	public List<Task> getAllTasks();
	public Task getTaskById(Long taskId);
	public void delete(Task task);
	public Task update(Task task);
}
