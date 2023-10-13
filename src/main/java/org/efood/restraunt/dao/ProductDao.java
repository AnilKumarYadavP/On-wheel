package org.efood.restraunt.dao;

import java.util.List;

import org.efood.restraunt.dto.AddProduct;
import org.efood.restraunt.dto.Cart;
import org.efood.restraunt.dto.CustomersFood;
import org.efood.restraunt.dto.Payment;
import org.efood.restraunt.repository.CartRepository;
import org.efood.restraunt.repository.CustomerFoodRepository;
import org.efood.restraunt.repository.PaymentDetails;
import org.efood.restraunt.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDao {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	CustomerFoodRepository customerFoodRepository;
	
	@Autowired
	CartRepository cartRepository;
	
	@Autowired
	PaymentDetails details;

	public void delete(AddProduct addProduct) {
		productRepository.delete(addProduct);
		
	}



	public AddProduct findById(int id) {
		
		return productRepository.findById(id).orElse(null);
	}



	public  List<AddProduct> fetchAllProducts() {
		return productRepository.findAll();
	}



	public void save(AddProduct addproduct) {
		productRepository.save(addproduct);
		
	}



	public List<AddProduct> getProduct() {
		
		return productRepository.findByStatusTrue();
	}



	public void delete(CustomersFood customerFood) {
		customerFoodRepository.delete(customerFood);
		
	}



	public void save(CustomersFood customerFood) {
		customerFoodRepository.save(customerFood);
		
	}



	public void save(Cart cart) {
		cartRepository.save(cart);
		
	}



	public void save(Payment payment) {
		details.save(payment);
		
	}



	

	     public Payment fetchDetails(int id) {
	        return details.findById(id).orElse(null);
	    }



		public void savePayment(Payment payment) {
			details.save(payment);
			
		}



		


	



	



	



	

	

}
