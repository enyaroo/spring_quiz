package com.quiz.quiz02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/quiz02")
@RestController
public class Lesson01Quiz02Controller {
	
	@RequestMapping("/1")
	public List<Map<String, Object>> quiz02_1() {
		List<Map<String, Object>> quizList = new ArrayList<>();
		Map<String, Object> map = new HashMap<>();
		
		map.put("rate", 12);
		map.put("director", "봉준호");
		map.put("time", 131);
		map.put("title", "기생충");
		quizList.add(map);
		
		map = new HashMap<>();
		map.put("rate", 0);
		map.put("director", "로베르토 베니니");
		map.put("time", 116);
		map.put("title", "인생은 아름다워");
		quizList.add(map);
		
		map = new HashMap<>();
		map.put("rate", 12);
		map.put("director", "크리스토퍼 놀란");
		map.put("time", 147);
		map.put("title", "인셉션");
		quizList.add(map);
		
		map = new HashMap<>();
		map.put("rate", 19);
		map.put("director", "윤종빈");
		map.put("time", 133);
		map.put("title", "범죄와의 전쟁 : 나쁜놈들 전성시대");
		quizList.add(map);
		
		map = new HashMap<>();
		map.put("rate", 15);
		map.put("director", "프란시스 로렌스");
		map.put("time", 137);
		map.put("title", "헝거게임");
		quizList.add(map);
		
		return quizList;
	}
	
	@RequestMapping("/2")
	public List<Msg> quiz02_2() {
		
		// @ResponseBody + return String => HttpMessageConverter String(html) => Response body에 내려감
		// @ResponseBody + return 객체(List, Map, 클래스) => HttpMessageConverter jackson 라이브러리 => JSON이 response body에 내려감 => API
		
		List<Msg> msgList = new ArrayList<>();
		
		Msg msg = new Msg();
		
		msg.setTitle("안녕하세요 가입인사 드립니다.");
		msg.setUser("hagulu");
		msg.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		msgList.add(msg);
		
		msg = new Msg();
		msg.setTitle("헐 대박");
		msg.setUser("bada");
		msg.setContent("오늘 목요일이었어... 금요일인줄");
		msgList.add(msg);
		
		msg = new Msg();
		msg.setTitle("오늘 데이트 한 이야기 해드릴게요.");
		msg.setUser("dulumary");
		msg.setContent(".....");
		msgList.add(msg);
		
		return msgList;
	}
	
	@RequestMapping("/3")
	public ResponseEntity<Msg> quiz02_3() {
		Msg msg = new Msg();
		msg.setTitle("안녕하세요 가입인사 드립니다.");
		msg.setUser("hagulu");
		msg.setContent("안녕하세요. 가입했어요. 앞으로 잘 부탁 드립니다. 활동 열심히 하겠습니다.");
		return new ResponseEntity<>(msg, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
