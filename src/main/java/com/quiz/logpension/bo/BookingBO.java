package com.quiz.logpension.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
}
