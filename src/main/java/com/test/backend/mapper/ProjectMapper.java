package com.test.backend.mapper;

import com.test.backend.dto.param.ProjectCreateParam;
import com.test.backend.dto.result.ProjectResult;
import com.test.backend.entity.ProjectEntity;

/**
 * 项目映射器
 * 
 * 职责：在DTO和Entity之间进行转换
 */
public class ProjectMapper {
    
    /**
     * 将创建参数转换为实体
     */
    public static ProjectEntity toEntity(ProjectCreateParam param) {
        ProjectEntity entity = new ProjectEntity();
        entity.setName(param.getName());
        entity.setDescription(param.getDescription());
        return entity;
    }
    
    /**
     * 将实体转换为结果DTO
     */
    public static ProjectResult toResult(ProjectEntity entity) {
        ProjectResult result = new ProjectResult();
        result.setId(entity.getId());
        result.setName(entity.getName());
        result.setDescription(entity.getDescription());
        return result;
    }
}

