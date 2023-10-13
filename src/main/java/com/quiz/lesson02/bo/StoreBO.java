package com.quiz.lesson02.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson02.domain.Store;
import com.quiz.lesson02.mapper.StoreMapper;
import com.quiz.review.domain.Review;

@Service
public class StoreBO {
	
	@Autowired
	private StoreMapper storeMapper;
	
	public List<Store> getStoreList() {
		return storeMapper.selectStoreList();
	}
	
	public List<Review> getReviewByStoreIdList(int storeId, String storeName) {
		return storeMapper.selectReviewByStoreIdList(storeId, storeName);
	}
}
