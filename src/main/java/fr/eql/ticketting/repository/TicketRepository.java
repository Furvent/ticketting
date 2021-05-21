package fr.eql.ticketting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.eql.ticketting.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Long>{

}
