package com.quiz.lesson06;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	@ResponseBody
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
	
	@PostMapping("/quiz01/is-duplication")
	@ResponseBody
	public Map<String, Object> isDuplication(
			@RequestParam("url") String url) {
		
		// DB 조회
		Bookmark bookmark = bookmarkBO.getBookmarkByUrl(url);
		
		// 응답값
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("is_duplication", false);
		if (bookmark != null) {
			result.put("is_duplication", true);
		}
		return result;
	}
	
	// bookmark 삭제 기능 - AJAX 호출
	@DeleteMapping("/quiz01/delete-bookmark")
	@ResponseBody
	public Map<String, Object> deleteBookmarkById(
			@RequestParam("id") int id) {
		bookmarkBO.deleteBookmarkById(id);
		Map<String, Object> result = new HashMap<>();
		result.put("code", 200);
		result.put("result", "성공");
		return result;
	}
}
