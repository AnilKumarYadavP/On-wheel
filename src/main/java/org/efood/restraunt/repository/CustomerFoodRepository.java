package org.efood.restraunt.repository;

import org.efood.restraunt.dto.CustomersFood;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CustomerFoodRepository extends JpaRepository<CustomersFood, Integer> {

}
