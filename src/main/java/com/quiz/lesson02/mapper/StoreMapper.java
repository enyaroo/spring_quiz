package com.quiz.lesson02.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quiz.lesson02.domain.Store;
import com.quiz.review.domain.Review;

@Repository
public interface StoreMapper {
	
	public List<Store> selectStoreList();
	
	public List<Review> selectReviewByStoreIdList(int storeId, String storeName);
}