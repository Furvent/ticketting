package fr.eql.ticketting.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ticket implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdTicket;
	private String details;
	private LocalDate creationTicketDate;
	private LocalDate closingTicketDate;
	private LocalDate modificationTicketDate;
	
	@OneToMany(mappedBy = "ticket")
	private Set<Log> log;
	
	private Status status;
	
	
	public Ticket(String details, Status status) {
		this.details = details;
		this.creationTicketDate = LocalDate.now();
		this.status= status;
		
	}
	public Ticket() {
		
	}
	
	
	public Long getIdTicket() {
		return IdTicket;
	}
	public void setIdTicket(Long idTicket) {
		IdTicket = idTicket;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public LocalDate getCreationTicketDate() {
		return creationTicketDate;
	}
	public void setCreationTicketDate(LocalDate creationTicketDate) {
		this.creationTicketDate = creationTicketDate;
	}
	public LocalDate getClosingTicketDate() {
		return closingTicketDate;
	}
	public void setClosingTicketDate(LocalDate closingTicketDate) {
		this.closingTicketDate = closingTicketDate;
	}
	public LocalDate getModificationTicketDate() {
		return modificationTicketDate;
	}
	public void setModificationTicketDate(LocalDate modificationTicketDate) {
		this.modificationTicketDate = modificationTicketDate;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdTicket == null) ? 0 : IdTicket.hashCode());
		result = prime * result + ((closingTicketDate == null) ? 0 : closingTicketDate.hashCode());
		result = prime * result + ((creationTicketDate == null) ? 0 : creationTicketDate.hashCode());
		result = prime * result + ((details == null) ? 0 : details.hashCode());
		result = prime * result + ((modificationTicketDate == null) ? 0 : modificationTicketDate.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		if (IdTicket == null) {
			if (other.IdTicket != null)
				return false;
		} else if (!IdTicket.equals(other.IdTicket))
			return false;
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
		if (modificationTicketDate == null) {
			if (other.modificationTicketDate != null)
				return false;
		} else if (!modificationTicketDate.equals(other.modificationTicketDate))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Ticket [IdTicket=" + IdTicket + ", details=" + details + ", creationTicketDate=" + creationTicketDate
				+ ", closingTicketDate=" + closingTicketDate + ", modificationTicketDate=" + modificationTicketDate
				+ ", status=" + status + "]";
	}
	
	
}
