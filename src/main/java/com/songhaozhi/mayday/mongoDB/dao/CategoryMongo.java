package com.songhaozhi.mayday.mongoDB.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author songhaozhi
 *
 */
public interface CategoryMongo {

	List<Integer> selectByarticleId(Integer id);

	void delete(List<Integer> cateList, Integer articleId);

}