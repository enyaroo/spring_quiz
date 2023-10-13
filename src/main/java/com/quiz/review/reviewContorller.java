package com.quiz.review;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.lesson02.bo.StoreBO;
import com.quiz.lesson02.domain.Store;
import com.quiz.review.domain.Review;

@RequestMapping("/review")
@Controller
public class reviewContorller {
	
	@Autowired
	private StoreBO storeBO;
	
	@GetMapping("/store")
	public String storeList(Model model) {
		List<Store> storeList = storeBO.getStoreList();
		model.addAttribute("storeList", storeList);
		
		return "review/main";
	}
	
	@GetMapping("/reviews")
	public String getReviewByStoreId(
			Model model
			, @RequestParam("storeId") int storeId
			, @RequestParam("storeName") String storeName) {
		List<Review> reviewByStoreIdList = storeBO.getReviewByStoreIdList(storeId, storeName);
		model.addAttribute("reviewByStoreIdList", reviewByStoreIdList);
		return "review/review";
	}
	
}
