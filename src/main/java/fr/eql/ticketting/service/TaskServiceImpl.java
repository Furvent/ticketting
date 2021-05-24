package fr.eql.ticketting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eql.ticketting.entity.Task;
import fr.eql.ticketting.repository.TaskRepository;

@Service
public class TaskServiceImpl implements TaskService {
	TaskRepository repository;

	public TaskServiceImpl(TaskRepository repository) {
		super();
		this.repository = repository;
	}

	public void setRepository(TaskRepository repository) {
		this.repository = repository;
	}

	@Override
	public Task save(Task task) {
		return repository.save(task);
	}

	@Override
	public List<Task> getAllTasks() {
		return repository.findAll();
	}

	@Override
	public Task getTaskById(Long taskId) {
		return repository.findById(taskId).get();
	}

	@Override
	public void delete(Task task) {
		repository.delete(task);
	}

	@Override
	public Task update(Task task) {
		return repository.save(task);
	}
}
