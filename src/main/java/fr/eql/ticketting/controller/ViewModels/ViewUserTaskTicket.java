package fr.eql.ticketting.controller.ViewModels;

import java.util.List;

import fr.eql.ticketting.entity.Ticket;

public class ViewUserTaskTicket {

	private String details, lastStatus;
	private long id;
	private List<String> usersTaskOn;

	public ViewUserTaskTicket(Ticket ticket, String lastStatus, List<String> usersTaskOn) {
		this.details = ticket.getDetails();
		this.id = ticket.getId();
		this.lastStatus = lastStatus;
		this.usersTaskOn = usersTaskOn;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getLastStatus() {
		return lastStatus;
	}

	public void setLastStatus(String lastStatus) {
		this.lastStatus = lastStatus;
	}

	public List<String> getUsersTaskOn() {
		return usersTaskOn;
	}

	public void setUsersTaskOn(List<String> usersTaskOn) {
		this.usersTaskOn = usersTaskOn;
	}

	@Override
	public String toString() {
		return "ViewUserTaskTicket [details=" + details + ", lastStatus=" + lastStatus + ", id=" + id + ", usersTaskOn="
				+ usersTaskOn + "]";
	}

}
