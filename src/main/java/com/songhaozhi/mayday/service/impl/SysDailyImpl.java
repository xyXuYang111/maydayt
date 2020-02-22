package com.songhaozhi.mayday.service.impl;

import com.songhaozhi.mayday.mapper.ry.SysDailyMapper;
import com.songhaozhi.mayday.model.ry.SysDaily;
import com.songhaozhi.mayday.service.SysDailyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2020/1/22 22:57
 * @Description:
 */
@Slf4j
@Service
@Transactional(transactionManager = "ryTransactional", rollbackFor = RuntimeException.class)
public class SysDailyImpl implements SysDailyService {

    private static final String DAILY_CACHE_KEY = "daily";

    @Autowired
    private SysDailyMapper sysDailyMapper;

    @Override
    public SysDaily selectDaily(SysDaily sysDaily) {
        return sysDailyMapper.selectDaily(sysDaily);
    }

    @Override
    public List<SysDaily> selectDailyList(SysDaily sysDaily) {
        return sysDailyMapper.selectDailyList(sysDaily);
    }

    @Override
    public SysDaily checkDailyKeyUnique(String sysDailyKey) {
        return sysDailyMapper.checkDailyKeyUnique(sysDailyKey);
    }

    @Override
    @CacheEvict(value = DAILY_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void insertDaily(SysDaily sysDaily) {
        sysDailyMapper.insertDaily(sysDaily);
    }

    @Override
    @CacheEvict(value = DAILY_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void updateDaily(SysDaily sysDaily) {
        sysDailyMapper.updateDaily(sysDaily);
    }

    @Override
    @CacheEvict(value = DAILY_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void deleteDailyByIds(SysDaily sysDaily) {
        sysDailyMapper.deleteDailyByIds(sysDaily);
    }
}
