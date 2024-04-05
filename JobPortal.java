package com.jsp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class JobPortal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String skill;
	private String state;

	public String getSkill() {
		return skill;
	}

	public String getState() {
		return state;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public void setState(String state) {
		this.state = state;
	}

	private String role;
	private String location;
	private String company;

	public int getId() {
		return id;
	}

	public String getRole() {
		return role;
	}

	public String getLocation() {
		return location;
	}

	public String getCompany() {
		return company;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public void setCompany(String company) {
		this.company = company;
	}

}
