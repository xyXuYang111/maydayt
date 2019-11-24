package com.songhaozhi.mayday.mongoDB.dao;

import com.songhaozhi.mayday.model.domain.Options;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author : 宋浩志
 * @createDate : 2018年10月14日
 * 
 */
public interface OptionsMongo {
	/**
	 * 保存
	 * 
	 * @param map
	 */
	void saveMap(Map<String, Object> map);

	/**
	 * 所有设置选项
	 * 
	 * @return map
	 */
	List<Options> selectMap();

}
