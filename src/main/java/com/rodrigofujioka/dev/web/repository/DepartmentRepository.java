package com.rodrigofujioka.dev.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rodrigofujioka.dev.web.domain.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
	
	List<Department> findDepartmentById(Long id);
	
	List<Department> findDepartmentByDepartmentName(String departmentName);

}
