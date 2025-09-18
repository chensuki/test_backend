package com.test.backend.mapper;

import com.test.backend.dto.param.ProjectCreateParam;
import com.test.backend.dto.result.ProjectResult;
import com.test.backend.entity.ProjectEntity;

public class ProjectMapper {
    public static ProjectEntity toEntity(ProjectCreateParam param) {
        ProjectEntity e = new ProjectEntity();
        e.setName(param.getName());
        e.setDescription(param.getDescription());
        return e;
    }

    public static ProjectResult toResult(ProjectEntity e) {
        ProjectResult r = new ProjectResult();
        r.setId(e.getId());
        r.setName(e.getName());
        r.setDescription(e.getDescription());
        return r;
    }
}


