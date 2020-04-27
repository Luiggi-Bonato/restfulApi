package com.rodrigofujioka.dev.web.rest;

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

import com.rodrigofujioka.dev.web.domain.Department;
import com.rodrigofujioka.dev.web.domain.Person;
import com.rodrigofujioka.dev.web.domain.Project;
import com.rodrigofujioka.dev.web.service.ProjectService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class ProjectRest {
	
	@Autowired
	private ProjectService projectService;
	
	@PostMapping("/project")
	public ResponseEntity<Project> salvar(@RequestBody @Valid Project project) {
		return ResponseEntity.ok(projectService.salvar(project));
	}
	
	@PutMapping("/project")
	public ResponseEntity<Project> update(@RequestBody @Valid Project project) {
		return ResponseEntity.ok(projectService.update(project));
	}
	

	@GetMapping("/project/{id}")
	public ResponseEntity<Project> consultaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(projectService.consultaPorId(id));
	}
	
	@GetMapping("/project/{projectTitle}")
	public ResponseEntity<List<Project>> getProjectByProjectTitle(@PathVariable String projectTitle) {
		return ResponseEntity.ok(projectService.getProjectByProjectTitle(projectTitle));
	}
	
	@GetMapping("/project/{manager}")
	public ResponseEntity<List<Project>> getProjectByManager(@PathVariable Person manager) {
		return ResponseEntity.ok(projectService.getProjectByManager(manager));
	}
	
	@GetMapping("/project/{minSalary}")
	public ResponseEntity<List<Project>> getProjectByMinSalary(@PathVariable Long minSalary) {
		return ResponseEntity.ok(projectService.getProjectByMinSalary(minSalary));
	}
	
	@GetMapping("/project/{maxSalary}")
	public ResponseEntity<List<Project>> getProjectByMaSalary(@PathVariable Long maxSalary) {
		return ResponseEntity.ok(projectService.getProjectByMaxSalary(maxSalary));
	}
	
	@GetMapping("/department")
	public ResponseEntity<List<Project>> listar() {
		return ResponseEntity.ok(projectService.listar());
	}

	@DeleteMapping("/project/{id}")
	public ResponseEntity<Project> deletePorId(@PathVariable Long id) {
		try {
			projectService.deletePorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
