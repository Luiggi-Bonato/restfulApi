package com.rodrigofujioka.dev.web.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigofujioka.dev.web.domain.Person;
import com.rodrigofujioka.dev.web.domain.ProjectHistory;

@Repository
public interface ProjectHistoryRepository extends JpaRepository<ProjectHistory, Long> {
	
	List<ProjectHistory> findProjectHistoryById(Long id);
	
	List<ProjectHistory> findProjectHistoryByStartDate(Date startDate);
	
	List<ProjectHistory> findProjectHistoryByEndDate(Date endDate);
	
	List<ProjectHistory> findProjectHistoryByManager(Person manager);

}
