package com.rodrigofujioka.dev.web.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigofujioka.dev.web.domain.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
	List<Task> findTaskById(Long id);
	
	List<Task> findTaskByTitle(String title);
	
	List<Task> findTaskByDescription(String description);
	
	List<Task> findTaskByTaskPoints(Long taskPoints);
	
	List<Task> findTaskByStatus(Long Status);
	
	List<Task> findTaskByStartDate(Date startDate);
	
	List<Task> findTaskByEndDate(Date endDate);
	
	List<Task> findTaskByStartDateBetween(Date dataInicial, Date dataFinal);
	
	List<Task> findTaskByTaskPointsBetween(int pontoInicial, int pontoFinal);
	
	List<Task> findTaskByStartDateBetweenAndStatus(Date dataInicial, Date dataFinal, int status);

}
