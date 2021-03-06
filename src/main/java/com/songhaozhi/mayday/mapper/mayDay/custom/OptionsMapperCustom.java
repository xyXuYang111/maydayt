package com.songhaozhi.mayday.mapper.mayDay.custom;

import java.util.List;
import java.util.Map;

import com.songhaozhi.mayday.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

import com.songhaozhi.mayday.model.domain.Options;

/**
 * @author : 宋浩志
 * @createDate : 2018年10月14日
 * 
 */
@MyBatisDao
public interface OptionsMapperCustom {
	/**
	 * 保存
	 * 
	 * @param map
	 */
	void saveMap(@Param("map") Map<String, Object> map);

	/**
	 * 所有设置选项
	 * 
	 * @return map
	 */
	List<Options> selectMap();

}
