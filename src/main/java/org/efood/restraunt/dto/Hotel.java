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
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Component
@Data
@Entity
public class Hotel {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	@Size(min=5,max=25,message = "* Enter characters between 5 to 25")
	private String name;
	@Email(message = "*Enter proper email Id")
	@NotEmpty(message = "*This field should not be empty")
	private String email;
	@DecimalMin(value="6000000000",message = "enter  proper phoneno")
	@DecimalMax(value = "9999999999",message = "enter  proper phoneno")
	private long mobile;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$",message = "enter properly")
	private String password;
	private boolean Status;
	private int otp;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	List<AddProduct> product;
	
}
