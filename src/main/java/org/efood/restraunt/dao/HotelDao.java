package org.efood.restraunt.dao;

import java.util.List;

import org.efood.restraunt.dto.Hotel;
import org.efood.restraunt.repository.HotelRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HotelDao {
	
	@Autowired
	HotelRepositry hotelRepositry;

	public Hotel fetchByEmail(String email) {
		
		return hotelRepositry.findByEmail(email);
	}

	public Hotel fetchByMobile(long mobile) {
		
		return hotelRepositry.findByMobile(mobile);
	}

	public Hotel fetchById(int id) {
		
		return hotelRepositry.findById(id).orElse(null);
	}

	public Hotel save(Hotel hotel) {
	   return	hotelRepositry.save(hotel);
		
	}

	public void delete(Hotel product) {
		hotelRepositry.delete(product);
		
	}

	

	public List<Hotel> fetchAll() {
		
		return hotelRepositry.findAll();
	}

}
