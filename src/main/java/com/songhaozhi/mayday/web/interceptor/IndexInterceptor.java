package com.songhaozhi.mayday.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.songhaozhi.mayday.model.domain.Url;
import com.songhaozhi.mayday.model.domain.User;
import com.songhaozhi.mayday.redis.RedisService;
import com.songhaozhi.mayday.util.DateUtil;
import com.songhaozhi.mayday.util.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.util.Commons;

/**
 * 前台拦截器
 * 
 * @author : 宋浩志
 * @createDate : 2018年12月6日
 */
@Component
public class IndexInterceptor implements HandlerInterceptor {

	@Autowired
	private Commons commons;

	@Autowired
	private RedisService redisService;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		//获取ip地址
		String ip = IpUtil.getIpAddress(request);
		String uri = request.getRequestURI();//返回请求行中的资源名称
		String url = request.getRequestURL().toString();//获得客户端发送请求的完整url
		String returnIp = request.getRemoteAddr();//返回发出请求的IP地址
		String params = request.getQueryString();//返回请求行中的参数部分
		String host=request.getRemoteHost();//返回发出请求的客户机的主机名
		int port =request.getRemotePort();//返回发出请求的客户机的端口号。

		Url urlInfo = new Url();
		urlInfo.setIp(ip);
		urlInfo.setUri(uri);
		urlInfo.setUrl(url);
		urlInfo.setReturnIp(returnIp);
		urlInfo.setParams(params);
		urlInfo.setHost(host);
		urlInfo.setPort(port);
		urlInfo.setOperateTime(DateUtil.getNowTime());
		redisService.put("REQUEST", String.valueOf(System.currentTimeMillis()), urlInfo);

		//更新redis中的session记录
		User user = (User) request.getSession().getAttribute(MaydayConst.USER_SESSION_KEY);
		if(user != null){
			redisService.set(String.valueOf(user.getUserId()), request.getSession().getId(), MaydayConst.SESSION_TIME_OUT);

			redisService.set(request.getSession().getId(), String.valueOf(user.getUserId()), MaydayConst.SESSION_TIME_OUT);
		}

		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		String requestType = request.getHeader("X-Requested-With");
		//非ajax请求
		if(!"XMLHttpRequest".equals(requestType)){
			// 工具类
			request.setAttribute("commons", commons);
			// 设置项
			request.setAttribute("options", MaydayConst.OPTIONS);
			// 菜单
			request.setAttribute("menus", MaydayConst.MENUS);
		}
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}
}
