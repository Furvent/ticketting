package fr.eql.ticketting.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Membership implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMembership;
	private LocalDate joinDate;
	private LocalDate withDrawalDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Set<User> users;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Set<Group> groups;
	
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	public Set<Group> getGroups() {
		return groups;
	}
	public void setGroups(Set<Group> groups) {
		this.groups = groups;
	}
	public Long getIdMembership() {
		return idMembership;
	}
	public void setIdMembership(Long idMembership) {
		this.idMembership = idMembership;
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
	
	

}
