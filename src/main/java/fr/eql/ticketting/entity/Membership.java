package fr.eql.ticketting.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Membership implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate joinDate;
	private LocalDate withDrawalDate;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
	private User user;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.PERSIST)
	private Group group;
	
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
	public LocalDate getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
	public LocalDate getWithDrawalDate() {
		return withDrawalDate;
	}
	public void setWithDrawalDate(LocalDate withDrawalDate) {
		this.withDrawalDate = withDrawalDate;
	}
	public Membership() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Membership(Long id, LocalDate joinDate, LocalDate withDrawalDate, User user, Group group) {
		super();
		this.id = id;
		this.joinDate = joinDate;
		this.withDrawalDate = withDrawalDate;
		this.user = user;
		this.group = group;
	}
	public Membership(LocalDate joinDate, LocalDate withDrawalDate, User user, Group group) {
		super();
		this.joinDate = joinDate;
		this.withDrawalDate = withDrawalDate;
		this.user = user;
		this.group = group;
	}
	@Override
	public String toString() {
		return "Membership [id=" + id + ", joinDate=" + joinDate + ", withDrawalDate="
				+ withDrawalDate + ", user=" + user + ", group=" + group + "]";
	}
	

	
	

}
