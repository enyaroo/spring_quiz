package com.quiz.lesson03.quiz01;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.quiz01.bo.RealEstateBO;
import com.quiz.lesson03.quiz01.domain.RealEstate;

@RequestMapping("/lesson03/quiz01")
@RestController
public class Lesson03Quiz01RestController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	// url : http://localhost:8080/lesson03/quiz01/1?id={}
	@RequestMapping("/1")
	public RealEstate quiz01(
			@RequestParam("id") int id) {
		return realEstateBO.getRealEstate(id);
	}
	
//	@RequestMapping("/2")
//	public List<RealEstate> quiz01_2(
//			@RequestParam("rent_price") int param) {
//		return realEstateBO.getRealEstateList(param);
//	}
	
	// url : http://localhost:8080/lesson03/quiz01/3?area=90&price=130000
	@RequestMapping("/3")
	public List<RealEstate> quiz01_3(
			@RequestParam("area") int area,
			@RequestParam("price") int price) {
		return realEstateBO.getRealEstateListByAreaPrice(area, price); // response body => JSON(List)
	}
	
}
