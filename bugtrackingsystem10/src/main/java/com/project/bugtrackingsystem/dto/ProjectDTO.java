package com.project.bugtrackingsystem.dto;

import java.util.List;

public class ProjectDTO {

    private Integer projId;
    private String projName;
    private String projectDescription;
    private String projStatus;
    private List<DeveloperDTO> devList;
    private List<TestEngineerDTO> testEngList;

    // Constructors, getters, and setters

    public ProjectDTO() {
    	super();
    }

    public ProjectDTO(Integer projId, String projName, String projectDescription, String projStatus, List<DeveloperDTO> devList, List<TestEngineerDTO> testEngList) {
        this.projId = projId;
        this.projName = projName;
        this.projectDescription = projectDescription;
        this.projStatus = projStatus;
        this.devList = devList;
        this.testEngList = testEngList;
    }
    
    

    public Integer getProjId() {
        return projId;
    }

    public void setProjId(Integer projId) {
        this.projId = projId;
    }

    public String getProjName() {
        return projName;
    }

    public void setProjName(String projName) {
        this.projName = projName;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjStatus() {
        return projStatus;
    }

    public void setProjStatus(String projStatus) {
        this.projStatus = projStatus;
    }

    public List<DeveloperDTO> getDevList() {
        return devList;
    }

    public void setDevList(List<DeveloperDTO> devList) {
        this.devList = devList;
    }

    public List<TestEngineerDTO> getTestEngList() {
        return testEngList;
    }

    public void setTestEngList(List<TestEngineerDTO> testEngList) {
        this.testEngList = testEngList;
    }

	public void setId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	public Object getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}
}
