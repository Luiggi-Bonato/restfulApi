package com.rodrigofujioka.dev.web.service.dto;

import com.rodrigofujioka.dev.web.domain.Department;

public class DepartmentDTO {
	
	private Long id;
	private String departmentName;
	
	public DepartmentDTO(Department department) {
		this.id = department.getId();
		this.departmentName = department.getDepartmentName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	

}
