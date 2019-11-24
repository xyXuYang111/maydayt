package com.songhaozhi.mayday.mongoDB.dao;

import com.songhaozhi.mayday.model.domain.ArticleCustom;
import com.songhaozhi.mayday.model.domain.Category;
import com.songhaozhi.mayday.model.domain.Tag;
import com.songhaozhi.mayday.model.dto.ArchiveBo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : 宋浩志
 * @createDate : 2018年11月1日
 */
public interface ArticleMongo {

	List<ArticleCustom> articleMapperCustom(int status);

	List<ArticleCustom> findAllArticle(int status, String post);

	Integer countByStatus(Integer status, String post);

	void updateStatus(int id, int status);

	ArticleCustom findByArticleId(Integer article_id);

	List<ArchiveBo> findDateAndCount();

	List<ArticleCustom> findPageArticle(ArticleCustom articleCustom);

	int findRepeatByUrl(String articleUrl);

	ArticleCustom findByArticleUrl(String articleUrl);

	List<ArticleCustom> findArtileByCategory(Category category, int status);

	List<ArticleCustom> findArtileByTag(Tag tag, int status);
}
