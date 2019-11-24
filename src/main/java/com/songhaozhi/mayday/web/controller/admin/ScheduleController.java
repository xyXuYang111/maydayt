package com.songhaozhi.mayday.web.controller.admin;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import cn.hutool.http.HtmlUtil;
import com.github.pagehelper.PageInfo;
import com.songhaozhi.mayday.model.domain.*;
import com.songhaozhi.mayday.model.dto.JsonResult;
import com.songhaozhi.mayday.model.dto.LogConstant;
import com.songhaozhi.mayday.model.dto.MaydayConst;
import com.songhaozhi.mayday.model.enums.ArticleStatus;
import com.songhaozhi.mayday.model.enums.MaydayEnums;
import com.songhaozhi.mayday.model.enums.PostType;
import com.songhaozhi.mayday.service.ArticleService;
import com.songhaozhi.mayday.service.CategoryService;
import com.songhaozhi.mayday.service.TagService;
import com.songhaozhi.mayday.util.MaydayUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author : 宋浩志
 * @createDate : 2018年10月15日
 * 
 */
@Controller
@RequestMapping("/admin/schedule")
public class ScheduleController extends BaseController {
	@Autowired
	private ArticleService articleService;

	/**
	 * 显示所有文章
	 * 
	 * @param model
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping
	public String article(Model model, @RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "10") int limit,
			@RequestParam(value = "status", defaultValue = "0") int status) {
		ArticleCustom articleCustom = new ArticleCustom();
		articleCustom.setArticleStatus(status);
		articleCustom.setArticlePost(PostType.POST_TYPE_POST.getValue());
		PageInfo<ArticleCustom> pageInfo = articleService.findPageArticle(page, limit, articleCustom);
		model.addAttribute("info", pageInfo);
		// 已发布条数
		model.addAttribute("published",
				articleService.countByStatus(ArticleStatus.PUBLISH.getStatus(), PostType.POST_TYPE_POST.getValue()));
		// 草稿条数
		model.addAttribute("draft",
				articleService.countByStatus(ArticleStatus.DRAFT.getStatus(), PostType.POST_TYPE_POST.getValue()));
		// 回收站条数
		model.addAttribute("recycle",
				articleService.countByStatus(ArticleStatus.RECYCLE.getStatus(), PostType.POST_TYPE_POST.getValue()));
		model.addAttribute("status", status);
		return "admin/admin_schedule";
	}

	/**
	 * 过滤空格
	 * 
	 * @param articleTitle
	 * @return
	 */
	@PostMapping(value = "/filter")
	@ResponseBody
	public JsonResult filter(String articleTitle) {
		articleTitle = articleTitle.replaceAll(" ", "-");
		return new JsonResult(true, articleTitle);
	}

	/**
	 * 保存文章
	 * 
	 * @param schedule
	 *            文章
	 * @param tags
	 *            标签
	 * @param categorys
	 *            分类
	 * @return
	 */
	@PostMapping(value = "/new/save")
	@ResponseBody
	public JsonResult save(Schedule schedule, Long[] tags, Long[] categorys, HttpServletRequest request) {
		try {
			if (StrUtil.isEmpty(schedule.getScheduleTitle())) {
				return new JsonResult(false, "标题不能为空");
			}
			if (schedule.getScheduleID() == null) {
				// 判断文章链接是否重复
				if (!StrUtil.isEmpty(schedule.getScheduleUrl())) {
					if(schedule.getScheduleUrl().length()>50) {
						return new JsonResult(false, "路径不能大于50");
					}
					// 查询url是否重复
					int repeat = articleService.findRepeatByUrl(schedule.getScheduleUrl());
					if (repeat != 0) {
						return new JsonResult(false, "路径已存在");
					}
				}
				User user = (User) request.getSession().getAttribute(MaydayConst.USER_SESSION_KEY);
				schedule.setUseID(user.getUserId());
				schedule.setCreateDate(DateUtil.date());
				schedule.setUpdateDate(DateUtil.date());
				// 如果自定义链接为空则按时间戳生成链接
				if (StrUtil.isEmpty(schedule.getScheduleUrl())) {
					schedule.setScheduleUrl(String.valueOf(System.currentTimeMillis() / 1000));
				}
				// 如果没有选择略缩图则随机一张图
				if (StrUtil.isEmpty(schedule.getSchedulePhoto())) {
					schedule.setSchedulePhoto("/static/img/rand/" + RandomUtil.randomInt(1, 19) + ".jpg");
				}
				// 判断摘要是否为空
				if (StrUtil.isEmpty(schedule.getScheduleMessage())) {
					// 如果摘要为空则取前五十字为摘要
					int post_summary = 50;
					if (StrUtil.isNotEmpty(MaydayConst.OPTIONS.get("post_summary"))) {
						post_summary = Integer.parseInt(MaydayConst.OPTIONS.get("post_summary"));
					}
					// 清理html标签和空白字符
					String summaryText = StrUtil.cleanBlank(HtmlUtil.cleanHtmlTag(schedule.getScheduleDesc()));
					// 设置文章摘要
					if (summaryText.length() > post_summary) {
						schedule.setScheduleDesc(summaryText.substring(0, post_summary));
					} else {
						schedule.setScheduleDesc(summaryText);
					}
				}
				//articleService.save(schedule, tags, categorys);
				// 添加日志
				logService.save(new Log(LogConstant.PUBLISH_AN_ARTICLE, LogConstant.SUCCESS,
						ServletUtil.getClientIP(request), DateUtil.date()));
			} else {
				// 如果没有选择略缩图则随机一张图
				if (StrUtil.isEmpty(schedule.getSchedulePhoto())) {
					schedule.setSchedulePhoto("/static/img/rand/" + RandomUtil.randomInt(1, 19) + ".jpg");
				}
				// 判断摘要是否为空
				if (StrUtil.isEmpty(schedule.getScheduleDesc())) {
					// 如果摘要为空则取前五十字为摘要
					int post_summary = 50;
					if (StrUtil.isNotEmpty(MaydayConst.OPTIONS.get("post_summary"))) {
						post_summary = Integer.parseInt(MaydayConst.OPTIONS.get("post_summary"));
					}
					// 清理html标签和空白字符
					String summaryText = StrUtil.cleanBlank(HtmlUtil.cleanHtmlTag(schedule.getScheduleMessage()));
					// 设置文章摘要
					if (summaryText.length() > post_summary) {
						schedule.setScheduleDesc(summaryText.substring(0, post_summary));
					} else {
						schedule.setScheduleDesc(summaryText);
					}
				}
				// 文章最后修改时间
				schedule.setUpdateDate(DateUtil.date());
				//articleService.update(article, tags, categorys);
				// 添加日志
				logService.save(new Log(LogConstant.UPDATE_AN_ARTICLE, LogConstant.SUCCESS,
						ServletUtil.getClientIP(request), DateUtil.date()));
			}
		} catch (Exception e) {
			log.error("添加或更新失败" + e.getMessage());
			return new JsonResult(MaydayEnums.ERROR.isFlag(), MaydayEnums.ERROR.getMessage());
		}
		return new JsonResult(MaydayEnums.PRESERVE_SUCCESS.isFlag(), MaydayEnums.PRESERVE_SUCCESS.getMessage());
	}
}
