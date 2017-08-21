package com.niit.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShopBackEndd.Dao.CategoryDAO;
import com.niit.ShopBackEndd.Dao.ProductDAO;
import com.niit.ShopBackEndd.Dao.UserDAO;
import com.niit.ShopBackEndd.Domain.Category;
import com.niit.ShopBackEndd.Domain.Product;
import com.niit.ShopBackEndd.Domain.User;

@Controller

public class UserController {
	private static Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	User user;
	@Autowired
	UserDAO userDAO;
	@Autowired
	HttpSession session;
	@Autowired
	Category category;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Product product;
	@Autowired
	ProductDAO productDAO;

	@RequestMapping("/validates")
	public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView("/Home");
		System.out.println(email + " " + password);
		if (userDAO.validate(email, password) == true)

		{

			user = userDAO.getUserByEmail(email);


			if (user.getRole().equals("ADMIN")) 
			{
				log.debug("You are admin");
				mv.addObject("isAdmin", "true");
				session.setAttribute("role", "ADMIN");
				session.setAttribute("userList", userDAO.list());
			}
			else 
			{
				Product p;
				List<Product> pList= new LinkedList<Product>();
				pList.add(productDAO.get(251));
				pList.add(productDAO.get(242));
				pList.add(productDAO.get(239));
				pList.add(productDAO.get(232));
				pList.add(productDAO.get(67));
				pList.add(productDAO.get(102));
				pList.add(productDAO.get(235));
				pList.add(productDAO.get(237));
				pList.add(productDAO.get(240));
				
				Iterator<Product> itr=pList.iterator();  
				 while(itr.hasNext())
				 {  
					 p=itr.next();
				  // System.out.println(p.getProduct_Name());
				 }
				log.debug("You are buyer");
				mv.addObject("isAdmin", "false");
				mv.addObject("HomePage","true");
				session.setAttribute("role", "BUYER");
				mv.addObject("HotList", pList);

			}
			session.setAttribute("userId", user.getUser_id());
			session.setAttribute("uname", user.getName());

		} else {

			mv.addObject("message", "Invalid credentials..please try again.");
		}
		return mv;
	}

	@RequestMapping("/manage_user_delete/{user_id}")
	public ModelAndView deleteUser(@PathVariable("user_id") long id) {
		ModelAndView mv = new ModelAndView("redirect:/manageUsers");
		mv.addObject("isAdmin", "true");
		mv.addObject("isAdminClickedUsers", "true");

		if (userDAO.deactivate(userDAO.getUserById(id))) {
			mv.addObject("message", "successfully disabled the user");

		} else {
			mv.addObject("message", "Not able to disable the user");

		}

		session.setAttribute("userList", userDAO.list());
		session.setAttribute("user", user);

		return mv;
	}

	@RequestMapping("/manage_logout")
	public ModelAndView logout() {
		ModelAndView mv = new ModelAndView("Home");
		session.invalidate();
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);

		session.setAttribute("product", product);
		session.setAttribute("productList", productDAO.list());
		return mv;
	}

	@RequestMapping("/create_user")
	public ModelAndView createUser(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("password") String password, @RequestParam("contact") String contact) {
		ModelAndView mv = new ModelAndView("Home");
		boolean enabled = true;
		String role = "BUYER";
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setContact(contact);
		user.setEnabled(enabled);
		user.setRole(role);

		if (userDAO.save(user)) {
			mv.addObject("message", "user created successfully");
			return mv;
		} else {
			mv.addObject("message", "Error creating in user");
			return mv;
		}
	}
	
	@RequestMapping("account_details/{userId}")
	public ModelAndView userDetails(@PathVariable("userId") long id) throws UnsupportedEncodingException
	{
		System.out.println("user id is"+id);
		
		user=userDAO.getUserById(id);
		ModelAndView mv = new ModelAndView("/Home");
		mv.addObject("userDetail",user);
		mv.addObject("userDetails", "true");
		return mv;
	}

}
