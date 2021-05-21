package fr.eql.ticketting.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IdStatus;
	private String label;
	
	public Long getIdStatus() {
		return IdStatus;
	}
	public void setIdStatus(Long id) {
		IdStatus = id;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((IdStatus == null) ? 0 : IdStatus.hashCode());
		result = prime * result + ((label == null) ? 0 : label.hashCode());
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
		Status other = (Status) obj;
		if (IdStatus == null) {
			if (other.IdStatus != null)
				return false;
		} else if (!IdStatus.equals(other.IdStatus))
			return false;
		if (label == null) {
			if (other.label != null)
				return false;
		} else if (!label.equals(other.label))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Status [IdStatus=" + IdStatus + ", label=" + label + "]";
	}
	

}
