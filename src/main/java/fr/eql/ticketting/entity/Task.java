package fr.eql.ticketting.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	LocalDateTime userAddedDate;
	LocalDateTime userWithdrawalDate;

	@ManyToOne
	@JoinColumn(nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Ticket ticket;

	public Task() {
		userAddedDate = LocalDateTime.now();
	}

	public Task(User user, Ticket ticket) {
		this();
		this.user = user;
		this.ticket = ticket;
	}

	public Long getId() {
		return id;
	}

	public void setIdTask(Long id) {
		this.id = id;
	}

	public LocalDateTime getUserAddedDate() {
		return userAddedDate;
	}

	public LocalDateTime getUserWithdrawalDate() {
		return userWithdrawalDate;
	}

	public void setUserWithdrawalDate(LocalDateTime userWithdrawalDate) {
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

	@Override
	public String toString() {
		return "Task [id=" + id + ", userAddedDate=" + userAddedDate + ", userWithdrawalDate=" + userWithdrawalDate
				+ "]";
	}

}
