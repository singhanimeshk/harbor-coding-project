package com.calendar.setting.dao.impl;

import com.calendar.setting.dao.SchedulerSettingDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class SchedulerSettingDaoImpl implements SchedulerSettingDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public SchedulerSettingDaoImpl(@Autowired NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String getSchedulerSetting(String userID) {
        String SQL = "SELECT SETTING FROM SCHEDULER_SETTING WHERE USERID = :userID";
        try {
            return jdbcTemplate.queryForObject(SQL, new MapSqlParameterSource("userID", userID), String.class);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public void setSchedulerSetting(String userID, String schedulerSetting) {
        String SQL = "INSERT INTO SCHEDULER_SETTING(USERID, SETTING) VALUES(:userID, :schedulerSetting) ON DUPLICATE KEY UPDATE SETTING = :schedulerSetting";
        jdbcTemplate.update(SQL, new MapSqlParameterSource("userID", userID).addValue("schedulerSetting", schedulerSetting));
    }

    @Override
    public void deleteSchedulerSetting(String userID) {
        String SQL = "DELETE FROM SCHEDULER_SETTING WHERE USERID = :userID";
        jdbcTemplate.update(SQL, new MapSqlParameterSource("userID", userID));
    }
}
