package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.Group;
import fr.eql.ticketting.entity.Membership;
import fr.eql.ticketting.entity.User;

public interface MembershipService {
	public Membership save(Membership membership);
	public List<Membership> getAllMemberships();
	public List<Membership> getMembershipsWithUser(User user);
	public Membership getMembershipById(Long membershipId);
	public void delete(Membership membership);
	public Membership update(Membership membership);
	public List<Membership> getMembershipsWithGroup(Group group);
}
