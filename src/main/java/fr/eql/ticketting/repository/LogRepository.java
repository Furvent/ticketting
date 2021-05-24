package fr.eql.ticketting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.StatusHistory;

public interface LogRepository extends JpaRepository<StatusHistory, Long>{

}
