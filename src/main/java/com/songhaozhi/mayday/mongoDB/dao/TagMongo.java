package com.songhaozhi.mayday.mongoDB.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月27日 下午4:16:50
 */
public interface TagMongo {

	List<Integer> selectByarticleId(Integer id);

	void delete(List<Integer> tagList, Integer articleId);

}
