package com.quiz.lesson04.quiz01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson04.quiz01.bo.SellerBO;
import com.quiz.lesson04.quiz01.domain.Seller;

@RequestMapping("/lesson04/quiz01")
@Controller
public class Lesson04Quiz01Controller {
	
	@Autowired
	private SellerBO sellerBO;
	
	// 1번 문제 : 판매자 추가 화면
	// url : http://localhost:8080/lesson04/quiz01/add-seller-view
	@GetMapping("/add-seller-view")
	public String addSellerView() {
		return "lesson04/addSeller";
	}
	
	// 1번 문제 : 판매자 DB에 추가 => 입력 성공 페이지로 이동
	@PostMapping("/add-seller")
	public String addSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam(value="profileImageUrl", required=false) String profileImageUrl
			, @RequestParam(value="temperature", required=false) Double temperature) {
		
		// DB insert
		sellerBO.addSeller(nickname, profileImageUrl, temperature);
		
		return "lesson04/afterAddSeller";
	}
	
	// 2번 문제
	// url : http://localhost:8080/lesson04/quiz01/get-latest-seller-view
	// url : http://localhost:8080/lesson04/quiz01/get-latest-seller-view?id=2
	@GetMapping("/get-latest-seller-view")
	public String getLatestSellerView(
			Model model
			, @RequestParam(required=false) Integer id) {
		Seller seller = null;
		if (id == null) {
			seller = sellerBO.getLatestSellerView();			
		} else {
			seller = sellerBO.getSellerById(id);		
		}
		model.addAttribute("result", seller);
		return "lesson04/sellerInfo";
	}
}
