package fr.eql.ticketting.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	LocalDate userAddedDate;
	LocalDate userWithdrawalDate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private Ticket ticket;
	
	public Long getId() {
		return id;
	}
	public void setIdTask(Long id) {
		this.id = id;
	}
	public LocalDate getUserAddedDate() {
		return userAddedDate;
	}
	public void setUserAddedDate(LocalDate userAddedDate) {
		this.userAddedDate = userAddedDate;
	}
	public LocalDate getUserWithdrawalDate() {
		return userWithdrawalDate;
	}
	public void setUserWithdrawalDate(LocalDate userWithdrawalDate) {
		this.userWithdrawalDate = userWithdrawalDate;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Ticket getTicket() {
		return ticket;
	}
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	public Task() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Task(Long id, LocalDate userAddedDate, LocalDate userWithdrawalDate) {
		super();
		this.id = id;
		this.userAddedDate = userAddedDate;
		this.userWithdrawalDate = userWithdrawalDate;
	}
	@Override
	public String toString() {
		return "Task [id=" + id + ", userAddedDate=" + userAddedDate + ", userWithdrawalDate="
				+ userWithdrawalDate + "]";
	}
	
	

}
