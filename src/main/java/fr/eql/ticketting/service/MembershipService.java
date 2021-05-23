package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.Membership;

public interface MembershipService {
	public Membership save(Membership membership);
	public List<Membership> getAllMemberships();
	public Membership getMembershipById(Long membershipId);
	public void delete(Membership membership);
	public Membership update(Membership membership);
}
