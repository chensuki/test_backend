package com.test.backend.service.impl;

import com.test.backend.dto.param.ProjectCreateParam;
import com.test.backend.dto.result.ProjectResult;
import com.test.backend.entity.ProjectEntity;
import com.test.backend.exception.BusinessException;
import com.test.backend.mapper.ProjectMapper;
import com.test.backend.repository.ProjectRepository;
import com.test.backend.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectResult> list() {
        return projectRepository.findAll().stream()
                .map(ProjectMapper::toResult)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectResult create(ProjectCreateParam param) {
        if (param.getName() == null || param.getName().isBlank()) {
            throw new BusinessException("INVALID_PARAM", "name is required");
        }
        ProjectEntity entity = ProjectMapper.toEntity(param);
        entity = projectRepository.insert(entity);
        return ProjectMapper.toResult(entity);
    }

    @Override
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}


