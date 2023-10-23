package com.quiz.lesson07;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/quiz02")
@RestController
public class Lesson07RestController2 {
	
	@GetMapping("/1")
	public String select(int id) {
		
	}
}
