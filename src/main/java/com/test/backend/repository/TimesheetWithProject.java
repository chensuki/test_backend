package com.test.backend.repository;

import com.test.backend.entity.ProjectEntity;
import com.test.backend.entity.TimesheetEntity;

public class TimesheetWithProject {
    private final TimesheetEntity timesheet;
    private final ProjectEntity project;

    public TimesheetWithProject(TimesheetEntity timesheet, ProjectEntity project) {
        this.timesheet = timesheet;
        this.project = project;
    }

    public TimesheetEntity getTimesheet() { return timesheet; }
    public ProjectEntity getProject() { return project; }
}


