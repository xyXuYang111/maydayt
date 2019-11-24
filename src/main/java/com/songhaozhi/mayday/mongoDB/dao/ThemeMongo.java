package com.songhaozhi.mayday.mongoDB.dao;

import org.apache.ibatis.annotations.Param;

/**
* @author 宋浩志
* @createDate 创建时间：2019年1月9日 下午10:09:57
* 
*/
public interface ThemeMongo {

	void updateStatus(int status, int id);

}
