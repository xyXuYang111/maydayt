package com.songhaozhi.mayday.service;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.domain.Schedule;

import java.util.List;

public interface ScheduleService {

    Schedule getScheduleInfo(Schedule schedule);

    List<Schedule> getScheduleList(Schedule schedule);

    PageInfo<Schedule> getScheduleList(int page, int limit, Schedule schedule);

    String getScheduleCount(Schedule schedule);

    void deleteSchedule(Schedule schedule);

    void insertSchedule(Schedule schedule);

    void updateSchedule(Schedule schedule);
}