package com.niit.controller;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShopBackEndd.Domain.Category;

import com.niit.ShopBackEndd.Dao.CategoryDAO;
import com.niit.ShopBackEndd.Dao.ProductDAO;
import com.niit.ShopBackEndd.Domain.Product;

@Controller
public class HomeController 
{
	

	@Autowired HttpSession session;
	
	@Autowired  Category category;
	
	@Autowired  CategoryDAO  categoryDAO;
	
	@Autowired Product product;
	@Autowired ProductDAO productDAO;
	
	@RequestMapping("/")
	public  ModelAndView    goToHome()
	
	{
		ModelAndView mv = new ModelAndView("Home");
		//model.addAttribute("message", "Thank you for visiting Shopping Cart");
		mv.addObject("message", "Thank you for visiting Shopping Cart");
		
		
		
		//attach to session
		
		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);
		
		session.setAttribute("product", product);
		session.setAttribute("productList", productDAO.list());
		
		
		return mv;
		
		//return "Home"
	}
	
	/*
	 @requestMapping("/login")
	 public String login(@RequestParam(Value="error", required=false)String error,Model model)
	 if(error != null)
	 {
	 	model.addAttribute("error", "Authentication Failed : Invalid Credential");
	 }
	 model.addAttribute("title", "Login");
	 return mv;
	 }
	 */
	@RequestMapping("/LoginPage")
	public String loginPage(Model model)
	{
		model.addAttribute("isUserClickedLogin", "true");
	
		return "Home";
	}
	
	@RequestMapping("/RegistrationPage")
	public String registrationPage(Model model)
	{
		model.addAttribute("isUserClickedRegister", "true");
		
		return "Home";
	}
	
	@RequestMapping("/HelpPage")
	public String HelpPage(Model model)
	{
		model.addAttribute("isUserClickedHelp", "true");
		
		return "Home";
	}
	
	@RequestMapping("/categoryPage")
	public String categoryPage(Model model)
	{
		model.addAttribute("isUserClickedCategory", "true");
		return "Home";
	}

	
	
}