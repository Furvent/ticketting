package fr.eql.ticketting.controller.form;

import java.util.List;

public class TicketForm {
	Long idStatus;
	String description;
	List<Long> idUsers;
	
	public Long getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(Long idStatus) {
		this.idStatus = idStatus;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Long> getIdUsers() {
		return idUsers;
	}
	public void setIdUsers(List<Long> idUsers) {
		this.idUsers = idUsers;
	}
}
