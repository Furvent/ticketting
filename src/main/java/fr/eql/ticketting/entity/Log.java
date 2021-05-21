package fr.eql.ticketting.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Log implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdLog;
	
	private LocalDate date;
	
	private User user;
	
	@ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
	@JoinColumn(name = "ticket_id")
	private Ticket ticket;
	
	public Log(User user, Ticket ticket) {
		this.date = LocalDate.now();
		this.user = user;
		this.ticket = ticket;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Long getIdLog() {
		return IdLog;
	}
	public void setIdLog(Long idLog) {
		IdLog = idLog;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public LocalDate getDate() {
		return date;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}

