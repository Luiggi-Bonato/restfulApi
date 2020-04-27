package com.rodrigofujioka.dev.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigofujioka.dev.web.domain.Person;
import com.rodrigofujioka.dev.web.domain.Project;
import com.rodrigofujioka.dev.web.repository.ProjectRepository;


import javassist.NotFoundException;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;
	
	public Project salvar(Project project) {		
		return projectRepository.save(project);
	}
	
	public Project consultaPorId(Long id) {
		return projectRepository.findById(id).get();				
	}
	
	public List<Project> getProjectByProjectTitle(String projectTitle){
		return projectRepository.findProjectByProjectTitle(projectTitle);
	}
	
	public List<Project> getProjectByManager(Person manager){
		return projectRepository.findProjectByManager(manager);
	}
	
	public List<Project> getProjectByMinSalary(Long minSalary){
		return projectRepository.findProjectByMinSalary(minSalary);
	}
	
	public List<Project> getProjectByMaxSalary(Long maxSalary){
		return projectRepository.findProjectByMaxSalary(maxSalary);
	}
	
	public void deletePorId(Long id) {
		projectRepository.deleteById(id);
	}
	
	public List<Project> listar(){
		return projectRepository.findAll();
	}
	
	public Project update(Project project) {
		if(project!=null) {
			return projectRepository.save(project);
		}
		throw new RuntimeException("ID precisar ser informado");
	}

}
