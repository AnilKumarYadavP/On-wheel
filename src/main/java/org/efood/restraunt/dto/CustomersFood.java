package org.efood.restraunt.dto;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;


@Component
@Data
@Entity
public class CustomersFood {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	private String name;
	private String description;
	private double price;
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] image;
	private int quatity;
	

}
