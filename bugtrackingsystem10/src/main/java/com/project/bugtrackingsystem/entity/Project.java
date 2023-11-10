package com.project.bugtrackingsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "projects")
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "proj_id")
	private Integer projId;

	@Column(name = "proj_name")
	private String projName;

	@Column(name = "project_description")
	private String projectDescription;

	@Column(name = "proj_status")
	private String projStatus;
	
	@ManyToMany
    @JoinTable(name = "project_user",
            joinColumns = @JoinColumn(name = "proj_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;

//	@ManyToMany
//    @JoinTable(name = "project_developer",
//            joinColumns = @JoinColumn(name = "proj_id"),
//            inverseJoinColumns = @JoinColumn(name = "dev_id"))
//    private List<Developer> developers;

//    @ManyToMany
//    @JoinTable(name = "project_test_Engineers",
//            joinColumns = @JoinColumn(name = "proj_id"),
//            inverseJoinColumns = @JoinColumn(name = "test_eng_id"))
//    private List<TestEngineer> testEngineers;

	// Constructors
	public Project() {
	}

	

	public Project(Integer projId, String projName, String projectDescription, String projStatus,
			List<User> users) {
		super();
		this.projId = projId;
		this.projName = projName;
		this.projectDescription = projectDescription;
		this.projStatus = projStatus;
		this.users=users;
//		this.developers = developers;
//		this.testEngineers = testEngineers;
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



//	public List<Developer> getDevelopers() {
//		return developers;
//	}
//
//
//
//	public void setDevelopers(List<Developer> developers) {
//		this.developers = developers;
//	}



	public List<User> getUsers() {
		return users;
	}



	public void setUsers(List<User> users) {
		this.users = users;
	}

	

	@Override
	public String toString() {
		return "Project [projId=" + projId + ", projName=" + projName + ", projectDescription=" + projectDescription
				+ ", projStatus=" + projStatus + ", users=" + users + "]";
	}



	public void setStartDate(Object startDate) {
		// TODO Auto-generated method stub
		
	}



	public void setEndDate(Object endDate) {
		// TODO Auto-generated method stub
		
	}



	



}