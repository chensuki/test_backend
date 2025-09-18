package com.test.backend.service.impl;

import com.test.backend.dto.param.TimesheetCreateParam;
import com.test.backend.dto.result.TimesheetResult;
import com.test.backend.entity.ProjectEntity;
import com.test.backend.entity.TimesheetEntity;
import com.test.backend.mapper.TimesheetMapper;
import com.test.backend.repository.ProjectRepository;
import com.test.backend.repository.TimesheetRepository;
import com.test.backend.service.TimesheetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimesheetServiceImpl implements TimesheetService {

    private final TimesheetRepository timesheetRepository;
    private final ProjectRepository projectRepository;

    public TimesheetServiceImpl(TimesheetRepository timesheetRepository, ProjectRepository projectRepository) {
        this.timesheetRepository = timesheetRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<TimesheetResult> list() {
        return timesheetRepository.findAllWithProject().stream()
                .map(tp -> TimesheetMapper.toResult(tp.getTimesheet(), tp.getProject()))
                .collect(Collectors.toList());
    }

    @Override
    public void create(TimesheetCreateParam param) {
        TimesheetEntity entity = TimesheetMapper.toEntity(param);
        // basic existence check
        projectRepository.findById(entity.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("project not found"));
        timesheetRepository.insert(entity);
    }

    @Override
    public void delete(Long id) {
        timesheetRepository.deleteById(id);
    }
}


