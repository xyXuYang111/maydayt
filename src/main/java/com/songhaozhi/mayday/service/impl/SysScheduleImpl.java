package com.songhaozhi.mayday.service.impl;

import com.songhaozhi.mayday.mapper.ry.SysScheduleMapper;
import com.songhaozhi.mayday.model.ry.SysSchedule;
import com.songhaozhi.mayday.service.SysScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2020/1/22 22:57
 * @Description:
 */
@Service
public class SysScheduleImpl implements SysScheduleService {

    private static final String schedule_CACHE_KEY = "schedule";

    @Autowired
    private SysScheduleMapper sysScheduleMapper;

    @Override
    public SysSchedule selectSchedule(SysSchedule sysSchedule) {
        return sysScheduleMapper.selectSchedule(sysSchedule);
    }

    @Override
    public List<SysSchedule> selectScheduleList(SysSchedule sysSchedule) {
        return sysScheduleMapper.selectScheduleList(sysSchedule);
    }

    @Override
    public SysSchedule checkScheduleKeyUnique(String sysScheduleKey) {
        return sysScheduleMapper.checkScheduleKeyUnique(sysScheduleKey);
    }

    @Override
    @CacheEvict(value = schedule_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void insertSchedule(SysSchedule sysSchedule) {
        sysScheduleMapper.insertSchedule(sysSchedule);
    }

    @Override
    @CacheEvict(value = schedule_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void updateSchedule(SysSchedule sysSchedule) {
        sysScheduleMapper.updateSchedule(sysSchedule);
    }

    @Override
    @CacheEvict(value = schedule_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void deleteScheduleByIds(SysSchedule sysSchedule) {
        sysScheduleMapper.deleteScheduleByIds(sysSchedule);
    }
}
