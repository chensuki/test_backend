package com.test.backend.entity;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 项目实体
 *
 * 作用：承载 t_project 表对应的数据结构。
 */
@Getter
@Setter
public class ProjectEntity {
    /** 项目ID */
    /** 项目ID */
    private Long id;
    /** 项目名称 */
    /** 项目名称 */
    private String name;
    /** 项目描述（可空） */
    /** 项目描述（可空） */
    private String description;
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


