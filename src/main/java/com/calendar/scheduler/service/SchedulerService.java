package com.calendar.scheduler.service;

import com.calendar.scheduler.model.Schedule;
import com.calendar.scheduler.model.ScheduleDeleteRequest;
import com.calendar.scheduler.model.ScheduleRequest;

import java.text.ParseException;
import java.util.List;

public interface SchedulerService {

    public List<Schedule> getSchedule(String userID);

    public List<Schedule> setSchedule(String userID, List<ScheduleRequest> schedules);

    public List<ScheduleRequest> findOverlappingSchedules(List<String> users);

    public void deleteSchedule(String id);
}
