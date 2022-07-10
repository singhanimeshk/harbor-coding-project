package com.calendar.setting.service.impl;

import com.calendar.setting.dao.SchedulerSettingDao;
import com.calendar.setting.model.SchedulerSetting;
import com.calendar.setting.service.SchedulerSettingService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulerSettingServiceImpl implements SchedulerSettingService {

    private final SchedulerSettingDao schedulerSettingDao;

    public SchedulerSettingServiceImpl(@Autowired SchedulerSettingDao schedulerSettingDao) {
        this.schedulerSettingDao = schedulerSettingDao;
    }

    @Override
    public SchedulerSetting getSchedulerSetting(String userID) {
        String schedulerStr = schedulerSettingDao.getSchedulerSetting(userID);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(schedulerStr, SchedulerSetting.class);
        } catch (JsonProcessingException|IllegalArgumentException e) {
            return null;
        }
    }

    @Override
    public void setSchedulerSetting(String userID, SchedulerSetting schedulerSetting) {
        ObjectMapper objectMapper = new ObjectMapper();
        String schedulerStr = null;
        try {
            schedulerStr = objectMapper.writeValueAsString(schedulerSetting);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        schedulerSettingDao.setSchedulerSetting(userID, schedulerStr);
    }

    @Override
    public void deleteSchedulerSetting(String userID) {
        schedulerSettingDao.deleteSchedulerSetting(userID);
    }
}
