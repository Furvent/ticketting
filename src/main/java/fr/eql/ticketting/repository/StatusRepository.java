package fr.eql.ticketting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.Status;


public interface StatusRepository extends JpaRepository<Status, Long>{
	public Status findByLabel(String label);
}
