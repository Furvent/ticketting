package fr.eql.ticketting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.StatusHistory;

public interface StatusHistoryRepository extends JpaRepository<StatusHistory, Long>{

}
