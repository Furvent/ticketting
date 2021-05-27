package fr.eql.ticketting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.User;

public interface MembershipRepository extends JpaRepository<Membership, Long>{
	public List<Membership> findByUser(User user);
	public List<Membership> findByGroup(Group group);
}
