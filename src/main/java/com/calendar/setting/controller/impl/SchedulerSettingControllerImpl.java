package com.calendar.setting.controller.impl;

import com.calendar.setting.controller.SchedulerSettingController;
import com.calendar.setting.model.SchedulerSetting;
import com.calendar.setting.service.SchedulerSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/schedulerSetting")
public class SchedulerSettingControllerImpl implements SchedulerSettingController {

    private final SchedulerSettingService schedulerSettingService;

    public SchedulerSettingControllerImpl(@Autowired SchedulerSettingService schedulerSettingService) {
        this.schedulerSettingService = schedulerSettingService;
    }

    @Override
    @GetMapping("/{userID}")
    @ResponseBody
    public SchedulerSetting getSchedulerSetting(@PathVariable String userID) {
        return schedulerSettingService.getSchedulerSetting(userID);
    }

    @Override
    @PostMapping("/{userID}")
    @ResponseBody
    public void setSchedulerSetting(@PathVariable String userID, @RequestBody SchedulerSetting schedulerSetting) {
        schedulerSettingService.setSchedulerSetting(userID, schedulerSetting);
    }

    @Override
    @DeleteMapping("/{userID}")
    @ResponseBody
    public void deleteSchedulerSetting(@PathVariable String userID) {
        schedulerSettingService.deleteSchedulerSetting(userID);
    }
}
