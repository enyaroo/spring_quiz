package com.quiz.logpension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.quiz.logpension.bo.BookingBO;
import com.quiz.logpension.domain.Booking;

@RequestMapping("/lesson06/logpension")
@Controller
public class LogpensionController {
	
	@Autowired
	private BookingBO bookingBO;
	
	// http://localhost:8080/lesson06/logpension/booking-view
	@GetMapping("/booking-view")
	public String BookingView(Model model) {
		List<Booking> bookingList = bookingBO.getBookingList();
		model.addAttribute("bookingList", bookingList);
		return "logpension/bookingListView";
	}
	
	// 예약 삭제 기능 - AJAX요청(responsebody가 꼭 필요)
	@DeleteMapping("/booking-delete")
	@ResponseBody
	public Map<String, Object> deleteBookingById(
			@RequestParam("id") int id) {
		bookingBO.deleteBookingById(id);
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		return result;
	}
	
	@GetMapping("/add-booking-view")
	public String addBookingView() {
		return "logpension/addBooking";
	}
	
	// 예약 등록 - AJAX
	@PostMapping("/add-booking")
	@ResponseBody
	public Map<String, Object> addBooking(
			@RequestParam("name") String name
			, @RequestParam("date") String date
			, @RequestParam("day") int day
			, @RequestParam("headcount") int headcount
			, @RequestParam("phoneNumber") String phoneNumber) {
		bookingBO.addBooking(name, date, day, headcount, phoneNumber);
		Map<String, Object> result = new HashMap<>();
		result.put("result", "success");
		return result;
	}
	
	// 메인 페이지
	@GetMapping("/main")
	public String mainBooking() {
		return "logpension/checkBooking";
	}
	
	// 예약확인 ajax
	@PostMapping("/check-booking")
	@ResponseBody // Model 사용 불가(view로 가지 않기 때문, jsp로 return할때만 사용)
	public Map<String, Object> checkBookingByNamePhonNumber(
			@RequestParam("name") String name
			, @RequestParam("phoneNumber") String phoneNumber) {
		Booking booking = bookingBO.checkBookingByNamePhonNumber(name, phoneNumber);
		// 응답값
		// {"code":400, "error_msg":"데이터가 존재하지 않습니다."}
		// {"code":200, "result":{"id":1, "name":...}}
		Map<String, Object> result = new HashMap<>();
		if (booking == null) {
			result.put("code", 400);
			result.put("error_message", "데이터가 존재하지 않습니다.");
		} else {
			result.put("code", 200);
			result.put("result", booking);
			
		}
		return result;
	}
}
