package com.songhaozhi.mayday.service.impl;

import com.songhaozhi.mayday.mapper.ry.SysBlogMapper;
import com.songhaozhi.mayday.model.ry.SysBlog;
import com.songhaozhi.mayday.service.SysBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户 业务层处理
 * 
 * @author ruoyi
 */
@Service
@Transactional(transactionManager = "ryTransactional", rollbackFor = RuntimeException.class)
public class SysBlogServiceImpl implements SysBlogService {

    private static final String BLOG_CACHE_KEY = "blog";

    @Autowired
    private SysBlogMapper sysBlogMapper;

    @Override
    public SysBlog selectBlog(SysBlog sysBlog) {
        return sysBlogMapper.selectBlog(sysBlog);
    }

    @Override
    public List<SysBlog> selectBlogList(SysBlog sysBlog) {
        return sysBlogMapper.selectBlogList(sysBlog);
    }

    @Override
    public SysBlog checkBlogKeyUnique(String sysBlogKey) {
        return sysBlogMapper.checkBlogKeyUnique(sysBlogKey);
    }

    @Override
    @CacheEvict(value = BLOG_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void insertBlog(SysBlog sysBlog) {
        sysBlogMapper.insertBlog(sysBlog);
    }

    @Override
    @CacheEvict(value = BLOG_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void updateBlog(SysBlog sysBlog) {
        sysBlogMapper.updateBlog(sysBlog);
    }

    @Override
    @CacheEvict(value = BLOG_CACHE_KEY, allEntries = true, beforeInvocation = true)
    public void deleteBlogByIds(SysBlog sysBlog) {
        sysBlogMapper.deleteBlogByIds(sysBlog);
    }
}
