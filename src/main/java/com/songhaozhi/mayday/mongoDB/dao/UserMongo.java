package com.songhaozhi.mayday.mongoDB.dao;

import com.songhaozhi.mayday.model.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 * @author songhaozhi
 *
 */
public interface UserMongo {
	/**
	 * 根据用户名和密码查询用户
	 * 
	 * @param name
	 *            用户名
	 * @param pwd
	 *            用户密码
	 * @return 根据用户名和密码获取用户信息
	 */
	User getByNameAndPwd(String name, String pwd);

	/**
	 * 根据用户名和密码查询用户
	 *
	 * @param userId
	 *            用户名
	 * @return 根据用户名和密码获取用户信息
	 */
	User getUserInfo(String userId);

	/**
	 * 修改用户资料
	 * 
	 * @param user
	 */
	void updateDatum(User user);

	/**
	 * 用户资料查询
	 * 
	 * @return
	 */
	List<User> findUser();

	/**
	 * 查询原密码是否存在
	 * 
	 * @param userId
	 *            用户id
	 * @param formerlyPwd
	 *            原密码
	 * @return
	 */
	User findByUserIdAndUserPwd(Integer userId, String formerlyPwd);

}