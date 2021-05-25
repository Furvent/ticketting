package fr.eql.ticketting.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String details;
	private LocalDateTime creationTicketDate;
	private LocalDateTime closingTicketDate;
	private LocalDateTime modificationTicketDate;

	@OneToMany(mappedBy = "ticket")
	private Set<StatusHistory> statusHistory = new HashSet<StatusHistory>();

	@OneToMany(mappedBy = "ticket")
	private Set<Task> tasks = new HashSet<Task>();

	@OneToMany(mappedBy = "ticket")
	private Set<Comment> comment = new HashSet<Comment>();

	@ManyToOne
	@JoinColumn(nullable = false)
	private Group group;

	public Ticket() {
	}

	public Ticket(String details, LocalDateTime creationTicketDate) {
		this.details = details;
		this.creationTicketDate = creationTicketDate;
	}

	public Ticket(String details, LocalDateTime creationTicketDate, Group group) {
		this(details, creationTicketDate);
		this.group = group;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public LocalDateTime getCreationTicketDate() {
		return creationTicketDate;
	}

	public void setCreationTicketDate(LocalDateTime creationTicketDate) {
		this.creationTicketDate = creationTicketDate;
	}

	public LocalDateTime getClosingTicketDate() {
		return closingTicketDate;
	}

	public void setClosingTicketDate(LocalDateTime closingTicketDate) {
		this.closingTicketDate = closingTicketDate;
	}

	public LocalDateTime getModificationTicketDate() {
		return modificationTicketDate;
	}

	public void setModificationTicketDate(LocalDateTime modificationTicketDate) {
		this.modificationTicketDate = modificationTicketDate;
	}

	public Set<StatusHistory> getStatusHistory() {
		return statusHistory;
	}

	public void setStatusHistory(Set<StatusHistory> statusHistory) {
		this.statusHistory = statusHistory;
	}

	public Set<Task> getTasks() {
		return tasks;
	}

	public void setTasks(Set<Task> tasks) {
		this.tasks = tasks;
	}

	public Set<Comment> getComment() {
		return comment;
	}

	public void setComment(Set<Comment> comment) {
		this.comment = comment;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((closingTicketDate == null) ? 0 : closingTicketDate.hashCode());
		result = prime * result + ((creationTicketDate == null) ? 0 : creationTicketDate.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Ticket other = (Ticket) obj;
		if (closingTicketDate == null) {
			if (other.closingTicketDate != null)
				return false;
		} else if (!closingTicketDate.equals(other.closingTicketDate))
			return false;
		if (creationTicketDate == null) {
			if (other.creationTicketDate != null)
				return false;
		} else if (!creationTicketDate.equals(other.creationTicketDate))
			return false;
		if (details == null) {
			if (other.details != null)
				return false;
		} else if (!details.equals(other.details))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", details=" + details + ", creationTicketDate=" + creationTicketDate
				+ ", closingTicketDate=" + closingTicketDate + ", modificationTicketDate=" + modificationTicketDate
				+ ", statusHistory=" + statusHistory + ", comment=" + comment + "]";
	}

}
