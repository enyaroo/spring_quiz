package com.quiz.lesson07;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quiz.lesson07.entity.RecruitEntity;
import com.quiz.lesson07.repository.RecruitRepository;

@RequestMapping("/lesson07/quiz02")
@RestController
public class Lesson07RestController2 {
	
	@Autowired
	private RecruitRepository recruitRepository;
	
	@GetMapping("/1")
	public RecruitEntity getRecruitListById() {
		return recruitRepository.findById(8).orElse(null);
	}
	
	@GetMapping("/2")
	public List<RecruitEntity> getRecruitListByCompanyId(
			@RequestParam(name="companyId") int id) {
		return recruitRepository.findAllByCompanyId(id);
	}
	
	@GetMapping("/3")
	public List<RecruitEntity> getRecruitListByPositionAndType() {
		return recruitRepository.findAllByPositionAndType("웹 back-end 개발자", "정규직");
	}
	
	@GetMapping("/4")
	public List<RecruitEntity> getRecruitListByTypeOrSalary() {
		return recruitRepository.findAllByTypeOrSalaryGreaterThanEqual("정규직", 9000);
	}
	
	@GetMapping("/5")
	public List<RecruitEntity> getRecruitListByTypeAndSalary() {
		return recruitRepository.findTop3ByTypeOrderBySalaryDesc("계약직");
	}
	
	@GetMapping("/6")
	public List<RecruitEntity> getRecruitListByRegionAndSalary() {
		return recruitRepository.findAllByRegionAndSalaryBetween("성남시 분당구", 7000, 8500);
	}
	
	@GetMapping("/7")
	public List<RecruitEntity> quiz02_7() {
		return recruitRepository.findAllByDeadlineAndSalaryGreaterThanAndType(LocalDate.of(2026,04,10), 8100, "정규직");
	}
}
