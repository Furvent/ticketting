package fr.eql.ticketting.entity;

import java.time.LocalDateTime;

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
	LocalDateTime userAddedDate;
	LocalDateTime userWithdrawalDate;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private User user;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Ticket ticket;

	public Task() {
		userAddedDate = LocalDateTime.now();
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
