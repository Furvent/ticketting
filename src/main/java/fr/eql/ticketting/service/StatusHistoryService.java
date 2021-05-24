package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.StatusHistory;

public interface StatusHistoryService {
	public StatusHistory save(StatusHistory statusHistory);
	public List<StatusHistory> getAllStatusHistories();
	public StatusHistory getStatusHistoryById(Long logId);
	public void delete(StatusHistory statusHistory);
	public StatusHistory update(StatusHistory statusHistory);
}
