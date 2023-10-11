package org.efood.restraunt.repository;

import java.util.List;
import java.util.Optional;

import org.efood.restraunt.dto.AddProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<AddProduct, Integer> {

	Optional<AddProduct> findById(int id);

	List<AddProduct> findByStatusTrue();

}
