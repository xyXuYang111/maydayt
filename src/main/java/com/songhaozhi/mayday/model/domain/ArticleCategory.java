package com.songhaozhi.mayday.model.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class ArticleCategory implements Serializable {
	private Integer articleId;

	private Long categoryId;
}