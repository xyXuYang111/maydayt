package com.songhaozhi.mayday.service;

import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.Schedule;
import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.model.dto.ArchiveBo;

import java.util.List;

/**
 * @author : 宋浩志
 * @createDate : 2018年10月15日
 */
public interface ScheduleService {

	public Schedule getScheduleInfo(Schedule schedule) throws Exception;

	public List<Schedule> getScheduleList(Schedule schedule) throws Exception;

	public Long count(Schedule schedule) throws Exception;

	public void insertSchedule(Schedule schedule) throws Exception;

	public void updateSchedule(Schedule schedule) throws Exception;

	public void deleteSchedule(Schedule schedule) throws Exception;
}
