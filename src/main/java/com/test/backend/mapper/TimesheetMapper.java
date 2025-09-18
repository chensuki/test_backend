package com.test.backend.mapper;

import com.test.backend.dto.param.TimesheetCreateParam;
import com.test.backend.dto.result.ProjectResult;
import com.test.backend.dto.result.TimesheetResult;
import com.test.backend.entity.ProjectEntity;
import com.test.backend.entity.TimesheetEntity;

public class TimesheetMapper {
    public static TimesheetEntity toEntity(TimesheetCreateParam param) {
        TimesheetEntity e = new TimesheetEntity();
        e.setProjectId(param.getProjectId());
        e.setWorkDate(param.getWorkDate());
        e.setHours(param.getHours());
        e.setNotes(param.getNotes());
        return e;
    }

    public static TimesheetResult toResult(TimesheetEntity e, ProjectEntity p) {
        TimesheetResult r = new TimesheetResult();
        r.setId(e.getId());
        r.setWorkDate(e.getWorkDate() != null ? e.getWorkDate().toString() : null);
        r.setHours(e.getHours());
        r.setNotes(e.getNotes());
        ProjectResult pr = ProjectMapper.toResult(p);
        r.setProject(pr);
        return r;
    }
}


