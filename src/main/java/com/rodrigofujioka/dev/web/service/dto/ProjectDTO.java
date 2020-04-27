package com.rodrigofujioka.dev.web.service.dto;

import com.rodrigofujioka.dev.web.domain.Person;
import com.rodrigofujioka.dev.web.domain.Project;

public class ProjectDTO {
	
	private Long id;
	private String projectTitle;
	private Person manager = new Person();
	private Long minSalary;
	private Long maxSalary;
	
	public ProjectDTO(Project project) {
		this.id = project.getId();
		this.projectTitle = project.getProjectTitle();
		this.manager = project.getManager();
		this.minSalary = project.getMinSalary();
		this.maxSalary = project.getMaxSalary();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProjectTitle() {
		return projectTitle;
	}

	public void setProjectTitle(String projectTitle) {
		this.projectTitle = projectTitle;
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}

	public Long getMinSalary() {
		return minSalary;
	}

	public void setMinSalary(Long minSalary) {
		this.minSalary = minSalary;
	}

	public Long getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(Long maxSalary) {
		this.maxSalary = maxSalary;
	}
	
	

}
