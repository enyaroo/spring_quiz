package com.quiz.lesson03.quiz01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson03.quiz01.domain.RealEstate;

@Repository
public interface RealEstateMapper {

	public RealEstate selectRealEstate(int param);
	
	// public List<RealEstate> selectRealEstateList(int param);
	
	public List<RealEstate> selectRealEstateListByAreaPrice(
			// @Param 하나의 map이 된다. (parameter가 두 개 이상일 때)
			@Param("area") int area, @Param("price") int price);

	public int insertRealEstate(RealEstate realestate);
	
	// xml과 짝을 이루어야하기때문에 메소드 오버로딩 불가능
	public int insertRealEstateAsField(
			@Param("realtorId") int realtorId
			, @Param("address") String address
			, @Param("area") int area
			, @Param("type") String type
			, @Param("price") int price
			, @Param("rentPrice") Integer rentPrice);
	
	public int updateRealEstateById(
			@Param("id") int id
			, @Param("type") String type
			, @Param("price") int price);
	
	public int deleteRealEstateById(int id);
}
