package com.calendar.setting.controller;

import com.calendar.setting.model.SchedulerSetting;

public interface SchedulerSettingController {

    public SchedulerSetting getSchedulerSetting(String userID);

    public void setSchedulerSetting(String userID, SchedulerSetting schedulerSetting);

    public void deleteSchedulerSetting(String userID);
}
