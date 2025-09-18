package com.test.backend.controller;

import com.test.backend.dto.param.ProjectCreateParam;
import com.test.backend.dto.result.ProjectResult;
import com.test.backend.service.ProjectService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<ProjectResult> list() {
        return projectService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProjectResult create(@Valid @RequestBody ProjectCreateParam param) {
        return projectService.create(param);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        projectService.delete(id);
    }
}


