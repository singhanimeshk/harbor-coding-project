package com.calendar.setting.model;

import java.util.List;
import java.util.Map;

public class SchedulerSetting {

    private Map<String, List<WeeklySchedulePair>> weeklyBusy;

    public Map<String, List<WeeklySchedulePair>> getWeeklyBusy() {
        return weeklyBusy;
    }

    public void setWeeklyBusy(Map<String, List<WeeklySchedulePair>> weeklyBusy) {
        this.weeklyBusy = weeklyBusy;
    }
}
