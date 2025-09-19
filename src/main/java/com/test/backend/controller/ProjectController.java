package com.test.backend.controller;

import com.test.backend.dto.param.ProjectCreateParam;
import com.test.backend.dto.result.ProjectResult;
import com.test.backend.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 项目控制器
 *
 * 路径前缀：/api/projects
 * 提供：
 *  - GET  /list        查询项目列表
 *  - POST /create      新建项目
 *  - DELETE /delete/{id} 删除项目
 */
@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/list")
    /**
     * 查询项目列表
     */
    public List<ProjectResult> list() {
        return projectService.list();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * 新建项目
     */
    public ProjectResult create(@Valid @RequestBody ProjectCreateParam param) {
        return projectService.create(param);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**
     * 删除项目
     */
    public void delete(@PathVariable Long id) {
        projectService.delete(id);
    }
}


