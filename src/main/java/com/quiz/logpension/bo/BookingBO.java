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
	
	public Booking checkBookingByNamePhonNumber(String name, String phoneNumber) {
		return bookingMapper.selectBookingByNamePhonNumber(name, phoneNumber);
	}
}
