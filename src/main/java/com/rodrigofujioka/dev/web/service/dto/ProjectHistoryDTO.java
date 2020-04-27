package com.rodrigofujioka.dev.web.service.dto;

import java.util.Date;

import com.rodrigofujioka.dev.web.domain.Person;
import com.rodrigofujioka.dev.web.domain.ProjectHistory;

public class ProjectHistoryDTO {
	
	private Long id;
	private Date startDate = new Date();
	private Date endDate = new Date();
	private Person manager = new Person();
	
	public ProjectHistoryDTO(ProjectHistory projectHistory) {
		this.id = projectHistory.getId();
		this.startDate = projectHistory.getStartDate();
		this.endDate = projectHistory.getEndDate();
		this.manager = projectHistory.getManager();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Person getManager() {
		return manager;
	}

	public void setManager(Person manager) {
		this.manager = manager;
	}
	
	

}
