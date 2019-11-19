package com.songhaozhi.mayday.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.redis.RedisService;
import com.songhaozhi.mayday.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.songhaozhi.mayday.model.dto.MaydayConst;

/**
 * @author : 宋浩志
 * @createDate : 2018年9月5日
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {

	@Autowired
	private RedisService redisService;

	@Autowired
	private UserService userService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//redis托管
		Integer userID = (Integer) redisService.get(request.getSession().getId());
		if(userID != null){

			User user = (User) request.getSession().getAttribute(MaydayConst.USER_SESSION_KEY);
			// 如果user不为空则放行
			if (null == user) {
				User userInfo = userService.getUserInfo(String.valueOf(userID));
				request.getSession().setAttribute(MaydayConst.USER_SESSION_KEY, userInfo);
			}

			//共享session：其他平台根据userID获取session活性
			redisService.set(String.valueOf(userID), request.getSession().getId(), MaydayConst.SESSION_TIME_OUT);

			return true;
		}

		// 否则拦截并跳转到登录
		response.sendRedirect("/admin/login");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
