package com.calendar.scheduler.controller;

import com.calendar.scheduler.model.Schedule;
import com.calendar.scheduler.model.ScheduleRequest;
import com.calendar.scheduler.model.SchedulerOverlapRequest;

import java.util.List;

public interface SchedulerController {

    public List<Schedule> getSchedules(String userID);

    public List<Schedule> createSchedules(String userID, List<ScheduleRequest> scheduleRequestList);

    public List<ScheduleRequest> findOverlappingSchedules(SchedulerOverlapRequest schedulerOverlapRequest);

    public void deleteSchedule(String id);

}
