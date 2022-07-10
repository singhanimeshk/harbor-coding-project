package com.calendar.scheduler.dao.impl;

import com.calendar.scheduler.dao.SchedulerDao;
import com.calendar.scheduler.model.Schedule;
import com.calendar.scheduler.model.ScheduleData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SchedulerDaoImpl implements SchedulerDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public SchedulerDaoImpl(@Autowired NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Schedule> getSchedule(String userID) {
        String SQL = "SELECT ID, START, END FROM SCHEDULE WHERE USERID = :userID ORDER BY START";
        List<ScheduleData> scheduleDataList = jdbcTemplate.query(SQL, new MapSqlParameterSource("userID", userID), new BeanPropertyRowMapper<>(ScheduleData.class));
        return getSchedules(scheduleDataList);
    }

    private List<Schedule> getSchedules(List<ScheduleData> scheduleDataList) {
        List<Schedule> scheduleList = new ArrayList<>();
        for (ScheduleData scheduleData : scheduleDataList) {
            scheduleList.add(new Schedule(scheduleData));
        }
        return scheduleList;
    }

    @Override
    public List<Schedule> getFutureSchedules(List<String> userList) {
        String SQL = "SELECT ID, START, END FROM SCHEDULE WHERE USERID IN (:userList) AND ((START >= current_timestamp() AND DATE(START) <= current_date() + 7) OR (END >= current_timestamp() AND DATE(END) <= current_date() + 7)) ORDER BY START, END";
        List<ScheduleData> scheduleDataList = jdbcTemplate.query(SQL, new MapSqlParameterSource("userList", userList), new BeanPropertyRowMapper<>(ScheduleData.class));
        return getSchedules(scheduleDataList);
    }

    @Override
    public void setSchedule(String userID, List<Schedule> schedules) {
        List<ScheduleData> scheduleDataList = new ArrayList<>();
        for(Schedule schedule : schedules) {
            scheduleDataList.add(new ScheduleData(userID, schedule));
        }
        String SQL = "INSERT INTO SCHEDULE (ID, USERID, START, END) VALUES (:id, :userID, :start, :end)";
        SqlParameterSource[] batch = SqlParameterSourceUtils.createBatch(scheduleDataList.toArray());
        jdbcTemplate.batchUpdate(SQL, batch);
    }

    @Override
    public void deleteSchedule(String id) {
        String SQL = "DELETE FROM SCHEDULE WHERE id = :id";
        jdbcTemplate.update(SQL, new MapSqlParameterSource("id", id));
    }
}
