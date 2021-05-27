package fr.eql.ticketting.service;

import java.util.List;
import java.util.Set;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.User;

public interface UserService {
	public User save(User usertoAdd);

	public List<User> getAllUsers();

	public User getUserWithId(long idToSearch);
	public User getUserForConnection(String login, String password);
}
