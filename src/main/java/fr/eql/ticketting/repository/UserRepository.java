package fr.eql.ticketting.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public List<User> findByLoginAndPassword(String login, String password);
	
}
