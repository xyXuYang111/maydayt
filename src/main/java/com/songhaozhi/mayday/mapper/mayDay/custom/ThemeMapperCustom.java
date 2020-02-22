package com.songhaozhi.mayday.mapper.mayDay.custom;

import com.songhaozhi.mayday.annotation.MyBatisDao;
import org.apache.ibatis.annotations.Param;

/**
* @author 宋浩志
* @createDate 创建时间：2019年1月9日 下午10:09:57
* 
*/
@MyBatisDao
public interface ThemeMapperCustom {

	void updateStatus(@Param(value="status")int status,@Param(value="id") int id);

}
