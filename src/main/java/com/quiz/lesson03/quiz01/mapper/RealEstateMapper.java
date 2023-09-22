package com.quiz.lesson03.quiz01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.quiz.lesson03.quiz01.domain.RealEstate;

public interface RealEstateMapper {

	public RealEstate selectRealEstate(int param);
	
	// public List<RealEstate> selectRealEstateList(int param);
	
	public List<RealEstate> selectRealEstateList(@Param("area") int area, @Param("price") int price);

}
