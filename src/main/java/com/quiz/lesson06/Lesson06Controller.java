package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.lesson06.quiz01.bo.BookmarkBO;
import com.quiz.lesson06.quiz01.domain.Bookmark;

@RequestMapping("/lesson06")
@Controller
public class Lesson06Controller {
	
	@Autowired
	private BookmarkBO bookmarkBO;
	
	// ------------quiz01-------------
	// 즐겨찾기 추가 화면
	@GetMapping("/quiz01/add-bookmark-view")
	public String addBookmarkView() {
		return "lesson06/addBookmark";
	}
	
	// 즐겨찾기 추가 로직 - AJAX 요청
	@PostMapping("/quiz01/add-bookmark")
	public Map<String, Object> addBookmark(
			@RequestParam("name") String name
			, @RequestParam("url") String url
			) {
		bookmarkBO.addBookmark(name, url);
		
		// 응답값 : JSON String
		// {"code":200, "result":"success"}
		Map<String, Object> result = new HashMap<>();
		result.put("code", 1);
		result.put("result", "success");
		
		return result;
	}
	
	@GetMapping("/quiz01/get-bookmark-list")
	public String getBookmarkList(Model model) {
		List<Bookmark> bookmarkList = bookmarkBO.getBookmarkList();
		model.addAttribute("bookmarkList", bookmarkList);
		return "lesson06/getBookmark";
	}
	
	@GetMapping("/quiz01/is-duplication")
	@ResponseBody
	public Map<String, Object> isDuplication(
			@RequestParam("url") String url) {
		bookmarkBO
		
		return result;
	}
	
//	@GetMapping("/quiz01/delete-bookmark")
//	public void deleteBookmarkById(
//			@RequestParam("id") int id) {
//		bookmarkBO.deleteBookmarkById(id);
//	}
}
