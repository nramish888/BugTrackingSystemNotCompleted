package com.project.bugtrackingsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("testEngineerId")
public class TestEngineer extends User {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer testEngineerId;
	private String testerName;
	private String testerSkill;

//	@ManyToMany(mappedBy = "testEngineers")
//	private List<Project> projects;

	// Constructors
	public TestEngineer() {
	}

	public TestEngineer(Integer userId, String userName, String userPassword, String userEmail, String userContact,
			String userRole, String testerName, String testerSkill,List<Project> projects) {
		super(userId, userName, userPassword, userEmail, userContact, userRole,projects);
		this.testEngineerId=userId;
		this.testerName = testerName;
		this.testerSkill = testerSkill;
		//this.projects = projects;
	}

	// Getters and Setters
	
	public Integer getTestEngineerId() {
		return testEngineerId;
	}

	public void setTestEngineerId(Integer testEngineerId) {
		this.testEngineerId = testEngineerId;
	}
	
	public String getTesterName() {
		return testerName;
	}

	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}

	public String getTesterSkill() {
		return testerSkill;
	}

	public void setTesterSkill(String testerSkill) {
		this.testerSkill = testerSkill;
	}

	@Override
	public String toString() {
		return "TestEngineer [testEngineerId=" + testEngineerId + ", testerName=" + testerName + ", testerSkill="
				+ testerSkill + "]";
	}

//	public List<Project> getProjects() {
//		return projects;
//	}
//
//	public void setProjects(List<Project> projects) {
//		this.projects = projects;
//	}

//	@Override
//	public String toString() {
//		return "TestEngineer{" + "testerName='" + testerName + '\'' + ", testerSkill='" + testerSkill + '\''
//				+ ", projects=" + projects + "} " + super.toString();
//	}
	
}
