package com.quiz.lesson03.quiz02;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson03.quiz01.bo.RealEstateBO;
import com.quiz.lesson03.quiz01.domain.RealEstate;

@RequestMapping("/lesson03/quiz02")
@RestController
public class Lesson03Quiz02RestController {
	
	@Autowired
	private RealEstateBO realEstateBO;
	
	// url : http://localhost:8080/lesson03/quiz02/1
	@RequestMapping("/1")
	public String quiz02_1() {
		RealEstate realEstate = new RealEstate();
		realEstate.setRealtorId(3);
		realEstate.setAddress("서초동 헤센파크힐 2층 2101호");
		realEstate.setArea(33);
		realEstate.setType("매매");
		realEstate.setPrice(2000000);
		
		int rowCount = realEstateBO.addRealEstate(realEstate);
		
		return "입력 성공 : " + rowCount;
	}
	
	// url : http://localhost:8080/lesson03/quiz02/2
	@RequestMapping("/2")
	public String quiz02_2(
			@RequestParam("realtor_id") int realtorId) {
		int rowCount = realEstateBO.addRealEstateAsField(
				realtorId, "한빛아파트 5동 801호", 20, "월세", 130000, 180);
		return "입력 성공 : " + rowCount;
	}
	
	// url : http://localhost:8080/lesson03/quiz02/3?id=*&type=*&price=*
	@RequestMapping("/3")
	public String quiz02_3(
			@RequestParam("id") int id
			, @RequestParam("type") String type
			, @RequestParam("price") int price) {
		int rowCount = realEstateBO.updateRealEstateById(id, type, price);
		return "수정 성공 : " + rowCount;
	}
	
	// url : http://localhost:8080/lesson03/quiz02/4?id=*
	@RequestMapping("/4")
	public String quiz02_4(@RequestParam("id") int id) {
		int rowCount = realEstateBO.deleteRealEstateById(id);
		return "삭제 성공 : " + rowCount;
	}
	
}
