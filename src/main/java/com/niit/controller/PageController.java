package com.niit.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

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
	
	@RequestMapping("/aboutUs")
	public String about_us(Model mv)
	{
		mv.addAttribute("isAboutUs", "true");
		return "Home";
	}
	
	@RequestMapping("/contactUs")
	public String contact_us(Model mv)
	{
		mv.addAttribute("isContactUs", "true");
		return "Home";
	}
	/*
	
	@RequestMapping(value = { "/", "/index", "/Home" })
	public String index(Principal principal, Model model) {

		if (principal != null) {
			User user = userDAO.getUserByEmail(principal.getName());
			if (user.getRole().equalsIgnoreCase("ADMIN")) {
				return "redirect:/admin/adminIndex";
			} else if (user.getRole().equalsIgnoreCase("CUSTOMER")) {
				return "redirect:/user/index";
			}
		}
		return "/Home";
	}
	*/
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, Model model) {
		if (error != null) {
			model.addAttribute("error", "Authentication Failed - Invalid credentials!");
		}
		model.addAttribute("title", "Login");
		return "Login";
	}
	
	@RequestMapping(value="/mng_logout", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    if (auth != null){    
	        new SecurityContextLogoutHandler().logout(request, response, auth);
	    }
	    return "redirect:/login?logout";//You can redirect wherever you want, but generally it's a good practice to show login screen again.
	}
	
	@RequestMapping("passwordUpdate")
	public ModelAndView passwordUpdate()
	{
		ModelAndView mv=new ModelAndView("Home");
		mv.addObject("IsPasswordChange", "true");
		return mv;
	}
}
