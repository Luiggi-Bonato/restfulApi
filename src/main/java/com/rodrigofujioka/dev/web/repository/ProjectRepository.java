package com.rodrigofujioka.dev.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigofujioka.dev.web.domain.Person;
import com.rodrigofujioka.dev.web.domain.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
	
	List<Project> findProjectById(Long id);
	
	List<Project> findProjectByProjectTitle(String projectTitle);
	
	List<Project> findProjectByManager(Person manager);
	
	List<Project> findProjectByMinSalary(Long minSalary);
	
	List<Project> findProjectByMaxSalary(Long maxSalary);

}
