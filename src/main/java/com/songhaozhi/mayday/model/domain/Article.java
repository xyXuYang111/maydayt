package com.songhaozhi.mayday.model.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Article implements Serializable {
	private static final long serialVersionUID = -3972524905939531263L;
	private Integer id;

	private Integer userId;

	private String articleContent;

	private String articleContentMd;

	private Date articleNewstime;

	private Integer articleStatus;

	private String articleSummary;

	private String articleThumbnail;

	private String articleTitle;

	private Integer articleType;

	private String articlePost;

	private Integer articleComment;

	private Date articleUpdatetime;

	private String articleUrl;

	private Long articleViews;
}