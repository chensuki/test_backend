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

/**
 * 项目服务实现
 *
 * 职责：
 * 1. 提供项目的查询、创建、删除能力
 * 2. 在创建时进行必要的业务校验（如名称必填）
 */
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    /**
     * 查询所有项目
     * @return 项目结果列表
     */
    public List<ProjectResult> list() {
        return projectRepository.findAll().stream()
                .map(ProjectMapper::toResult)
                .collect(Collectors.toList());
    }

    @Override
    /**
     * 创建项目
     * @param param 创建参数
     * @return 创建后的项目结果
     * @throws BusinessException 当名称为空时
     */
    public ProjectResult create(ProjectCreateParam param) {
        if (param.getName() == null || param.getName().isBlank()) {
            throw new BusinessException("INVALID_PARAM", "name is required");
        }
        ProjectEntity entity = ProjectMapper.toEntity(param);
        
        // 设置默认值
        if (entity.getCreateTime() == null) {
            entity.setCreateTime(java.time.LocalDateTime.now());
        }
        if (entity.getCreateUser() == null) {
            entity.setCreateUser(0L);
        }
        if (entity.getDeleted() == null) {
            entity.setDeleted(0);
        }
        
        projectRepository.insert(entity);
        return ProjectMapper.toResult(entity);
    }

    @Override
    /**
     * 删除项目
     * @param id 项目ID
     */
    public void delete(Long id) {
        projectRepository.deleteById(id);
    }
}


