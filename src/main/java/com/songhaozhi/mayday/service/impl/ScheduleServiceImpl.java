package com.songhaozhi.mayday.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.*;
import com.songhaozhi.mayday.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author : 宋浩志
 * @createDate : 2018年10月15日
 * 
 */
@Service
@Transactional(transactionManager = "mayDayTransactional", rollbackFor = RuntimeException.class)
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleService scheduleService;

	@Override
	public Schedule getScheduleInfo(Schedule schedule) {
		return scheduleService.getScheduleInfo(schedule);
	}

	@Override
	public List<Schedule> getScheduleList(Schedule schedule) {
		return scheduleService.getScheduleList(schedule);
	}

	@Override
	public PageInfo<Schedule> getScheduleList(int page, int limit, Schedule schedule) {
		PageHelper.startPage(page, limit);
		List<Schedule> lists = scheduleService.getScheduleList(schedule);
		return new PageInfo<>(lists);
	}

	@Override
	public String getScheduleCount(Schedule schedule) {
		return scheduleService.getScheduleCount(schedule);
	}

	@Override
	public void deleteSchedule(Schedule schedule) {
		scheduleService.deleteSchedule(schedule);
	}

	@Override
	public void insertSchedule(Schedule schedule) {
		scheduleService.insertSchedule(schedule);
	}

	@Override
	public void updateSchedule(Schedule schedule) {
		scheduleService.updateSchedule(schedule);
	}
}
