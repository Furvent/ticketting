package fr.eql.ticketting.service;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.eql.ticketting.entity.StatusHistory;
import fr.eql.ticketting.repository.LogRepository;

@Service
public class LogServiceImpl implements LogService{
	LogRepository repository;
	
	@Override
	public StatusHistory save(StatusHistory statusHistory) {
		return repository.save(statusHistory);
	}

	@Override
	public List<StatusHistory> getAllStatusHistories() {
		return repository.findAll();
	}

	@Override
	public StatusHistory getStatusHistoryById(Long logId) {
		return repository.findById(logId).get();
	}

	@Override
	public void delete(StatusHistory statusHistory) {
		repository.delete(statusHistory);
	}

	@Override
	public StatusHistory update(StatusHistory statusHistory) {
		return repository.save(statusHistory);
	}

}
