package fr.eql.ticketting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.Task;
import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.entity.User;

public interface TaskRepository extends JpaRepository<Task, Long>{
	public List<Task> findByTicket(Ticket ticket);
	public List<Task> findByUser(User user);
	public List<Task> findByUserAndTicket(User user, Ticket ticket);
}
