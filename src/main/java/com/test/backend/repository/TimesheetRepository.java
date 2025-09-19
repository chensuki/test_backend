package com.test.backend.repository;

import com.test.backend.entity.TimesheetEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TimesheetRepository {

    /**
     * 查询所有工时记录（包含项目信息）
     */
    List<TimesheetWithProject> findAllWithProject();

    /**
     * 插入工时记录
     */
    void insert(TimesheetEntity timesheet);

    /**
     * 软删除工时记录
     */
    void deleteById(@Param("id") Long id);
}


