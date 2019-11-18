package com.songhaozhi.mayday.model.domain;

import java.io.Serializable;

public class ArticleTag implements Serializable {
	private static final long serialVersionUID = -6373746878318423897L;
	private Integer articleId;

	private Long tagId;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Long getTagId() {
		return tagId;
	}

	public void setTagId(Long tagId) {
		this.tagId = tagId;
	}
}