package com.project.bugtrackingsystem.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("devId") 
public class Developer extends User {

//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer devId;
    private String devName;
    private String devSkill;

  

    // Constructors
    public Developer() {
    }

    public Developer(Integer userId,String userName, String userPassword, String userEmail, String userContact, String userRole,
                     String devName, String devSkill, List<Project> projects) {
        super(userId,userName, userPassword, userEmail, userContact, userRole,projects);
        this.devId=userId;
        this.devName = devName;
        this.devSkill = devSkill;
       // this.projects = projects;
    }

    // Getters and Setters
    public Integer getDevId() {
  		return devId;
  	}

  	public void setDevId(Integer devId) {
  		this.devId = devId;
  	}
  	
    public String getDevName() {
        return devName;
    }

	public void setDevName(String devName) {
        this.devName = devName;
    }

    public String getDevSkill() {
        return devSkill;
    }

    public void setDevSkill(String devSkill) {
        this.devSkill = devSkill;
    }

//    public List<Project> getProjects() {
//        return projects;
//    }
//
//    public void setProjects(List<Project> projects) {
//        this.projects = projects;
//    }

    @Override
    public String toString() {
        return "Developer{" +
                "devName='" + devName + '\'' +
                ", devSkill='" + devSkill + '\'' +
                
                "} " + super.toString();
    }
}
