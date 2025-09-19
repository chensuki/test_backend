package com.test.backend.controller;

import com.test.backend.dto.param.TimesheetCreateParam;
import com.test.backend.dto.result.TimesheetResult;
import com.test.backend.service.TimesheetService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 工时控制器
 *
 * 路径前缀：/api/timesheets
 * 提供：
 *  - GET  /list           查询工时列表（包含项目）
 *  - POST /create         新建工时记录
 *  - DELETE /delete/{id}  删除工时记录
 */
@RestController
@RequestMapping("/api/timesheets")
public class TimesheetController {

    private final TimesheetService timesheetService;

    public TimesheetController(TimesheetService timesheetService) {
        this.timesheetService = timesheetService;
    }

    @GetMapping("/list")
    /**
     * 查询工时列表
     */
    public List<TimesheetResult> list() {
        return timesheetService.list();
    }

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    /**
     * 新建工时记录
     */
    public void create(@Valid @RequestBody TimesheetCreateParam param) {
        timesheetService.create(param);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    /**
     * 删除工时记录
     */
    public void delete(@PathVariable Long id) {
        timesheetService.delete(id);
    }
}


