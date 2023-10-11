package org.efood.restraunt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.efood.restraunt.dao.CustomerDao;
import org.efood.restraunt.dao.ProductDao;
import org.efood.restraunt.dto.AddProduct;
import org.efood.restraunt.dto.Cart;
import org.efood.restraunt.dto.Customer;
import org.efood.restraunt.dto.CustomersFood;
import org.efood.restraunt.dto.Payment;
import org.efood.restraunt.helper.AES;
import org.efood.restraunt.helper.LoginHelper;
import org.efood.restraunt.helper.SendMailLogic;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.servlet.http.HttpSession;

@Service
@Component
public class CustomerService {

	@Autowired
	CustomerDao dao;

	@Autowired
	SendMailLogic logic;

	@Autowired
	ProductDao productDao;

	public String register(Customer customer, ModelMap map) {
		Customer customer1 = dao.fetchByEmail(customer.getEmail());
		Customer customer2 = dao.fetchByMobile(customer.getMobile());
		if (customer1 == null && customer2 == null) {
			int otp = new Random().nextInt(100000, 999999);
			customer.setOtp(otp);
			logic.send(customer);
			customer.setPassword(AES.encrypt(customer.getPassword(), "123"));
			dao.save(customer);
			map.put("id", customer.getId());
			return "CustomerVerifyOtp";
		} else {
			map.put("neg", "Email and Phone Number Should not be repeated");
			return "CustomerRegister";
		}
	}

	public String verifyOtp(int id, int otp, ModelMap map) {
		Customer customer = dao.fetchById(id);
		if (customer.getOtp() == otp) {
			customer.setStatus(true);
			dao.save(customer);
			map.put("pos", "Otp verify Successfully");
			return "Customer";
		} else {
			map.put("neg", "Otp mismatch");
			map.put("id", customer.getId());
			return "CustomerVerifyOtp";
		}
	}

	public String login(LoginHelper helper, ModelMap map, HttpSession session) {
		Customer customer = dao.fetchByEmail(helper.getEmail());
		if (customer == null) {
			map.put("neg", "Invalid Email");

			return "Customer";
		} else if (AES.decrypt(customer.getPassword(), "123").equals(helper.getPassword())) {
			map.put("pos", "Login Success");
			session.setAttribute("customer", customer);
			return "CustomerHome";
		} else {
			map.put("neg", "Invalid Password");
			return "Customer";
		}
	}

	public String fetchProducts(Customer customer, HttpSession session, ModelMap map) {
		List<AddProduct> products = productDao.getProduct();
		if (products == null || products.isEmpty()) {

			map.put("neg", "no product");
			return "CustomerHome";
		} else {
			map.put("products", products);
			return "CustomerItems";
		}
	}

	public String cartAdd(int id, HttpSession session, ModelMap map, Customer customer) {
		AddProduct product = productDao.findById(id);
		if (product != null) {
			if (product.getStock() > 0) {
				Cart cart = customer.getCart();
				if (cart == null)
					cart = new Cart();
				List<CustomersFood> customersFood = cart.getCustomersFoods();
				if (customersFood == null)
					customersFood = new ArrayList<CustomersFood>();
				boolean flag = true;
				for (CustomersFood customerFood : customersFood) {
					if (customerFood.getName().equals(product.getName())) {
						customerFood.setQuatity(customerFood.getQuatity() + 1);
						customerFood.setPrice(customerFood.getPrice() + product.getPrice());
						flag = false;
						break;
					}
				}
				if (flag) {
					CustomersFood customerFood = new CustomersFood();
					customerFood.setName(product.getName());
					customerFood.setDescription(product.getDescription());
					customerFood.setImage(product.getImage());
					customerFood.setPrice(product.getPrice());
					customerFood.setQuatity(1);
					customersFood.add(customerFood);
					cart.setCustomersFoods(customersFood);
				}
				customer.setCart(cart);
				dao.save(customer);
				session.setAttribute("customer", dao.fetchById(customer.getId()));
				product.setStock(product.getStock() - 1);
				productDao.save(product);
				map.put("pos", "Food Added to Cart");
			} else {
				map.put("neg", "Out Of Stock");

			}
			return fetchProducts(dao.fetchById(customer.getId()), session, map);
		} else {
			map.put("neg", "Something went wrong");
			return "Main";
		}
	}


