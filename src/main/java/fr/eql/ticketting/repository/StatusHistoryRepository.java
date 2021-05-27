package fr.eql.ticketting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.StatusHistory;
import fr.eql.ticketting.entity.Ticket;

public interface StatusHistoryRepository extends JpaRepository<StatusHistory, Long>{
	public List<StatusHistory> findByTicket(Ticket ticket);
}
