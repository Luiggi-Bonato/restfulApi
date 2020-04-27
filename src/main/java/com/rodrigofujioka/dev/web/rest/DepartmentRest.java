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
import com.rodrigofujioka.dev.web.service.DepartmentService;
import com.rodrigofujioka.dev.web.service.dto.DepartmentDTO;

import javassist.NotFoundException;

@RestController
@RequestMapping("/api")
public class DepartmentRest {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping("/department")
	public ResponseEntity<Department> salvar(@RequestBody @Valid Department department) {
		return ResponseEntity.ok(departmentService.salvar(department));
	}
	
	@PostMapping("/department")
	public ResponseEntity<DepartmentDTO> save(@RequestBody @Valid DepartmentDTO dto) {
		return ResponseEntity.ok(departmentService.save(dto));
	}
	
	@PutMapping("/department")
	public ResponseEntity<Department> update(@RequestBody @Valid Department department) {
		return ResponseEntity.ok(departmentService.update(department));
	}

	@GetMapping("/department/{id}")
	public ResponseEntity<Department> consultaPorId(@PathVariable Long id) {
		return ResponseEntity.ok(departmentService.consultaPorId(id));
	}
	
	@GetMapping("/department/{departmentName}")
	public ResponseEntity<List<Department>> getDepartmentByDepartmentName(@PathVariable String departmentName) {
		return ResponseEntity.ok(departmentService.getDepartmentByDepartmentName(departmentName));
	}
	
	@GetMapping("/department")
	public ResponseEntity<List<Department>> listar() {
		return ResponseEntity.ok(departmentService.listar());
	}

	@DeleteMapping("/department/{id}")
	public ResponseEntity<Department> deletePorId(@PathVariable Long id) {
		try {
			departmentService.deletePorId(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.badRequest().build();
		}

	}

}
