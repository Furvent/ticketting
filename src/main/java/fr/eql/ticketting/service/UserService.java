package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.User;

public interface UserService {
	public User save(User usertoAdd);

	public List<User> getAllUsers();

	public User getUserWithId(long idToSearch);
}
