package com.niit.controller;

import java.security.Principal;
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
import com.niit.ShopBackEndd.Dao.UserDAO;
import com.niit.ShopBackEndd.Domain.Product;
import com.niit.ShopBackEndd.Domain.User;

@Controller
public class HomeController 
{
	

	@Autowired HttpSession session;
	
	@Autowired  Category category;
	
	@Autowired  CategoryDAO  categoryDAO;
	
	@Autowired User user;
	@Autowired	UserDAO userDAO;
	@Autowired Product product;
	@Autowired ProductDAO productDAO;
	
	@RequestMapping("/")
	public  ModelAndView    goToHome(Principal principal) 
	{
		ModelAndView mv = new ModelAndView("Home");
		//model.addAttribute("message", "Thank you for visiting Shopping Cart");
		try{
				
		if((principal.getName())!=null)
		{	
			user=userDAO.getUserByEmail(principal.getName());
			if((user.getRole()).equals("ROLE_ADMIN"))
			{
			mv.addObject("isAdmin", "true");
			session.setAttribute("userList", userDAO.list());
			}

			else{
				System.out.println("inside home check");
			Product p=null;
			List<Product> pList= new LinkedList<Product>();
			pList.add(productDAO.get(251));
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
			mv.addObject("HomePage","true");
			mv.addObject("HotList", pList);
			//attach to session
			}
			session.setAttribute("categoryList", categoryDAO.list());
			session.setAttribute("category", category);
			
			session.setAttribute("product", product);
			session.setAttribute("productList", productDAO.list());
			return mv;
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
			
		System.out.println("outside else");
		Product p=null;
		List<Product> pList= new LinkedList<Product>();
		pList.add(productDAO.get(251));
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
		mv.addObject("HomePage","true");
		mv.addObject("HotList", pList);
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

	@RequestMapping("/index")
	public  ModelAndView    goToIndex()
	
	{
		ModelAndView mv = new ModelAndView("Home");
		//model.addAttribute("message", "Thank you for visiting Shopping Cart");
		
		
		Product p=null;
		List<Product> pList= new LinkedList<Product>();
		pList.add(productDAO.get(251));
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
		mv.addObject("HomePage","true");
		mv.addObject("HotList", pList);
		//attach to session
		
		
		
		return mv;
		
		//return "Home"
	}
	
	@RequestMapping("/NoLogin")
	public String askToLogin(Model mv)
	{
		mv.addAttribute("message","Please login to buy");
		mv.addAttribute("isUserClickedLogin","true");
		return "Home";
		
	}
}