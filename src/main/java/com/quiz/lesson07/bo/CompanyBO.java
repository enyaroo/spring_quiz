package com.quiz.lesson07.bo;

import java.time.ZonedDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiz.lesson07.entity.CompanyEntity;
import com.quiz.lesson07.repository.CompanyRepository;

@Service
public class CompanyBO {
	
	@Autowired
	private CompanyRepository companyRepository;
	
	public CompanyEntity save(String name, String business
			, String scale, int headcount) {
		CompanyEntity company = CompanyEntity.builder().name(name)
				.business(business).scale(scale).headcount(headcount)
				.createdAt(ZonedDateTime.now())
				.build();
		
		companyRepository.save(company);
		return companyRepository.save(company);
	}
}
