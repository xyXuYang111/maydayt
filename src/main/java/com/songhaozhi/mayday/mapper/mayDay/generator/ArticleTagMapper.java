package com.songhaozhi.mayday.mapper.mayDay.generator;

import com.songhaozhi.mayday.annotation.MyBatisDao;
import com.songhaozhi.mayday.model.domain.ArticleTag;
import com.songhaozhi.mayday.model.domain.ArticleTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
@MyBatisDao
public interface ArticleTagMapper {
	long countByExample(ArticleTagExample example);

	int deleteByExample(ArticleTagExample example);

	int insert(ArticleTag record);

	int insertSelective(ArticleTag record);

	List<ArticleTag> selectByExample(ArticleTagExample example);

	int updateByExampleSelective(@Param("record") ArticleTag record, @Param("example") ArticleTagExample example);

	int updateByExample(@Param("record") ArticleTag record, @Param("example") ArticleTagExample example);
}