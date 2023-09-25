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
	
	// input : area, place
	// output : List<RealEstate>
	public List<RealEstate> getRealEstateListByAreaPrice(int area, int price) {
		return realEstateMapper.selectRealEstateListByAreaPrice(area, price);
	}
	
	public int addRealEstate(RealEstate realEstate) {
		return realEstateMapper.insertRealEstate(realEstate);
	}
	
	public int addRealEstateAsField(int realtorId, String address, int area, String type, int price, Integer rentPrice) {
		return realEstateMapper.insertRealEstateAsField(realtorId, address, area, type, price, rentPrice);
	}
	
	public int updateRealEstateById(int id, String type, int price) {
		return realEstateMapper.updateRealEstateById(id, type, price);
	}
	
	public int deleteRealEstateById(int id) {
		return realEstateMapper.deleteRealEstateById(id);
	}
}
