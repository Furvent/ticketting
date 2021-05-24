package fr.eql.ticketting.service;

import java.util.List;

import fr.eql.ticketting.entity.Log;
import fr.eql.ticketting.entity.Membership;

public interface LogService {
	public Log save(Log log);
	public List<Log> getAllLogs();
	public Log getLogById(Long logId);
	public void delete(Log log);
	public Log update(Log log);
}
