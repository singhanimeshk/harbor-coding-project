package com.calendar.scheduler.controller.impl;

import com.calendar.scheduler.controller.SchedulerController;
import com.calendar.scheduler.model.Schedule;
import com.calendar.scheduler.model.ScheduleRequest;
import com.calendar.scheduler.model.SchedulerOverlapRequest;
import com.calendar.scheduler.service.SchedulerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("userSchedules")
public class SchedulerControllerImpl implements SchedulerController {

    private final SchedulerService schedulerService;

    public SchedulerControllerImpl(@Autowired SchedulerService schedulerService) {
        this.schedulerService = schedulerService;
    }

    @Override
    @GetMapping("/{userID}")
    @ResponseBody
    public List<Schedule> getSchedules(@PathVariable String userID) {
        return schedulerService.getSchedule(userID);
    }

    @Override
    @PostMapping("/{userID}")
    @ResponseBody
    public List<Schedule> createSchedules(@PathVariable String userID, @RequestBody List<ScheduleRequest> scheduleRequestList) {
        return schedulerService.setSchedule(userID, scheduleRequestList);
    }

    @Override
    @PostMapping("findFreeSchedule")
    @ResponseBody
    public List<ScheduleRequest> findOverlappingSchedules(@RequestBody SchedulerOverlapRequest schedulerOverlapRequest) {
        return schedulerService.findOverlappingSchedules(schedulerOverlapRequest.getUsers());
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteSchedule(@PathVariable String id) {
        schedulerService.deleteSchedule(id);
    }
}