	public String cartRemove(int id, HttpSession session, ModelMap map, Customer customer) {
		AddProduct product = productDao.findById(id);
		if (product != null) {
			Cart cart = customer.getCart();
			if (cart == null) {
				map.put("neg", "No Items in Cart");
				return fetchProducts(dao.fetchById(customer.getId()), session, map);
			} else {
				List<CustomersFood> customersFood = cart.getCustomersFoods();
				if (customersFood == null) {
					map.put("neg", "No Items in Cart");
					return fetchProducts(dao.fetchById(customer.getId()), session, map);
				} else {
					CustomersFood customerFood = null;
					for (CustomersFood customerFood1 : customersFood) {
						if (product.getName().equals(customerFood1.getName())) {
							customerFood = customerFood1;
							break;
						}
					}
					if (customerFood == null) {
						map.put("neg", "No Items in Cart");
						return fetchProducts(dao.fetchById(customer.getId()), session, map);
					} else {
						if (customerFood.getQuatity() > 1) {
							customerFood.setQuatity(customerFood.getQuatity() - 1);
							customerFood.setPrice(customerFood.getPrice() - product.getPrice());
							product.setStock(product.getStock() + 1);
							productDao.save(product);
							productDao.save(customerFood);
						} else {
							customersFood.remove(customerFood);
							product.setStock(product.getStock() + 1);
							productDao.save(product);
							productDao.save(cart);
							productDao.delete(customerFood);
						}
						map.put("pos", "Item removed from Cart");
						session.setAttribute("customer", dao.fetchById(customer.getId()));
						return fetchProducts(dao.fetchById(customer.getId()), session, map);
					}
				}
			}
		} else {
			map.put("neg", "Something went Wrong");
			return "Main";
		}
	}

	public String viewCart(Customer customer, HttpSession session, ModelMap map) throws RazorpayException {
		Cart cart=customer.getCart();
		if(cart==null) {
			map.put("neg", "No Items in Cart");
			return fetchProducts(dao.fetchById(customer.getId()), session, map);
		}else {
			List<CustomersFood>  customersFood = cart.getCustomersFoods();
			if ( customersFood == null ||  customersFood.isEmpty()) {
				map.put("neg", "No Items in Cart");
				return fetchProducts( dao.fetchById(customer.getId()),session,map);
			} else {
				boolean flag = true;
				for (CustomersFood customerFood : customersFood) {
					if (customerFood.getQuatity() > 0)
						flag = false;
					break;
				}
				if (flag) {
					map.put("neg", "No Items in Cart");
					return fetchProducts( dao.fetchById(customer.getId()),session,map);
				} else {
					double amount = 0;
					for (CustomersFood customerFood : customersFood) {
						amount = amount + customerFood.getPrice();
					}

			
			JSONObject object=new JSONObject();
			object.put("amount", (int) (amount * 100));
			object.put("currency", "INR");
			RazorpayClient client=new RazorpayClient("rzp_test_7OqFJdfeYiQEuQ","bq2NzTmkKEaZv2L3c6zeXCNU");
		       Order order =client.orders.create(object);
		       Payment payment=new Payment();
		       payment.setOrderId(order.get("id").toString());
		       payment.setAmount(order.get("amount").toString());
		       payment.setCurrency(order.get("currency").toString());
		       payment.setPaymentId(null);
		       payment.setStatus(order.get("status"));
		       payment.setKeyDetails("rzp_test_7OqFJdfeYiQEuQ");
		       
		       productDao.save(payment);
		       map.put("details", payment);
		       session.setAttribute("customer", dao.fetchById(customer.getId()));
		       
		}}
		return "ViewCart";
	}}}
	
