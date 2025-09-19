package com.test.backend.repository;

import com.test.backend.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface ProjectRepository {

    /**
     * 查询所有未删除的项目
     */
    List<ProjectEntity> findAll();

    /**
     * 根据ID查询项目
     */
    Optional<ProjectEntity> findById(@Param("id") Long id);

    /**
     * 插入项目
     */
    void insert(ProjectEntity project);

    /**
     * 软删除项目
     */
    void deleteById(@Param("id") Long id);
}


