package com.test.backend.dto.param;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class TimesheetCreateParam {
    @NotNull(message = "projectId is required")
    private Long projectId;
    @NotNull(message = "workDate is required")
    private LocalDate workDate;
    @Min(value = 1, message = "hours must be > 0")
    private double hours;
    private String notes;

    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public LocalDate getWorkDate() { return workDate; }
    public void setWorkDate(LocalDate workDate) { this.workDate = workDate; }
    public double getHours() { return hours; }
    public void setHours(double hours) { this.hours = hours; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}


