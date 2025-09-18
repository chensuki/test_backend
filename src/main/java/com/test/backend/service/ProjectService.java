package com.test.backend.service;

import com.test.backend.dto.param.ProjectCreateParam;
import com.test.backend.dto.result.ProjectResult;

import java.util.List;

public interface ProjectService {
    List<ProjectResult> list();
    ProjectResult create(ProjectCreateParam param);
    void delete(Long id);
}


