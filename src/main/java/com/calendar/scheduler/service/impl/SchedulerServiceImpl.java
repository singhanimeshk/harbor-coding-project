package com.calendar.scheduler.service.impl;

import com.calendar.scheduler.dao.SchedulerDao;
import com.calendar.scheduler.model.Schedule;
import com.calendar.scheduler.model.ScheduleRequest;
import com.calendar.setting.model.SchedulerSetting;
import com.calendar.setting.model.WeeklySchedulePair;
import com.calendar.scheduler.service.SchedulerService;
import com.calendar.setting.service.SchedulerSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SchedulerServiceImpl implements SchedulerService {

    private final SchedulerDao schedulerDao;
    private final SchedulerSettingService schedulerSettingService;

    public SchedulerServiceImpl(@Autowired SchedulerDao schedulerDao, @Autowired SchedulerSettingService schedulerSettingService) {
        this.schedulerDao = schedulerDao;
        this.schedulerSettingService = schedulerSettingService;
    }

    @Override
    public List<Schedule> getSchedule(String userID) {
        return schedulerDao.getSchedule(userID);
    }

    @Override
    public List<Schedule> setSchedule(String userID, List<ScheduleRequest> schedules) {
        List<Schedule> scheduleList = new ArrayList<>();
        for (ScheduleRequest scheduleRequest : schedules) {
            scheduleList.add(new Schedule(scheduleRequest));
        }
        schedulerDao.setSchedule(userID, scheduleList);
        return scheduleList;
    }

    @Override
    public List<ScheduleRequest> findOverlappingSchedules(List<String> users) {

        List<Schedule> scheduleList = schedulerDao.getFutureSchedules(users);
        scheduleList.addAll(getWeeklySchedule(users));

        scheduleList.sort(new Comparator<Schedule>() {
            @Override
            public int compare(Schedule o1, Schedule o2) {
                if(o1.getStart().compareTo(o2.getStart()) == 0) {
                    return o1.getEnd().compareTo(o2.getEnd());
                }
                return o1.getStart().compareTo(o2.getStart());
            }
        });

        List<ScheduleRequest> result = new ArrayList<>();

        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, 7);
        c.set(Calendar.HOUR_OF_DAY, 24);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);

        if(scheduleList.isEmpty()) {
            result.add(new ScheduleRequest(new Date(), c.getTime()));
        }
        else {
            if(scheduleList.get(0).getStart().compareTo(new Date()) > 0) {
                result.add(new ScheduleRequest(new Date(), scheduleList.get(0).getStart()));
            }
            for(int i = 0; i < scheduleList.size() - 1; ) {
                if(scheduleList.get(i).getEnd().compareTo(scheduleList.get(i+1).getStart()) < 0) {
                    result.add(new ScheduleRequest(scheduleList.get(i).getEnd(), scheduleList.get(i+1).getStart()));
                    i++;
                }
                else {
                    if(scheduleList.get(i).getEnd().compareTo(scheduleList.get(i+1).getEnd()) < 0) {
                        scheduleList.get(i).setEnd(scheduleList.get(i+1).getEnd());
                    }
                    scheduleList.remove(i+1);
                }
            }
            if(scheduleList.get(scheduleList.size() - 1).getEnd().compareTo(c.getTime()) < 0) {
                result.add(new ScheduleRequest(scheduleList.get(scheduleList.size() - 1).getEnd(), c.getTime()));
            }
        }

        return result;
    }

    private List<Schedule> getWeeklySchedule(List<String> users) {
        List<Schedule> result = new ArrayList<>();
        for (String user : users) {
            SchedulerSetting schedulerSetting = schedulerSettingService.getSchedulerSetting(user);
            if(schedulerSetting == null) {
                continue;
            }
            Map<String, List<WeeklySchedulePair>> weeklyMap = schedulerSetting.getWeeklyBusy();
            Calendar calendar = Calendar.getInstance();

            for (int i = 0; i <= 7; i++) {
                List<WeeklySchedulePair> pairList = weeklyMap.get(String.valueOf(calendar.get(Calendar.DAY_OF_WEEK)));
                if(pairList != null && !pairList.isEmpty()) {
                    for (WeeklySchedulePair pair : pairList) {
                        Calendar startCal = Calendar.getInstance();
                        int year = calendar.get(Calendar.YEAR);
                        int month = calendar.get(Calendar.MONTH);
                        int date = calendar.get(Calendar.DAY_OF_MONTH);
                        int hour = Integer.parseInt(pair.getStart().split(":")[0]);
                        int min = Integer.parseInt(pair.getStart().split(":")[1]);
                        startCal.set(year, month, date, hour, min, 0);

                        Calendar endCal = Calendar.getInstance();
                        int year1 = calendar.get(Calendar.YEAR);
                        int month1 = calendar.get(Calendar.MONTH);
                        int date1 = calendar.get(Calendar.DAY_OF_MONTH);
                        int hour1 = Integer.parseInt(pair.getEnd().split(":")[0]);
                        int min1 = Integer.parseInt(pair.getEnd().split(":")[1]);
                        endCal.set(year1, month1, date1, hour1, min1, 0);

                        if(startCal.getTime().compareTo(new Date()) >= 0 || endCal.getTime().compareTo(new Date()) >= 0) {
                            result.add(new Schedule(null, startCal.getTime(), endCal.getTime()));
                        }
                    }
                }
                calendar.add(Calendar.DATE, 1);
            }
        }

        return result;
    }

    @Override
    public void deleteSchedule(String id) {
        schedulerDao.deleteSchedule(id);
    }
}
