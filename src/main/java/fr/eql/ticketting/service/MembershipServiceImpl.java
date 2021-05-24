package fr.eql.ticketting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.repository.MembershipRepository;

@Service
public class MembershipServiceImpl implements MembershipService{
	MembershipRepository repository;
	
	
	public MembershipServiceImpl(MembershipRepository repository) {
		super();
		this.repository = repository;
	}
	
	public void setRepository(MembershipRepository repository) {
		this.repository = repository;
	}

	@Override
	public Membership save(Membership membership) {
		return repository.save(membership);
	}

	@Override
	public List<Membership> getAllMemberships() {
		return repository.findAll();
	}

	@Override
	public Membership getMembershipById(Long membershipId) {
		return repository.findById(membershipId).get();
	}

	@Override
	public void delete(Membership membership) {
		repository.delete(membership);
	}

	@Override
	public Membership update(Membership membership) {
		return repository.save(membership);
	}

}
