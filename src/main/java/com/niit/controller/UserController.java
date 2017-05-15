package com.niit.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShopBackEndd.Dao.UserDAO;
import com.niit.ShopBackEndd.Domain.User;

@Controller


public class UserController 
{
	private static Logger log = LoggerFactory.getLogger(UserController.class);
	
	@Autowired User user;
	@Autowired	UserDAO userDAO;
	@Autowired  HttpSession session;
	
	
	@RequestMapping("/validate")
	public ModelAndView login(@RequestParam("email") String email,
			@RequestParam("password") String password) 
	{
		
		ModelAndView mv= new ModelAndView("/Home");
		System.out.println(email+" "+password);
		if (userDAO.validate(email, password)== true)

		{
			
			user = userDAO.getUserByEmail(email);

			mv.addObject("message", "welcome " + user.getName());
			
			if(user.getRole().equals("ADMIN"))
			 {
				 log.debug("You are admin");
				 mv.addObject("isAdmin", "true");
				 session.setAttribute("role", "ADMIN");
				 session.setAttribute("userList", userDAO.list());
			 }
			 else
			 {
				 log.debug("You are buyer");
				 mv.addObject("isAdmin", "false");
				 session.setAttribute("role", "BUYER");
			 }

		} 
		else 
		{

			mv.addObject("message", "Invalid credentials..please try again.");
		}
		return mv;
	}
	
	@RequestMapping("/manage_user_delete/{user_id}")
	public ModelAndView deleteUser(@PathVariable("user_id") long id)
	{
		ModelAndView mv= new ModelAndView("redirect:/manageUsers");
		mv.addObject("isAdmin", "true");
		mv.addObject("isAdminClickedUsers", "true");
		
		if(userDAO.deactivate(userDAO.getUserById(id)))
		{
			 mv.addObject("message", "successfully disabled the user");

		}
		else
		{
			 mv.addObject("message", "Not able to disable the user");

		}
		

		session.setAttribute("userList", userDAO.list());
		session.setAttribute("user", user);
		
		return mv;
	}
	
	@RequestMapping("/manage_logout")
	public ModelAndView logout()
	{
		ModelAndView mv=new ModelAndView("Home");
		session.invalidate();
		return mv;
	}
	
	@RequestMapping("/create_user")
	public ModelAndView createUser(@RequestParam("name")String name, @RequestParam("email")String email,
			@RequestParam("password")String password, @RequestParam("contact")String contact)
	{
		ModelAndView mv=new ModelAndView("Home");
		boolean enabled=true;
		String role="BUYER";
		user.setName(name);
		user.setEmail(email);
		user.setPassword(password);
		user.setContact(contact);
		user.setEnabled(enabled);
		user.setRole(role);
		
		if(userDAO.save(user))
		{
			mv.addObject("message","user created successfully");
			return mv;
		}
		else
		{
			mv.addObject("message","Error creating in user");
			return mv;
		}
	}
	
}
