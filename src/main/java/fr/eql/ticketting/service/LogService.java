package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.StatusHistory;
import fr.eql.ticketting.entity.Membership;

public interface LogService {
	public StatusHistory save(StatusHistory statusHistory);
	public List<StatusHistory> getAllStatusHistories();
	public StatusHistory getStatusHistoryById(Long logId);
	public void delete(StatusHistory statusHistory);
	public StatusHistory update(StatusHistory statusHistory);
}
