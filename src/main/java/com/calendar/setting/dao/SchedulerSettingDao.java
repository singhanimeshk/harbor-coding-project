package com.calendar.setting.dao;

import com.calendar.setting.model.SchedulerSetting;

public interface SchedulerSettingDao {

    public String getSchedulerSetting(String userID);

    public void setSchedulerSetting(String userID, String schedulerSetting);

    public void deleteSchedulerSetting(String userID);
}
