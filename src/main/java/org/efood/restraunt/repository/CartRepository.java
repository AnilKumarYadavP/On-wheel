package org.efood.restraunt.repository;

import org.efood.restraunt.dto.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository  extends JpaRepository<Cart,Integer>{

}
