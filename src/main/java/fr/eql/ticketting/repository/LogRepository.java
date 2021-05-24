package fr.eql.ticketting.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eql.ticketting.entity.Log;

public interface LogRepository extends JpaRepository<Log, Long>{

}
