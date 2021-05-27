package fr.eql.ticketting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
	public List<Ticket> findByGroup(Group group);
}
