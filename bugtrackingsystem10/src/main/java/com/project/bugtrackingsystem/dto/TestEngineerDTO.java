package com.project.bugtrackingsystem.dto;

import java.util.List;

public class TestEngineerDTO extends UserDTO {

	private Integer testEngineerId;
	private String testerName;
	private String testerSkill;
//	private List<ProjectDTO> project;
	
	public TestEngineerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TestEngineerDTO(Integer userId, String userName, String userPassword, String userEmail, String userContact,
			String userRole,String testerName, String testerSkill, List<ProjectDTO> project) {
		super(userId, userName, userPassword, userEmail, userContact, userRole);
		this.testEngineerId=userId;
		this.testerName = testerName;
		this.testerSkill = testerSkill;
//		this.project = project;
	}
	
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
//	public List<ProjectDTO> getProject() {
//		return project;
//	}
//	public void setProject(List<ProjectDTO> project) {
//		this.project = project;
//	}
	
	
}
