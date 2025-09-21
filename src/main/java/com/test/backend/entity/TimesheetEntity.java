package com.test.backend.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 工时实体
 *
 * 作用：承载 t_timesheet 表对应的数据结构。
 */
@Getter
@Setter
public class TimesheetEntity {
    /** 工时ID */
    /** 工时ID */
    private Long id;
    /** 关联的项目ID（外键） */
    /** 关联的项目ID（外键） */
    private Long projectId;
    /** 工作日期 */
    /** 工作日期 */
    private LocalDate workDate;
    /** 工时（小时，保留两位） */
    /** 工时（小时，保留两位） */
    private double hours;
    /** 备注（可空） */
    /** 备注（可空） */
    private String notes;
    /** 创建时间 */
    private LocalDateTime createTime;
    /** 创建人 */
    private Long createUser;
    /** 修改时间 */
    private LocalDateTime updateTime;
    /** 修改人 */
    private Long updateUser;
    /** 是否删除（0否 1是） */
    private Integer deleted;
}


