package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.Ticket;

public interface TicketService {
	
	public Ticket save(Ticket ticket);
	public List<Ticket> getAllTickets();
	public Ticket getTicketById(Long ticketId);
	public void delete(Ticket ticket);
	public Ticket update(Ticket ticket);

}
