package org.efood.restraunt.service;

import java.util.List;

import org.efood.restraunt.dao.CustomerDao;
import org.efood.restraunt.dao.HotelDao;
import org.efood.restraunt.dao.ProductDao;
import org.efood.restraunt.dto.AddProduct;
import org.efood.restraunt.dto.Customer;
import org.efood.restraunt.dto.Hotel;
import org.efood.restraunt.helper.LoginHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;

@Service
public class AdminService {
	
	@Autowired
	ProductDao productDao;
	
	@Autowired
	HotelDao  hotelDao;
	
	
	@Autowired
	CustomerDao customerDao;

    public String login(LoginHelper helper, ModelMap model, HttpSession session) {
        if (helper.getEmail().equals("admin@jsp.com")) {
            if (helper.getPassword().equals("admin")) {
                session.setAttribute("admin", "admin");
                model.put("pass", "Login Success");
                return "Adminhome";
            } else {
                model.put("fail", "Incorrect Password");
                return "Admin";
            }
        } else {
            model.put("fail", "Incorrect Email");
            return "Admin";
        }
    }

	


	public String fetchProducts(ModelMap map, HttpSession session) {
		List<AddProduct> product = productDao.fetchAllProducts();
		if (product == null|| product.isEmpty()) {
			map.put("neg", "No Products Available");
			return "Adminhome";
		} else {
			map.put("products", product);
			return "AdminProducts";
		}
	}




	public String changeStatus(int id, HttpSession session, ModelMap map) {
		
			AddProduct addProduct = productDao.findById(id);
			if (addProduct == null) {
				map.put("neg", "Something went wrong");
				return "Main";
			} else {
				if (addProduct.isStatus())
					addProduct.setStatus(false);
				else
					addProduct.setStatus(true);

				productDao.save(addProduct);
				map.put("pos", "Status Changed Success");
				return fetchProducts(map,session);
			}
		}




	public String fetchHotels(HttpSession session, ModelMap map) {
		List<Hotel> hotels = hotelDao.fetchAll();
		if (hotels == null || hotels.isEmpty()) {
			map.put("neg", "no hotels");
			return "Adminhome";
		} else {
			map.put("hotels", hotels);
			return "AdminHotel";
		}
	}




	public String fetchCustomers(HttpSession session, ModelMap map) {
		List<Customer> customers = customerDao.fetchAll();
		if (customers == null || customers.isEmpty()) {
			map.put("neg", "no customers");
			return "Adminhome";
		} else {
			map.put("customers", customers);
			return "AdminCustomer";
		}
	}
	}



	



