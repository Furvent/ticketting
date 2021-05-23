package fr.eql.ticketting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long>{

}
