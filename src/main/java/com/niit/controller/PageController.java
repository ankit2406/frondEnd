package com.niit.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.ShopBackEndd.Dao.ProductDAO;
import com.niit.ShopBackEndd.Dao.UserDAO;
import com.niit.ShopBackEndd.Domain.User;

@Controller
public class PageController
{
	
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	UserDAO userDAO;
	
	/*@RequestMapping(value = { "/", "/index", "/home" })
	public String index(Principal principal, Model model) {

		if (principal != null) {
			User user = userDAO.getUserByEmail(principal.getName());
			if (user.getRole().equalsIgnoreCase("ADMIN")) {
				return "redirect:/admin/adminIndex";
			} else if (user.getRole().equalsIgnoreCase("CUSTOMER")) {
				return "redirect:/user/index";
			}
		}
		return "index";
	}
	
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("error", "Authentication Failed - Invalid credentials!");
		}
		model.addAttribute("title", "Login");
		return "Login";
	}*/
}
