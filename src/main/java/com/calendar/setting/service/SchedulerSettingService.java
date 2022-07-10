package com.calendar.setting.service;

import com.calendar.setting.model.SchedulerSetting;

public interface SchedulerSettingService {

    public SchedulerSetting getSchedulerSetting(String userID);

    public void setSchedulerSetting(String userID, SchedulerSetting schedulerSetting);

    public void deleteSchedulerSetting(String userID);
}
