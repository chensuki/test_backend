package com.test.backend.dto.result;

public class TimesheetResult {
    private Long id;
    private ProjectResult project;
    private String workDate;
    private double hours;
    private String notes;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public ProjectResult getProject() { return project; }
    public void setProject(ProjectResult project) { this.project = project; }
    public String getWorkDate() { return workDate; }
    public void setWorkDate(String workDate) { this.workDate = workDate; }
    public double getHours() { return hours; }
    public void setHours(double hours) { this.hours = hours; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}


