package com.test.backend.entity;

import java.time.LocalDate;

public class TimesheetEntity {
    private Long id;
    private Long projectId;
    private LocalDate workDate;
    private double hours;
    private String notes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getProjectId() { return projectId; }
    public void setProjectId(Long projectId) { this.projectId = projectId; }
    public LocalDate getWorkDate() { return workDate; }
    public void setWorkDate(LocalDate workDate) { this.workDate = workDate; }
    public double getHours() { return hours; }
    public void setHours(double hours) { this.hours = hours; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}


