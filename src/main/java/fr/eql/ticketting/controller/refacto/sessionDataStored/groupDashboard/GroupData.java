package fr.eql.ticketting.controller.refacto.sessionDataStored.groupDashboard;

import java.time.LocalDateTime;

import fr.eql.ticketting.entity.Group;

/**
 * Group data where user is navigate
 * 
 * @author Furvent
 *
 */
public class GroupData {

	private long id;
	private String name;
	private LocalDateTime creationDateGroup;
	private UserData createdBy;

	public GroupData(Group group, UserData createdBy) {
		this.id = group.getId();
		this.name = group.getName();
		this.creationDateGroup = group.getCreationDateGroup();
		this.createdBy = createdBy;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getCreationDateGroup() {
		return creationDateGroup;
	}

	public UserData getCreatedBy() {
		return createdBy;
	}

	@Override
	public String toString() {
		return "GroupData [id=" + id + ", name=" + name + ", creationDateGroup=" + creationDateGroup + ", createdBy="
				+ createdBy + "]";
	}

}
