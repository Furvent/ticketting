package fr.eql.ticketting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{
	
}
