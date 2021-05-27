package fr.eql.ticketting.controller.form;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.eql.ticketting.enums.TicketStatus;

public class TicketForm {
	Long idStatus;
	String description;
	List<Long> idUsers;
	private List<String> radioButtonsOptions = new ArrayList<String>(
			Arrays.asList(TicketStatus.DONE, TicketStatus.CLOSED));
	private String radioSelected;

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

	public List<String> getRadioButtonsOptions() {
		return radioButtonsOptions;
	}

	public void setRadioButtonsOptions(List<String> radioButtonsOptions) {
		this.radioButtonsOptions = radioButtonsOptions;
	}

	public String getRadioSelected() {
		return radioSelected;
	}

	public void setRadioSelected(String radioSelected) {
		this.radioSelected = radioSelected;
	}

	@Override
	public String toString() {
		return "TicketForm [idStatus=" + idStatus + ", description=" + description + ", idUsers=" + idUsers
				+ ", radioSelected=" + radioSelected + "]";
	}

}
