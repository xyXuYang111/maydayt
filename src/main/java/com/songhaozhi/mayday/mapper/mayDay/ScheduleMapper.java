package com.songhaozhi.mayday.mapper.mayDay;

import com.songhaozhi.mayday.annotation.MyBatisDao;
import com.songhaozhi.mayday.model.domain.Schedule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@MyBatisDao
public interface ScheduleMapper {

    Schedule getScheduleInfo(Schedule schedule);

    List<Schedule> getScheduleList(Schedule schedule);

    String getScheduleCount(Schedule schedule);

    void deleteSchedule(Schedule schedule);

    void insertSchedule(Schedule schedule);

    void updateSchedule(Schedule schedule);
}