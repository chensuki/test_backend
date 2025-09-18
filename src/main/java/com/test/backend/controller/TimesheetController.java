package com.test.backend.controller;

import com.test.backend.dto.param.TimesheetCreateParam;
import com.test.backend.dto.result.TimesheetResult;
import com.test.backend.service.TimesheetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timesheets")
public class TimesheetController {

    private final TimesheetService timesheetService;

    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @GetMapping
    public List<TimesheetResult> list() {
        return timesheetService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@Valid @RequestBody TimesheetCreateParam param) {
        timesheetService.create(param);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        timesheetService.delete(id);
    }
}


