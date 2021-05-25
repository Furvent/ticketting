package fr.eql.ticketting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eql.ticketting.entity.Ticket;
import fr.eql.ticketting.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	TicketRepository repository;

	public TicketServiceImpl(TicketRepository repository) {
		this.repository = repository;
	}

	@Override
	public Ticket save(Ticket ticket) {
		return repository.save(ticket);
	}

	@Override
	public List<Ticket> getAllTickets() {
		return repository.findAll();
	}

	@Override
	public Ticket getTicketById(Long ticketId) {
		return repository.findById(ticketId).get();
	}

	@Override
	public void delete(Ticket ticket) {
		repository.delete(ticket);
	}

	@Override
	public Ticket update(Ticket ticket) {
		return repository.save(ticket);
	}

}
