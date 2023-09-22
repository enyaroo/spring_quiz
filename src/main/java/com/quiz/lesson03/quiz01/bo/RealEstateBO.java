package com.quiz.lesson03.quiz01.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson03.quiz01.domain.RealEstate;
import com.quiz.lesson03.quiz01.mapper.RealEstateMapper;

@Service
public class RealEstateBO {
	
	@Autowired
	private RealEstateMapper realEstateMapper;
	
	public RealEstate getRealEstate(int param) {
		return realEstateMapper.selectRealEstate(param);
	}
	
//	public List<RealEstate> getRealEstateList(int param) {
//		return realEstateMapper.selectRealEstateList(param);
//	}
	
	public List<RealEstate> getRealEstateList(int area, int price) {
		return realEstateMapper.selectRealEstateList(area, price);
	}
	
}
