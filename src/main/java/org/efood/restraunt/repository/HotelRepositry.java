package org.efood.restraunt.repository;

import org.efood.restraunt.dto.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepositry extends JpaRepository<Hotel, Integer> {

	Hotel findByEmail(String email);

	Hotel findByMobile(long mobile);



}
