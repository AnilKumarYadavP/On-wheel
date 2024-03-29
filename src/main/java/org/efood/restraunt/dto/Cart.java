package org.efood.restraunt.dto;

import java.util.List;

import org.springframework.stereotype.Component;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Component
@Data
@Entity
public class Cart {
	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<CustomersFood> customersFoods;
}
