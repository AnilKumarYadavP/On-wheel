package org.efood.restraunt.controller;

import org.efood.restraunt.dto.Customer;
import org.efood.restraunt.helper.LoginHelper;
import org.efood.restraunt.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.razorpay.RazorpayException;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	Customer customer;

	@Autowired
	CustomerService service;

	@GetMapping
	public String customer() {
		return "Customer";
	}

	@GetMapping("/register")
	public String loadRegister(ModelMap map) {
		map.put("customer", customer);
		return "CustomerRegister";
	}

	@PostMapping("/register")
	public String register(@Valid Customer customer, BindingResult result,ModelMap map) {
		if(result.hasErrors()) {
			return "CustomerRegister";
		}else{
	     return service.register(customer, map);
		}
	}
	@PostMapping("/verify-otp")
	public String verifyOtp(@RequestParam int id, @RequestParam int otp, ModelMap map) {
		return service.verifyOtp(id, otp, map);
	}
	@PostMapping("/login")
	public String login(LoginHelper helper, ModelMap map,HttpSession session) {
		return service.login(helper, map,session);
	}
	
	@GetMapping("/home")
		public String loadHome(HttpSession session, ModelMap map) {
			Customer customer = (Customer) session.getAttribute("customer");
			if (customer != null) {
				return "CustomerHome";
			} else {
				map.put("neg", "Invalid Session");
				return "Customer";
			}
	}
	
	@GetMapping("/fetch-products")
    public String fetchProducts(HttpSession session, ModelMap map) {
    Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null) {
        	
           return service.fetchProducts(customer,session, map);
        } else {
            map.put("neg", "Invalid Session");
            return "Customer";
        }
    }
	
	@GetMapping("/cart-add/{id}")
	public String cartAdd(@PathVariable int id,HttpSession session, ModelMap map) {
		Customer customer=(Customer) session.getAttribute("customer");
		if(customer !=null) {
			return service.cartAdd(id,session,map, customer);
		}else {
			map.put("neg", "Invalid Session");
			return "Main";
		}
	}

	@GetMapping("/cart-remove/{id}")
	public String cartRemove(@PathVariable int id,HttpSession session, ModelMap map) {
		Customer customer=(Customer) session.getAttribute("customer");
		if(customer !=null) {
			return service.cartRemove(id,session,map, customer);
		}else {
			map.put("neg", "Invalid Session");
			return "Main";
		}
	}
	
	@GetMapping("/viewcart")
		 public String viewCart(HttpSession session, ModelMap map) throws RazorpayException {
			    Customer customer = (Customer) session.getAttribute("customer");
			        if (customer != null) {
			        	
			           return service.viewCart(customer,session, map);
			        } else {
			            map.put("neg", "Invalid Session");
			            return "Customer";
			        }
			    }
	
	@PostMapping("/payment/{id}")
    public String checkPayment(@RequestParam String razorpay_payment_id,@PathVariable int id,ModelMap modelMap,HttpSession session) {
    Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			return service.checkPayment(razorpay_payment_id,session,id, customer, modelMap);
		} else {
			modelMap.put("neg", "Invalid Session");
			return "Main";
		}
    }
	
	 @GetMapping("/fetch-orders")
	    public String fetchOrders(HttpSession session, ModelMap modelMap){
	         Customer customer = (Customer) session.getAttribute("customer");
			if (customer != null) {
				return service.fetchOrders(modelMap,session,customer);
			} else {
				modelMap.put("neg", "Invalid Session");
				return "Main";
			}
	    }
 
}
