package com.songhaozhi.mayday.service.impl;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.mapper.custom.ArticleMapperCustom;
import com.songhaozhi.mayday.mapper.custom.CategoryMapperCustom;
import com.songhaozhi.mayday.mapper.custom.TagMapperCustom;
import com.songhaozhi.mayday.mapper.generator.ArticleCategoryMapper;
import com.songhaozhi.mayday.mapper.generator.ArticleMapper;
import com.songhaozhi.mayday.mapper.generator.ArticleTagMapper;
import com.songhaozhi.mayday.model.domain.*;
import com.songhaozhi.mayday.model.dto.ArchiveBo;
import com.songhaozhi.mayday.model.enums.ArticleStatus;
import com.songhaozhi.mayday.model.enums.PostType;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author : 宋浩志
 * @createDate : 2018年10月15日
 * 
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ScheduleServiceImpl implements ScheduleService {

	@Autowired
	private ScheduleService scheduleService;

	@Override
	public Schedule getScheduleInfo(Schedule schedule) throws Exception {
		return null;
	}

	@Override
	public List<Schedule> getScheduleList(Schedule schedule) throws Exception {
		return null;
	}

	@Override
	public Long count(Schedule schedule) throws Exception {
		return null;
	}

	@Override
	public void insertSchedule(Schedule schedule) throws Exception {

	}

	@Override
	public void updateSchedule(Schedule schedule) throws Exception {

	}

	@Override
	public void deleteSchedule(Schedule schedule) throws Exception {

	}
}
