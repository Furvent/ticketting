package fr.eql.ticketting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.repository.GroupRepository;

@Service
public class GroupServiceImpl implements GroupService{
	GroupRepository repository;
	
	
	public GroupServiceImpl(GroupRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public Group save(Group groupToAdd) {
		return repository.save(groupToAdd);
	}

	@Override
	public List<Group> getAllGroups() {
		return repository.findAll();
	}

	@Override
	public Group getGroupById(Long groupId) {
		return repository.findById(groupId).get();
	}

	@Override
	public void delete(Group group) {
		repository.delete(group);
	}

	@Override
	public Group update(Group group) {
		return repository.save(group);
	}

	public void setRepository(GroupRepository repository) {
		this.repository = repository;
	}
}
