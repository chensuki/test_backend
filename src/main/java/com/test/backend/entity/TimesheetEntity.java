package com.test.backend.entity;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class TimesheetEntity {
    private Long id;
    private Long projectId;
    private LocalDate workDate;
    private double hours;
    private String notes;
}


