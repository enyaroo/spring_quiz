package com.quiz.logpension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@DeleteMapping("/booking-delete")
	@ResponseBody
	public Map<String, Object> deleteBookingById(
			@RequestParam("id") int id) {
		bookingBO.deleteBookingById(id);
		Map<String, Object> result = new HashMap<>();
		return result;
	}
	
}
