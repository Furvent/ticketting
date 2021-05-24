package fr.eql.ticketting.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.eql.ticketting.entity.Membership;

public interface MembershipRepository extends JpaRepository<Membership, Long>{
	
}
