package com.songhaozhi.mayday.service.impl;

import com.songhaozhi.mayday.mapper.ry.SysFileInfoMapper;
import com.songhaozhi.mayday.model.ry.SysFileInfo;
import com.songhaozhi.mayday.service.SysFileInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: xuyang
 * @Date: 2020/1/23 18:53
 * @Description:
 */
@Slf4j
@Service
@Transactional(transactionManager = "ryTransactional", rollbackFor = RuntimeException.class)
public class SysFileInfoServiceImpl implements SysFileInfoService {

    private static final String FILE_INFO_CACHE_KEY = "fileInfo";

    @Autowired
    private SysFileInfoMapper sysFileInfoMapper;

    @Override
    public SysFileInfo selectFileInfo(SysFileInfo sysFile) {
        return sysFileInfoMapper.selectFileInfo(sysFile);
    }

    @Override
    public List<SysFileInfo> selectFileList(SysFileInfo sysFile) {
        return sysFileInfoMapper.selectFileList(sysFile);
    }

    @Override
    @CacheEvict(value = FILE_INFO_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void insertFile(SysFileInfo sysFile) {
        sysFileInfoMapper.insertFile(sysFile);
    }

    @Override
    @CacheEvict(value = FILE_INFO_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void updateFile(SysFileInfo sysFile) {
        sysFileInfoMapper.updateFile(sysFile);
    }

    @Override
    @CacheEvict(value = FILE_INFO_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void deleteFile(SysFileInfo sysFile) {
        sysFileInfoMapper.deleteFile(sysFile);
    }
}
