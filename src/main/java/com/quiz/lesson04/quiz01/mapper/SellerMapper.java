package com.quiz.lesson04.quiz01.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson04.quiz01.domain.Seller;

@Repository
public interface SellerMapper {
	
	public void insertSeller(
			@Param("nickname") String nickname
			, @Param("profileImageUrl") String profileImageUrl
			, @Param("temperature") Double temperature);

	public Seller selectLatestSellerView();
	
	public Seller selectSellerById(int id);
}
