package com.niit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShopBackEndd.Dao.CartDAO;
import com.niit.ShopBackEndd.Dao.CartItemDAO;
import com.niit.ShopBackEndd.Dao.ProductDAO;
import com.niit.ShopBackEndd.Dao.UserDAO;
import com.niit.ShopBackEndd.Domain.Cart;
import com.niit.ShopBackEndd.Domain.CartItem;
import com.niit.ShopBackEndd.Domain.Product;
import com.niit.ShopBackEndd.Domain.User;

@Controller
public class CartController {

	Logger log = LoggerFactory.getLogger(CartController.class);

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
	private Product product;

	@Autowired
	private HttpSession session;


	@RequestMapping("/Cart_add/{id}")
	public ModelAndView addToCart(@PathVariable("id") long pid) {
		System.out.println("id is" + pid);
		log.debug("Starting of the method addToCart");
		// get the product based on product id
		
		long loggedInUserid = ((Number) session.getAttribute("userId")).longValue();// (long)
		user = userDAO.getUserById(loggedInUserid);
		cart = user.getCart();
		product = productDAO.get(pid);
		System.out.println("userid is"+loggedInUserid+" product id"+pid);
		
		if(cartItemDAO.getCartItemByUserIdAndProductId(cart, product)!=null)
		{
			cartItem=cartItemDAO.getCartItemByUserIdAndProductId(cart, product);
			System.out.println("cartItem id"+cartItem.getCartItem_Id());
			int oldQuantity = cartItem.getSell_quantity();
			
			cart=cartItem.getCart();
			cartItem.setSell_quantity(cartItem.getSell_quantity()+1);
			cartItem.setTotal_price((int) (product.getPrice() * cartItem.getSell_quantity()));
			System.out.println(cartItem.getTotal_price());
			cart.setGrandTotal((int) (cart.getGrandTotal() + (cartItem.getSell_quantity()- oldQuantity)*product.getPrice()));
			//cart.getGrandTotal()+(cartItem.getSell_quantity()- oldQuantity)*product.getPrice()
			cart.setCartItemCount(cart.getCartItemCount() + 1);
			
			//cartItem.setCart(cart);
			System.out.println(cart.getGrandTotal());
			cartItemDAO.updateCartItem(cartItem);

		}
		
		else
		{
			cartItem=new CartItem();
			System.out.println("inside else of cartcontroller add");
			cartItem.setSell_quantity(1);
			cartItem.setProduct(product);
			cartItem.setTotal_price((int) (product.getPrice() * cartItem.getSell_quantity()));
			System.out.println("quantity"+cartItem.getSell_quantity());
			cart.setGrandTotal(cart.getGrandTotal() + cartItem.getTotal_price());
			cart.setCartItemCount(cart.getCartItemCount() + 1);
			cartItem.setCart(cart);
			System.out.println(cart.getCartItemCount()+" "+cart.getGrandTotal());
			cartItemDAO.addCartItem(cartItem);
		}
		//cartItem=new CartItem();
			
		
		
		
		// session.getAttribute("userId");
		


		/*
		 * if (loggedInUserid == null) { Authentication auth =
		 * SecurityContextHolder.getContext().getAuthentication();
		 * loggedInUserid = auth.getName(); }
		 */

		// It is not required if you given default value while creating the
		// table
		// Status is New. Once it is dispatched, we can
		// changed to 'D'

		// To get sequence number, you can do programmatically in DAOImpl
		// myCart.setId(ThreadLocalRandom.current().nextLong(100, 1000000 + 1));

		// check same product is added earlier.
		/*
		 * if(cartDAO.getCart(loggedInUserid, myCart.getProductName()) !=null) {
		 * //increate the quantity and update it. int presentQuantity =
		 * cartDAO.getQuantity(loggedInUserid, myCart.getProductName());
		 * myCart.setQuantity(presentQuantity + 1); cartDAO.update(myCart);
		 * 
		 * } else { cartDAO.save(myCart);
		 * 
		 * 
		 * }
		 */

		// return "redirect:/views/home.jsp";

		//ModelAndView mv = new ModelAndView("redirect:/home");
		ModelAndView mv = new ModelAndView("/Home");

		mv.addObject("message", " Product added to Cart...");
		log.debug("Ending of the method addToCart");
		return mv;

	}

	@RequestMapping(value = "/myCart", method = RequestMethod.GET)
	public String myCart(Model model) {
		log.debug("Starting of the method myCart");
		// get the logged-in user id
		long loggedInUserid = ((Number) session.getAttribute("userId")).longValue();// (long)
																					// session.getAttribute("userId");

		/*
		 * if (loggedInUserid == null) { Authentication auth =
		 * SecurityContextHolder.getContext().getAuthentication();
		 * loggedInUserid = auth.getName(); Collection<GrantedAuthority>
		 * authorities = (Collection<GrantedAuthority>) auth.getAuthorities();
		 * authorities.contains("ROLE_USER");
		 * 
		 * }
		 */

		if (loggedInUserid != 0L) 
		{
			user = userDAO.getUserById(loggedInUserid);
			cart = user.getCart();
			int cartSize = cart.getCartItemCount();

			if (cartSize == 0) 
			{
				model.addAttribute("errorMessage", "You do not have any products in your Cart");
			} 
			else 
			{
				model.addAttribute("cartList", cartItemDAO.cartItemGetByCart(cart));
				model.addAttribute("totalAmount", cart.getGrandTotal());
				model.addAttribute("displayCart", "true");
				model.addAttribute("cart", cart);

			}
			model.addAttribute("isUserClickedCart","true");

		}
		log.debug("Ending of the method myCart");
		return "/Home";
	}
	
	@RequestMapping("/cart_delete/{id}")
	public String delCart(Model model,@PathVariable("id") long id)
	{
		long loggedInUserid = ((Number) session.getAttribute("userId")).longValue();// (long)
		System.out.println(loggedInUserid+" "+id);
		user = userDAO.getUserById(loggedInUserid);
		System.out.println(user.getName());
		 cart  = user.getCart();
		 int oldCartQty=cart.getCartItemCount();
		 int oldCartTotal=cart.getGrandTotal();
		 System.out.println(cart.getCart_Id());
		 product = productDAO.get(id);
		 // System.out.println(product.getProduct_Name());
		
		cartItem=cartItemDAO.getCartItemByCartItem_Id(id);
		 System.out.println(cartItem.getCartItem_Id());
		cart.setGrandTotal((int) (oldCartTotal - cartItem.getTotal_price()));
		cart.setCartItemCount(oldCartQty - cartItem.getSell_quantity());
		cartItemDAO.deleteCartItem(cartItem);
		cartDAO.updateCart(cart);
		
		/*
		if(loggedInUserid!=0L)
		{
			user = userDAO.getUserById(loggedInUserid);
			cart = user.getCart();
			int oldCartQty=cart.getCartItemCount();
			cartItem=cartItemDAO.getCartItemByCartItem_Id(id);
			cart.setCartItemCount(oldCartQty-cartItem.getSell_quantity());
			cart.setGrandTotal(cart.getGrandTotal()-cartItem.getTotal_price());
			cartItemDAO.deleteCartItem(cartItem);
			
		} */
		model.addAttribute("cartList", cartItemDAO.cartItemGetByCart(cart));
		model.addAttribute("totalAmount", cart.getGrandTotal());
		model.addAttribute("displayCart", "true");
		model.addAttribute("cart", cart);
		model.addAttribute("isUserClickedCart","true");

		return "/Home";
	}
}