package com.songhaozhi.mayday.mapper;

import com.songhaozhi.mayday.model.domain.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {

    Schedule getScheduleInfo(Schedule schedule);

    List<Schedule> getScheduleList(Schedule schedule);

    String getScheduleCount(Schedule schedule);

    void deleteSchedule(Schedule schedule);

    void insertSchedule(Schedule schedule);

    void updateSchedule(Schedule schedule);
}