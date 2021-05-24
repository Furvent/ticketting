package fr.eql.ticketting.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.sun.istack.NotNull;

@Entity
public class Membership {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime joinDate;
	private LocalDateTime withDrawalDate;

	@ManyToOne
	@JoinColumn(nullable = false)
	private User user;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Group group;
	
	public Membership() {
		joinDate = LocalDateTime.now();
	}

	public Membership(User user, Group group) {
		this();
		this.user = user;
		this.group = group;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}

	public LocalDateTime getWithDrawalDate() {
		return withDrawalDate;
	}

	public void setWithDrawalDate(LocalDateTime withDrawalDate) {
		this.withDrawalDate = withDrawalDate;
	}

	@Override
	public String toString() {
		return "Membership [id=" + id + ", joinDate=" + joinDate + ", withDrawalDate=" + withDrawalDate + ", user="
				+ user + ", group=" + group + "]";
	}

}
