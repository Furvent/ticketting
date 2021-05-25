package fr.eql.ticketting.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import fr.eql.ticketting.entity.User;
import fr.eql.ticketting.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	UserRepository repository;

	public UserServiceImpl(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User save(User usertoAdd) {
		return repository.save(usertoAdd);
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User getUserWithId(long idToSearch) {
		return repository.findById(idToSearch).get();
	}

	@Override
	public User getUserForConnection(String login, String password) {
		User returnedUser = null;
		List<User> users = new ArrayList<User>();
		users = repository.findByLoginAndPassword(login, password);
		System.out.println(users.size());
		if(users.size() > 0) {
			returnedUser = users.iterator().next();
			return returnedUser;
		}
		return returnedUser;
	}
}
