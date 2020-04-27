package com.rodrigofujioka.dev.web.rest;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigofujioka.dev.web.domain.Task;
import com.rodrigofujioka.dev.web.service.TaskService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class TaskRest {
	
	@Autowired
	private TaskService taskService;
	
	@PostMapping("/task")
	public ResponseEntity<Task> salvar(@RequestBody @Valid Task task) {
		return ResponseEntity.ok(taskService.salvar(task));
	}
	
	@PutMapping("/task")
	public ResponseEntity<Task> update(@RequestBody @Valid Task task) {
		return ResponseEntity.ok(taskService.update(task));
	}
	

	@GetMapping("/task/{id}")
	public ResponseEntity<Task> consultaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(taskService.consultaPorId(id));
	}
	
	@GetMapping("/task/{title}")
	public ResponseEntity<List<Task>> getTaskByTitle(@PathVariable String title) {
		return ResponseEntity.ok(taskService.getTaskByTitle(title));
	}
	
	@GetMapping("/task/{description}")
	public ResponseEntity<List<Task>> getTaskByDescription(@PathVariable String description) {
		return ResponseEntity.ok(taskService.getTaskByDescription(description));
	}
	
	@GetMapping("/task/{taskPoints}")
	public ResponseEntity<List<Task>> getTaskByTaskPoints(@PathVariable Long taskPoints) {
		return ResponseEntity.ok(taskService.getTaskByTaskPoints(taskPoints));
	}
	
	@GetMapping("/task/{status}")
	public ResponseEntity<List<Task>> getTaskByStatus(@PathVariable Long status) {
		return ResponseEntity.ok(taskService.getTaskByStatus(status));
	}
	
	@GetMapping("/task/{startDate}")
	public ResponseEntity<List<Task>> getTaskByStartDate(@PathVariable Date startDate) {
		return ResponseEntity.ok(taskService.getTaskByStartDate(startDate));
	}
	
	@GetMapping("/task/{endDate}")
	public ResponseEntity<List<Task>> getTaskByEndDate(@PathVariable Date endDate) {
		return ResponseEntity.ok(taskService.getTaskByEndDate(endDate));
	}
	
	@GetMapping("/disciplina/busca/{dataInicial}/{dataFinal}")
	public ResponseEntity<List<Task>> getTaskByStartDateBetween(@PathVariable Date dataInicial, @PathVariable Date dataFinal){
		return ResponseEntity.ok(taskService.getTaskByStartDateBetween(dataInicial, dataFinal));
	}
	
	@GetMapping("/disciplina/busca/{pontoInicial}/{pontoFinal}")
	public ResponseEntity<List<Task>> getTaskByTaskPointsBetween(@PathVariable int pontoInicial, @PathVariable int pontoFinal){
		return ResponseEntity.ok(taskService.getTaskByTaskPointsBetween(pontoInicial, pontoFinal));
	}
	
	@GetMapping("/disciplina/busca/{dataInicial}/{dataFinal}/{status}")
	public ResponseEntity<List<Task>> getTaskByStartDateBetweenAndStatus(@PathVariable Date dataInicial, @PathVariable Date dataFinal, @PathVariable int status){
		return ResponseEntity.ok(taskService.getTaskByStartDateBetweenAndStatus(dataInicial, dataFinal, status));
	}
	
	@GetMapping("/task")
	public ResponseEntity<List<Task>> listar() {
		return ResponseEntity.ok(taskService.listar());
	}

	@DeleteMapping("/task/{id}")
	public ResponseEntity<Task> deletePorId(@PathVariable Long id) {
		try {
			taskService.deletePorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
