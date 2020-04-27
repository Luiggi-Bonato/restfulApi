package com.rodrigofujioka.dev.web.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigofujioka.dev.web.domain.Task;
import com.rodrigofujioka.dev.web.repository.TaskRepository;


import javassist.NotFoundException;

@Service
public class TaskService {
	
	@Autowired
	private TaskRepository taskRepository;
	
	public Task salvar(Task task) {		
		return taskRepository.save(task);
	}
	
	public Task consultaPorId(Long id) {
		return taskRepository.findById(id).get();				
	}
	
	public List<Task> getTaskByTitle(String title){
		return taskRepository.findTaskByTitle(title);
	}
	
	public List<Task> getTaskByDescription(String description){
		return taskRepository.findTaskByDescription(description);
	}
	
	public List<Task> getTaskByTaskPoints(Long taskPoints){
		return taskRepository.findTaskByTaskPoints(taskPoints);
	}
	
	public List<Task> getTaskByStatus(Long Status){
		return taskRepository.findTaskByStatus(Status);
	}
	
	public List<Task> getTaskByStartDate(Date startDate){
		return taskRepository.findTaskByStartDate(startDate);
	}
	
	public List<Task> getTaskByEndDate(Date endDate){
		return taskRepository.findTaskByEndDate(endDate);
	}
	
	public List<Task> getTaskByStartDateBetween(Date dataInicial, Date dataFinal){
		List<Task> listaTasks = taskRepository.findTaskByStartDateBetween(dataInicial, dataFinal);
		return listaTasks;
	}
	
	public List<Task> getTaskByTaskPointsBetween(int pontoInicial, int pontoFinal){
		List<Task> listaTasks = taskRepository.findTaskByTaskPointsBetween(pontoInicial, pontoFinal);
		return listaTasks;
	}
	
	public List<Task> getTaskByStartDateBetweenAndStatus(Date dataInicial, Date dataFinal, int status){
		List<Task> listaTasks = taskRepository.findTaskByStartDateBetweenAndStatus(dataInicial, dataFinal, status);
		return listaTasks;
	}
	
	public void deletePorId(Long id) {
		taskRepository.deleteById(id);
	}
	
	public List<Task> listar(){
		return taskRepository.findAll();
	}
	
	public Task update(Task task) {
		if(task!=null) {
			return taskRepository.save(task);
		}
		throw new RuntimeException("ID precisar ser informado");
	}

}
