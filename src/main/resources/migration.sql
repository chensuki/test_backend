-- 数据库迁移脚本：从旧表结构迁移到规范化表结构
-- 执行前请备份数据库！

-- 1. 创建新的规范化表结构
-- 项目表
CREATE TABLE IF NOT EXISTS t_project (
  id bigint PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
  name varchar(255) NOT NULL COMMENT '项目名称',
  description text NULL COMMENT '项目描述',
  create_time datetime DEFAULT NULL COMMENT '创建时间',
  create_user bigint DEFAULT NULL COMMENT '创建人',
  update_time datetime DEFAULT NULL COMMENT '修改时间',
  update_user bigint DEFAULT NULL COMMENT '修改人',
  deleted tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0否 1是）',
  KEY idx_t_project_name (name)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='项目表';

-- 工时记录表
CREATE TABLE IF NOT EXISTS t_timesheet (
  id bigint PRIMARY KEY AUTO_INCREMENT COMMENT '主键ID',
  project_id bigint NOT NULL COMMENT '项目ID',
  work_date date NOT NULL COMMENT '工作日期',
  hours decimal(5,2) NOT NULL COMMENT '工时(小时)',
  notes text NULL COMMENT '备注',
  create_time datetime DEFAULT NULL COMMENT '创建时间',
  create_user bigint DEFAULT NULL COMMENT '创建人',
  update_time datetime DEFAULT NULL COMMENT '修改时间',
  update_user bigint DEFAULT NULL COMMENT '修改人',
  deleted tinyint NOT NULL DEFAULT 0 COMMENT '是否删除（0否 1是）',
  KEY idx_t_timesheet_project (project_id),
  KEY idx_t_timesheet_date (work_date),
  CONSTRAINT fk_t_timesheet_project 
    FOREIGN KEY (project_id) 
    REFERENCES t_project(id) 
    ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='工时记录表';

-- 2. 迁移现有数据（如果存在旧表）
-- 迁移项目数据
INSERT INTO t_project (id, name, description, create_time, create_user, deleted)
SELECT 
    id, 
    name, 
    description, 
    NOW() as create_time, 
    0 as create_user, 
    0 as deleted
FROM projects 
WHERE NOT EXISTS (SELECT 1 FROM t_project WHERE t_project.id = projects.id);

-- 迁移工时数据
INSERT INTO t_timesheet (id, project_id, work_date, hours, notes, create_time, create_user, deleted)
SELECT 
    t.id, 
    t.project_id, 
    t.work_date, 
    t.hours, 
    t.notes, 
    NOW() as create_time, 
    0 as create_user, 
    0 as deleted
FROM timesheets t
WHERE NOT EXISTS (SELECT 1 FROM t_timesheet WHERE t_timesheet.id = t.id);

-- 3. 验证数据迁移
SELECT 'Projects migrated:' as info, COUNT(*) as count FROM t_project;
SELECT 'Timesheets migrated:' as info, COUNT(*) as count FROM t_timesheet;

-- 4. 删除旧表（谨慎操作！请确认数据迁移成功后再执行）
DROP TABLE IF EXISTS timesheets;
DROP TABLE IF EXISTS projects;
