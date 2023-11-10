package com.project.bugtrackingsystem.service;

import com.project.bugtrackingsystem.dto.BugDTO;
import com.project.bugtrackingsystem.entity.Bug;
import com.project.bugtrackingsystem.exception.BugException;
import com.project.bugtrackingsystem.repository.BugRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BugServiceImpl implements BugService {

    @Autowired
    private BugRepository bugRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public BugDTO createBug(BugDTO bugDTO) {
        Bug bug = modelMapper.map(bugDTO, Bug.class);
        bug = bugRepository.save(bug);
        return modelMapper.map(bug, BugDTO.class);
    }

    @Override
    public BugDTO updateBug(BugDTO bugDTO) {
        Bug existingBugEntity = bugRepository.findById(bugDTO.getBugId()).orElse(null);

        if (existingBugEntity != null) {
            // Update the fields as needed
            existingBugEntity.setBugTitle(bugDTO.getBugTitle());
            existingBugEntity.setBugDescription(bugDTO.getBugDescription());
            existingBugEntity.setSeverity(bugDTO.getSeverity());
//            existingBugEntity.setCreatedBy(modelMapper.map(bugDTO.getCreatedBy(), TestEngineer.class));
//            existingBugEntity.setAssignTo(modelMapper.map(bugDTO.getAssignTo(), Developer.class));
            existingBugEntity.setStatus(bugDTO.getStatus());
            existingBugEntity.setStartDate(bugDTO.getStartDate());
            existingBugEntity.setLastUpdatedDate(bugDTO.getLastUpdatedDate());
//            existingBugEntity.setProject(modelMapper.map(bugDTO.getProject(), Project.class));
            
            existingBugEntity = bugRepository.save(existingBugEntity);
            return modelMapper.map(existingBugEntity, BugDTO.class);
        } else {
            return null; // Handle the case where the bug is not found
        }
    }

    @Override
    public BugDTO findBugById(Integer bugId) {
        Bug bugEntity = bugRepository.findById(bugId).orElse(null);

        if (bugEntity != null) {
            return modelMapper.map(bugEntity, BugDTO.class);
        } else {
            return null; // Handle the case where the bug is not found
        }
    }

    @Override
    public List<BugDTO> findAllBugs() {
        List<Bug> bugEntities = bugRepository.findAll();

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findAllBugsByProjectId(Integer projId) {
        List<Bug> bugEntities = bugRepository.findAllByProjectProjId(projId);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findBugsAssignedToDeveloper(Integer devId) {
        List<Bug> bugEntities = bugRepository.findAllByAssignToDevId(devId);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findBugsAssignedToDeveloperByStatus(Integer devId, String status) {
        List<Bug> bugEntities = bugRepository.findAllByAssignToDevIdAndStatus(devId, status);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findBugsByStatus(String status) {
        List<Bug> bugEntities = bugRepository.findAllByStatus(status);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findBugsBySeverity(String severity) {
        List<Bug> bugEntities = bugRepository.findAllBySeverity(severity);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }


    @Override
    public List<BugDTO> findBugsByDate(LocalDate date) throws BugException {
        List<Bug> bugEntities = bugRepository.findAllByStartDate(date);

        if(bugEntities.isEmpty()) {
            throw new BugException("No bugs found with start date: " + date);
        }

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findBugsByDevIdAndDate(Integer devId, LocalDate startDate, LocalDate endDate) {
        List<Bug> bugEntities = bugRepository.findAllByAssignToDevIdAndStartDateBetween(devId, startDate, endDate);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findBugsCreatedByTestEngineer(Integer testEngId) {
        List<Bug> bugEntities = bugRepository.findAllByCreatedByTestEngineerId(testEngId);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findBugsByProjectIdAndDevId(Integer projId, Integer devId) {
        List<Bug> bugEntities = bugRepository.findAllByProjectProjIdAndAssignToDevId(projId, devId);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BugDTO> findBugsByProjectIdAndTestEngId(Integer projId, Integer testEngId) {
        List<Bug> bugEntities = bugRepository.findAllByProjectProjIdAndCreatedByTestEngineerId(projId, testEngId);

        return bugEntities.stream()
                .map(bug -> modelMapper.map(bug, BugDTO.class))
                .collect(Collectors.toList());
    }
}
