package com.test.backend.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * 工时实体
 *
 * 作用：承载 timesheets 表对应的数据结构。
 */
@Getter
@Setter
public class TimesheetEntity {
    /** 工时ID */
    private Long id;
    /** 关联的项目ID（外键） */
    private Long projectId;
    /** 工作日期 */
    private LocalDate workDate;
    /** 工时（小时，保留两位） */
    private double hours;
    /** 备注（可空） */
    private String notes;
}


