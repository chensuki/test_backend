package com.test.backend.entity;


import lombok.Getter;
import lombok.Setter;

/**
 * 项目实体
 *
 * 作用：承载 projects 表对应的数据结构。
 */
@Getter
@Setter
public class ProjectEntity {
    /** 项目ID */
    private Long id;
    /** 项目名称 */
    private String name;
    /** 项目描述（可空） */
    private String description;
}


