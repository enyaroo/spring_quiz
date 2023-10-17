package com.quiz.lesson06.quiz01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson06.quiz01.domain.Bookmark;

@Repository
public interface BookmarkMapper {
	
	public void insertBookmark(
			@Param("name") String name
			, @Param("url") String url);
	
	public List<Bookmark> selectBookmarkList();
	
	public void deleteBookmarkById(int id);
	
	public boolean existUrlByUrl(String url);
}
