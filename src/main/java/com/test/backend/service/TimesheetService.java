package com.test.backend.service;

import com.test.backend.dto.param.TimesheetCreateParam;
import com.test.backend.dto.result.TimesheetResult;

import java.util.List;

public interface TimesheetService {
    List<TimesheetResult> list();
    void create(TimesheetCreateParam param);
    void delete(Long id);
}


