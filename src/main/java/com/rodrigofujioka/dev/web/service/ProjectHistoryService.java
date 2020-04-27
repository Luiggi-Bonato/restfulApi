package com.rodrigofujioka.dev.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigofujioka.dev.web.domain.Person;
import com.rodrigofujioka.dev.web.domain.ProjectHistory;
import com.rodrigofujioka.dev.web.repository.ProjectHistoryRepository;


import javassist.NotFoundException;

@Service
public class ProjectHistoryService {
	
	@Autowired
	private ProjectHistoryRepository projectHistoryRepository;
	
	public ProjectHistory salvar(ProjectHistory projectHistory) {		
		return projectHistoryRepository.save(projectHistory);
	}
	
	public ProjectHistory consultaPorId(Long id) {
		return projectHistoryRepository.findById(id).get();				
	}
	
	public List<ProjectHistory> getProjectHistoryByStartDate(Date startDate) {
		return projectHistoryRepository.findProjectHistoryByStartDate(startDate);
	}
	
	public List<ProjectHistory> getProjectHistoryByEndDate(Date endDate) {
		return projectHistoryRepository.findProjectHistoryByEndDate(endDate);
	}
	
	public List<ProjectHistory> getProjectHistoryByManager(Person manager) {
		return projectHistoryRepository.findProjectHistoryByManager(manager);
	}
	
	public void deletePorId(Long id) {
		projectHistoryRepository.deleteById(id);
	}
	
	public List<ProjectHistory> listar(){
		return projectHistoryRepository.findAll();
	}
	
	public ProjectHistory update(ProjectHistory projectHistory) {
		if(projectHistory!=null) {
			return projectHistoryRepository.save(projectHistory);
		}
		throw new RuntimeException("ID precisar ser informado");
	}

}
