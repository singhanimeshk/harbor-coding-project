package com.calendar.scheduler.dao;

import com.calendar.scheduler.model.Schedule;
import com.calendar.scheduler.model.ScheduleDeleteRequest;

import java.util.List;
import java.util.Map;

public interface SchedulerDao {

    public List<Schedule> getSchedule(String userID);

    public List<Schedule> getFutureSchedules(List<String> userList);

    public void setSchedule(String userID, List<Schedule> schedules);

    public void deleteSchedule(String id);
}
