package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.Status;

public interface StatusService {
	public Status save(Status status);
	public List<Status> getAllStatus();
	public Status getStatusById(Long statusId);
	public void delete(Status status);
	public Status update(Status status);
}
