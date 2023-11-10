package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.BugDTO;
import java.time.LocalDate;
import java.util.List;
 
public interface BugService {
	
    public BugDTO createBug(BugDTO bugDTO);
    public BugDTO updateBug(BugDTO bugDTO);
    public BugDTO findBugById(Integer bugId);
    
    public List<BugDTO> findAllBugs();
    public List<BugDTO> findAllBugsByProjectId(Integer projId);
    public List<BugDTO> findBugsAssignedToDeveloper(Integer devId);
    
    public List<BugDTO> findBugsAssignedToDeveloperByStatus(Integer devId, String status);
    public List<BugDTO> findBugsByStatus(String status); 
    public List<BugDTO> findBugsBySeverity(String severity);
    public List<BugDTO> findBugsByDate(LocalDate date);
    public List<BugDTO> findBugsByDevIdAndDate(Integer devId, LocalDate startDate, LocalDate endDate);
    public List<BugDTO> findBugsCreatedByTestEngineer(Integer testEngId);
    public List<BugDTO> findBugsByProjectIdAndDevId(Integer projId, Integer devId);
    public List<BugDTO> findBugsByProjectIdAndTestEngId(Integer projId, Integer testEngId);
}