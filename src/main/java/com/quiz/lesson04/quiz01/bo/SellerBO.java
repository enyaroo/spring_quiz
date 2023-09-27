package com.quiz.lesson04.quiz01.bo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson04.quiz01.domain.Seller;
import com.quiz.lesson04.quiz01.mapper.SellerMapper;

@Service
public class SellerBO {
	
	@Autowired
	private SellerMapper sellerMapper;
	
	// input : 3개의 파라미터
	// output : x
	public void addSeller(String nickname, String profileImageUrl, Double temperature) {
		sellerMapper.insertSeller(nickname, profileImageUrl, temperature);
	}
	
	public Seller getLatestSellerView() {
		return sellerMapper.selectLatestSellerView();
	}
	
	public Seller getSellerById(int id) {
		return sellerMapper.selectSellerById(id);
	}
}
