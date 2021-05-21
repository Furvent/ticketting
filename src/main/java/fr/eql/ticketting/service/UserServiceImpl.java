package fr.eql.ticketting.service;

import java.util.List;

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

}
