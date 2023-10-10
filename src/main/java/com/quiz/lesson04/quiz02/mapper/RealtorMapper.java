package com.quiz.lesson04.quiz02.mapper;

import org.springframework.stereotype.Repository;

import com.quiz.lesson04.quiz02.domain.Realtor;

@Repository
public interface RealtorMapper {
	
	// input : Realtor 객체
	// output : X
	public void insertRealtor(Realtor realtor);
	
	// input : realtor id
	// output : Realtor 객체
	public Realtor selectRealtorById(int id);
	
}
