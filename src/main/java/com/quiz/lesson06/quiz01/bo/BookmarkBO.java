package com.quiz.lesson06.quiz01.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson06.quiz01.domain.Bookmark;
import com.quiz.lesson06.quiz01.mapper.BookmarkMapper;

@Service
public class BookmarkBO {
	
	@Autowired
	private BookmarkMapper bookmarkMapper;
	
	public void addBookmark(String name, String url) {
		bookmarkMapper.insertBookmark(name, url);
	}
	
	public List<Bookmark> getBookmarkList() {
		return bookmarkMapper.selectBookmarkList();
	}
	
	public void deleteBookmarkById(int id) {
		bookmarkMapper.deleteBookmarkById(id);
	}
	
	// input : url
	// output : Bookmark (단건이거나 null)
	// Too many result 에러=> 단건으로 리턴하지만 결과는 List로 나왔을 때
	public Bookmark getBookmarkByUrl(String url) {
		return bookmarkMapper.selectBookmarkByUrl(url);
	}
}
