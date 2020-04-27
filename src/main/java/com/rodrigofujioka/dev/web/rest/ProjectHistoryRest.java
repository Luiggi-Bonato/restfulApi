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

import com.rodrigofujioka.dev.web.domain.Person;
import com.rodrigofujioka.dev.web.domain.ProjectHistory;
import com.rodrigofujioka.dev.web.service.ProjectHistoryService;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class ProjectHistoryRest {
	
	@Autowired
	private ProjectHistoryService projectHistoryService;
	
	@PostMapping("/projectHistory")
	public ResponseEntity<ProjectHistory> salvar(@RequestBody @Valid ProjectHistory projectHistory) {
		return ResponseEntity.ok(projectHistoryService.salvar(projectHistory));
	}
	
	@PutMapping("/projectHistory")
	public ResponseEntity<ProjectHistory> update(@RequestBody @Valid ProjectHistory projectHistory) {
		return ResponseEntity.ok(projectHistoryService.update(projectHistory));
	}
	

	@GetMapping("/projectHistory/{id}")
	public ResponseEntity<ProjectHistory> consultaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(projectHistoryService.consultaPorId(id));
	}
	
	@GetMapping("/projectHistory/{startDate}")
	public ResponseEntity<List<ProjectHistory>> getProjectHistoryByStartDate(@PathVariable Date startDate) {
		return ResponseEntity.ok(projectHistoryService.getProjectHistoryByStartDate(startDate));
	}
	
	@GetMapping("/projectHistory/{endDate}")
	public ResponseEntity<List<ProjectHistory>> getProjectHistoryByEndDate(@PathVariable Date endDate) {
		return ResponseEntity.ok(projectHistoryService.getProjectHistoryByEndDate(endDate));
	}
	
	@GetMapping("/projectHistory/{manager}")
	public ResponseEntity<List<ProjectHistory>> getProjectHistoryByManager(@PathVariable Person manager) {
		return ResponseEntity.ok(projectHistoryService.getProjectHistoryByManager(manager));
	}
	
	@GetMapping("/projectHistory")
	public ResponseEntity<List<ProjectHistory>> listar() {
		return ResponseEntity.ok(projectHistoryService.listar());
	}

	@DeleteMapping("/projectHistory/{id}")
	public ResponseEntity<ProjectHistory> deletePorId(@PathVariable Long id) {
		try {
			projectHistoryService.deletePorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
