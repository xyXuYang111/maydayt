package com.songhaozhi.mayday.mapper.mayDay.custom;

import com.songhaozhi.mayday.annotation.MyBatisDao;
import com.songhaozhi.mayday.model.domain.Schedule;

import java.util.List;

/**
 * @author : 宋浩志
 * @createDate : 2018年11月1日
 */
@MyBatisDao
public interface ScheduleMapperCustom {

	public Schedule getScheduleInfo(Schedule schedule) throws Exception;

	public List<Schedule> getScheduleList(Schedule schedule) throws Exception;

	public Long count(Schedule schedule) throws Exception;

	public void insertSchedule(Schedule schedule) throws Exception;

	public void updateSchedule(Schedule schedule) throws Exception;

	public void deleteSchedule(Schedule schedule) throws Exception;
}
