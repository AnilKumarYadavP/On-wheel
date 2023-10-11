package org.efood.restraunt.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.efood.restraunt.dao.HotelDao;
import org.efood.restraunt.dao.ProductDao;
import org.efood.restraunt.dto.AddProduct;
import org.efood.restraunt.dto.Hotel;
import org.efood.restraunt.helper.AES;
import org.efood.restraunt.helper.LoginHelper;
import org.efood.restraunt.helper.SendMailLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Service
@Component
public class HotelService {

	@Autowired
	HotelDao hotelDao;
	
	@Autowired
	SendMailLogic logic;
	
	@Autowired
	ProductDao productDao;
	
	public String register( Hotel hotel, ModelMap map) {
		Hotel hotel1=hotelDao.fetchByEmail(hotel.getEmail());

		Hotel hotel2=hotelDao.fetchByMobile(hotel.getMobile());
		
		if(hotel1==null && hotel2==null) {
			int otp=new Random().nextInt(1000,9999);
			hotel.setOtp(otp);
			logic.send(hotel);
			hotel.setPassword(AES.encrypt(hotel.getPassword(), "123"));
			hotelDao.save(hotel);
			
			map.put("id", hotel.getId());
			return "HotelVerifyOtp";
			
		}else {
			map.put("neg", "Email and mobile number shouldn't repeat");
			return "HotelRegister";
		}
	}


	public String verifyOtp(int id, int otp, ModelMap map) {
		
			Hotel hotel = hotelDao.fetchById(id);
			if(hotel.getOtp() == otp) {
				hotel.setStatus(true);
				hotelDao.save(hotel);
				map.put("pos", "Otp varify Successfully");
				return "Hotel";
			}else
			{
				map.put("neg", "Otp mismatch");
				map.put("id", hotel.getId());
				return "HotelVerifyOtp";
			}
	}


	public String login(LoginHelper helper, ModelMap map, HttpSession session) {
		Hotel hotel=hotelDao.fetchByEmail(helper.getEmail());
		if(hotel==null) {
			map.put("neg", "Invalid Email");
			return "Hotel";
		}else
			 
			if  (AES.decrypt(hotel.getPassword(), "123").equals(helper.getPassword())) {
				session.setAttribute("hotel", hotel);
			map.put("pos", "Password Scusses");
		return "HotelHome";
			}
		else {
			map.put("neq", "IncorrectPassword");
			return "Hotel";
	}

}


	public String addProduct(AddProduct product, MultipartFile pic, ModelMap map, HttpSession session, Hotel hotel) throws IOException {
		byte[] image=new byte[pic.getInputStream().available()];
		pic.getInputStream().read(image);
		
	    product.setImage(image);
	    List<AddProduct> list=hotel.getProduct();
	    if(list==null)
	    	list=new ArrayList<AddProduct>();
	    	list.add(product);
	    	hotel.setProduct(list);
	    	hotelDao.save(hotel);
	    	map.put("pos", "product added successfully");
	    	return "HotelHome";
	}


	


	public String fetchProducts(Hotel hotel, HttpSession session, ModelMap map) {
		  List<AddProduct> products =hotel.getProduct();
	        if(products==null || products.isEmpty())
	        {
	        	
	            map.put("neg", "no product");
	            return "HotelHome";
	        }
	        else{
	            map.put("products", products);
	            return "HotelItems";
	        }
	}


	


	public String delete(int id, Hotel hotel, HttpSession session, ModelMap map) {
		AddProduct addProduct=productDao.findById(id);
		if(hotel==null) {
			map.put("neg", "No Product Found");
			return "Main";
		}else {
			hotel.getProduct().remove(addProduct);
			Hotel hotel1=hotelDao.save(hotel);
			session.setAttribute("hotel", hotel1);
			productDao.delete(addProduct);
			map.put("pos", "Product Deleted Success");
			return fetchProducts(hotel, session, map);
		}
		
	}


	public String edit(int id, Hotel hotel, HttpSession session, ModelMap map) {
		AddProduct addProduct=productDao.findById(id);
		if(hotel==null) {
			map.put("neg", "No Product Found");
			return "Main";
		}else {
			map.put("product", addProduct);
			return "EditProduct";
		}

	}


	public String editProduct(@Valid AddProduct addproduct, MultipartFile pic, ModelMap map, Hotel hotel,
			HttpSession session) throws IOException {
		byte[] image = new byte[pic.getInputStream().available()];
		pic.getInputStream().read(image);

		if (image.length == 0) {
			addproduct.setImage(productDao.findById(addproduct.getId()).getImage());
		} else {
			addproduct.setImage(image);
		}
		productDao.save(addproduct);
		Hotel hotel1 = hotelDao.fetchById(hotel.getId());
		session.setAttribute("hotel", hotel1);
		map.put("pos", "Product Updated Success");
		return fetchProducts(hotel1, session, map);
	}
	}


	
	


	
	
	


	





