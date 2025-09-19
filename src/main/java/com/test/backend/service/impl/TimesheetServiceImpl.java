package com.test.backend.service.impl;

import com.test.backend.dto.param.TimesheetCreateParam;
import com.test.backend.dto.result.TimesheetResult;
import com.test.backend.entity.TimesheetEntity;
import com.test.backend.mapper.TimesheetMapper;
import com.test.backend.repository.ProjectRepository;
import com.test.backend.repository.TimesheetRepository;
import com.test.backend.service.TimesheetService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 工时服务实现
 *
 * 职责：
 * 1. 提供工时数据的查询、创建、删除能力
 * 2. 在创建时做基础的数据校验（如项目是否存在）
 */
@Service
public class TimesheetServiceImpl implements TimesheetService {

    private final TimesheetRepository timesheetRepository;
    private final ProjectRepository projectRepository;

    public TimesheetServiceImpl(TimesheetRepository timesheetRepository, ProjectRepository projectRepository) {
        this.timesheetRepository = timesheetRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    /**
     * 查询所有工时（携带项目信息）
     * @return 工时结果列表
     */
    public List<TimesheetResult> list() {
        return timesheetRepository.findAllWithProject().stream()
                .map(tp -> TimesheetMapper.toResult(tp.getTimesheet(), tp.getProject()))
                .collect(Collectors.toList());
    }

    @Override
    /**
     * 创建工时记录
     * @param param 创建参数
     * @throws IllegalArgumentException 当关联项目不存在时
     */
    public void create(TimesheetCreateParam param) {
        TimesheetEntity entity = TimesheetMapper.toEntity(param);
        
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
        
        // basic existence check
        projectRepository.findById(entity.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("project not found"));
        timesheetRepository.insert(entity);
    }

    @Override
    /**
     * 删除工时
     * @param id 工时ID
     */
    public void delete(Long id) {
        timesheetRepository.deleteById(id);
    }
}


