package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.Group;

public interface GroupService {
	public Group save(Group group);
	public List<Group> getAllGroups();
	public Group getGroupById(Long groupId);
	public void delete(Group group);
	public Group update(Group group);
}
