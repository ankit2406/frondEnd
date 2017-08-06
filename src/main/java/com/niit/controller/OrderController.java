package com.niit.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShopBackEndd.Dao.CartDAO;
import com.niit.ShopBackEndd.Dao.CartItemDAO;
import com.niit.ShopBackEndd.Dao.OrderDAO;
import com.niit.ShopBackEndd.Dao.ProductDAO;
import com.niit.ShopBackEndd.Dao.UserDAO;
import com.niit.ShopBackEndd.Domain.Cart;
import com.niit.ShopBackEndd.Domain.CartItem;
import com.niit.ShopBackEndd.Domain.OrderDetails;
import com.niit.ShopBackEndd.Domain.Product;
import com.niit.ShopBackEndd.Domain.User;

@Controller
public class OrderController 
{
	@Autowired
	private User user;

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private CartDAO cartDAO;

	@Autowired
	private Cart cart;

	@Autowired
	private CartItem cartItem;
	
	@Autowired
	private CartItemDAO cartItemDAO;

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private OrderDAO orderDAO;

	@Autowired
	private Product product;

	@Autowired
	private HttpSession session;
	
	@RequestMapping("/getOrderData")
	public String getOrderDetails(Model mv)
	{
		//System.out.println("inside ordercontroller");
		//mv.addObject("isUser", "true");
		int shipping;
		long loggedInUserid = ((Number) session.getAttribute("userId")).longValue();// (long)

		user = userDAO.getUserById(loggedInUserid);
		cart = user.getCart();
		int cartSize = cart.getCartItemCount();
		if(cart.getGrandTotal()<500)
		{
			shipping=50;
		}
		else
		{
			shipping=0;
		}
		mv.addAttribute("cartList", cartItemDAO.cartItemGetByCart(cart));
		mv.addAttribute("totalAmount", cart.getGrandTotal());
		mv.addAttribute("isUserClickedCheckout", "true");
		mv.addAttribute("totalQty", cart.getCartItemCount());
		mv.addAttribute("shipping",shipping);
		return "/Home";
		
	}
	
	@RequestMapping("setOrderDetails")
	public String setOrderDetails(Model mv, String fname, String lname, String phone, String address,String qty,
											String city,String state, String pincode, String shippingCharge, String orderTotal)
	{
		//System.out.println(fname);
		long loggedInUserid = ((Number) session.getAttribute("userId")).longValue();// (long)
		user=userDAO.getUserById(loggedInUserid);
		System.out.println(loggedInUserid);
		LocalDateTime datetime1 = LocalDateTime.now();  
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
		String orderDate = datetime1.format(format);  
		System.out.println(orderDate+" "+qty+" "+shippingCharge+" "+orderTotal);
		
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setFname(fname);
		orderDetails.setLname(lname);
		orderDetails.setContact(phone);
		orderDetails.setAddress(address);
		orderDetails.setCity(city);
		orderDetails.setState(state);
		orderDetails.setPin(pincode);
		orderDetails.setOrderDate(orderDate);
		orderDetails.setShipping(Integer.parseInt(shippingCharge));
		orderDetails.setOrderTotal(Integer.parseInt(orderTotal));
		orderDetails.setQty(Integer.parseInt(qty));
		orderDetails.setUser(user);
		orderDAO.createOrder(orderDetails);
			
		
		mv.addAttribute("message", " Order placed successfully");
		
		return "/Home";
	}
}
