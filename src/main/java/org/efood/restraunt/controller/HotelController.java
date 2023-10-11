package org.efood.restraunt.controller;


import java.io.IOException;

import org.efood.restraunt.dto.AddProduct;
import org.efood.restraunt.dto.Hotel;
import org.efood.restraunt.helper.LoginHelper;
import org.efood.restraunt.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/hotel")
public class HotelController {
	
	@Autowired  
	Hotel hotel;
	
	
	@Autowired
	HotelService service;
	
	@Autowired
	AddProduct addProduct;
	
	
	@GetMapping
	public String LoadHotel() {
		return "Hotel";
	}
	
	@GetMapping("/register")
	public String LoadRegister(ModelMap map) {
		map.put("hotel",hotel );
		return "HotelRegister";
		
	}
	
	@PostMapping("/register")
	public String register (@Valid Hotel hotel,BindingResult result,ModelMap map) {
		
		if(result.hasErrors()) {
			return "HotelRegister";
		}
		else {
		return service.register(hotel,map);
		}
	}
	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam int id, @RequestParam int otp, ModelMap map) {
		return service.verifyOtp(id, otp, map);
	}
	
	@PostMapping("/login")
	public String login(LoginHelper helper,ModelMap map,HttpSession session) {
		return service.login(helper,map,session);
		
	}
	
	@GetMapping("/add-product")
	public String addproduct(ModelMap map,HttpSession session) {
	   Hotel hotel=(Hotel) session.getAttribute("hotel");
		if(hotel!=null)
		{
			return "Addproduct";
		}else
			map.put("neg", "Invalid Session");
		return "Hotel";
		
	}
	
	@PostMapping("/add-product")
	public String addProduct(AddProduct product,ModelMap map,HttpSession session,@RequestParam MultipartFile pic) throws IOException {
	   Hotel hotel=(Hotel) session.getAttribute("hotel");
		if(hotel!=null)
		{
			return service.addProduct(product,pic,map,session,hotel);
		}else {
			map.put("neg", "Invalid Session");
			return "Hotel";
		}
		
	}
	
	 @GetMapping("/fetch-product")
	    public String fetchProducts(HttpSession session, ModelMap map) {
	    Hotel hotel = (Hotel) session.getAttribute("hotel");
	        if (hotel != null) {
	        	
	           return service.fetchProducts(hotel,session, map);
	        } else {
	            map.put("neg", "Invalid Session");
	            return "HotelLogin";
	        }
	    }
	 
	 @GetMapping("/home")
	 public String home(HttpSession session,ModelMap map) {
		 Hotel hotel=(Hotel) session.getAttribute("hotel");
	        if (hotel != null) {
	        	
		           return "HotelHome";
		        } else {
		            map.put("neg", "Invalid Session");
		            return "HotelLogin";
		        }
	 }
	 
	 @GetMapping("/delete/{id}")
	 public String delete(HttpSession session,ModelMap map,@PathVariable int id) {
		 Hotel hotel=(Hotel) session.getAttribute("hotel");
	        if (hotel != null) {
	        	
		           return service.delete(id,hotel,session, map);
		        } else {
		            map.put("neg", "Invalid Session");
		            return "HotelLogin";
		        }
	 }
	 
	 @GetMapping("/edit/{id}")
	 public String edit(HttpSession session,ModelMap map,@PathVariable int id) {
		 Hotel hotel=(Hotel) session.getAttribute("hotel");
	        if (hotel != null) {
	        	
		           return service.edit(id,hotel,session, map);
		        } else {
		            map.put("neg", "Invalid Session");
		            return "HotelLogin";
		        }
	 }
	 
	 @PostMapping("/update-product")
		public String updateProduct(@Valid AddProduct addproduct, BindingResult result, @RequestParam MultipartFile pic,
				ModelMap map, HttpSession session) throws IOException {
			Hotel hotel = (Hotel) session.getAttribute("hotel");
			if (hotel != null) {
				if (result.hasErrors())
					return "EditProduct";
				else {
					return service.editProduct(addproduct, pic, map, hotel, session);
				}
			} else {
				map.put("neg", "Invalid Session");
				return "HotelHome";
			}
		}
	 

	 
	
	
}
