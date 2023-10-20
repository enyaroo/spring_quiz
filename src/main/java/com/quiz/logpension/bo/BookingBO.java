package com.quiz.logpension.bo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.quiz.logpension.domain.Booking;
import com.quiz.logpension.mapper.BookingMapper;

@Service
public class BookingBO {
	
	@Autowired
	private BookingMapper bookingMapper;
	
	public List<Booking> getBookingList() {
		return bookingMapper.selectBookingList();
	}
	
	public void deleteBookingById(int id) {
		bookingMapper.deleteBookingById(id);
	}
	
	public void addBooking(String name, String date, int day
			, int headcount, String phoneNumber) {
		bookingMapper.insertBooking(name, date, day, headcount, phoneNumber);
	}
	
	// input : name, phoneNumber
	// output : Booking (null or Booking)
	public Booking checkBookingByNamePhonNumber(String name, String phoneNumber) {
		List<Booking> bookingList = bookingMapper.selectBookingByNamePhonNumber(name, phoneNumber);
		// 0 1 (최신)
		// 리스트가 비어있다면 아예 null이 아닌 [](empty list)로 되어있음 << MyBatis 특
		if (bookingList.isEmpty()) {
			return null; // 빈 리스트일때 null return
		}
		
		// 리스트가 비어있지 않으면 마지막 객체를 리턴
		return bookingList.get(bookingList.size() - 1); // 리스트에 뭐가 있다면 최신 Booking 객체 return
	}
}
