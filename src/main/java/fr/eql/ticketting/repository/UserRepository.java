package fr.eql.ticketting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
