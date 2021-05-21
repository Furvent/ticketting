package fr.eql.ticketting.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Group {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idGroup;
	private String name;
	private User createdBy;
	private LocalDate creationDateGroup;
	
	@OneToMany(mappedBy = "groups")
	private Set<Membership> memberships;
	
	public Long getIdGroup() {
		return idGroup;
	}
	public void setIdGroup(Long idGroup) {
		this.idGroup = idGroup;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDate getCreationDateGroup() {
		return creationDateGroup;
	}
	public Group(String name, User createdBy) {
		this.name = name;
		this.createdBy = createdBy;
		this.creationDateGroup = LocalDate.now();
	}
	public Set<Membership> getMemberships() {
		return memberships;
	}
	public void setMemberships(Set<Membership> memberships) {
		this.memberships = memberships;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((creationDateGroup == null) ? 0 : creationDateGroup.hashCode());
		result = prime * result + ((idGroup == null) ? 0 : idGroup.hashCode());
		result = prime * result + ((memberships == null) ? 0 : memberships.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (creationDateGroup == null) {
			if (other.creationDateGroup != null)
				return false;
		} else if (!creationDateGroup.equals(other.creationDateGroup))
			return false;
		if (idGroup == null) {
			if (other.idGroup != null)
				return false;
		} else if (!idGroup.equals(other.idGroup))
			return false;
		if (memberships == null) {
			if (other.memberships != null)
				return false;
		} else if (!memberships.equals(other.memberships))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Group [idGroup=" + idGroup + ", name=" + name + ", createdBy=" + createdBy + ", creationDateGroup="
				+ creationDateGroup + ", memberships=" + memberships + "]";
	}
	
}
