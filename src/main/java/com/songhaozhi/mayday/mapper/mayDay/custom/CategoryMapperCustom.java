package com.songhaozhi.mayday.mapper.mayDay.custom;

import java.util.List;

import com.songhaozhi.mayday.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * @author songhaozhi
 *
 */
@MyBatisDao
public interface CategoryMapperCustom {

	List<Integer> selectByarticleId(Integer id);

	void delete(@Param(value = "list") List<Integer> cateList, @Param(value = "articleId") Integer articleId);

}