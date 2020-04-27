package com.rodrigofujioka.dev.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rodrigofujioka.dev.web.domain.Department;
import com.rodrigofujioka.dev.web.repository.DepartmentRepository;
import com.rodrigofujioka.dev.web.service.dto.DepartmentDTO;

import javassist.NotFoundException;

@Service
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public DepartmentDTO save(DepartmentDTO dto) {		
		Department department = new Department();
		BeanUtils.copyProperties(dto, department);
		departmentRepository.save(department);
		return dto;
	}
	
	public DepartmentDTO getDepartmentById(Long id) throws NotFoundException {
		Optional<Department> department = departmentRepository.findById(id);
		if(!department.isPresent())
			throw new NotFoundException("Department não encontrado");
		
		return new DepartmentDTO(department.get());	
	}
	
	public Department salvar(Department department) {		
		return departmentRepository.save(department);
	}
	
	public Department consultaPorId(Long id) {
		return departmentRepository.findById(id).get();				
	}
	
	public List<Department> getDepartmentByDepartmentName(String departmentName) {
		return departmentRepository.findDepartmentByDepartmentName(departmentName);
	}
	
	public void deletePorId(Long id) {
		departmentRepository.deleteById(id);
	}
	
	public List<Department> listar(){
		return departmentRepository.findAll();
	}
	
	public Department update(Department department) {
		if(department!=null) {
			return departmentRepository.save(department);
		}
		throw new RuntimeException("ID precisar ser informado");
	}

}
