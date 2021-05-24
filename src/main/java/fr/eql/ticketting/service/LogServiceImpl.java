package fr.eql.ticketting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eql.ticketting.entity.Log;
import fr.eql.ticketting.repository.LogRepository;

@Service
public class LogServiceImpl implements LogService{
	LogRepository repository;
	
	@Override
	public Log save(Log log) {
		return repository.save(log);
	}

	@Override
	public List<Log> getAllLogs() {
		return repository.findAll();
	}

	@Override
	public Log getLogById(Long logId) {
		return repository.findById(logId).get();
	}

	@Override
	public void delete(Log log) {
		repository.delete(log);
	}

	@Override
	public Log update(Log log) {
		return repository.save(log);
	}

}
