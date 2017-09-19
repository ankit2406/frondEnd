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

import com.niit.ShopBackEndd.Dao.CategoryDAO;
import com.niit.ShopBackEndd.Domain.Category;

@Controller
public class CategoryController {

	private static Logger log = LoggerFactory.getLogger(CategoryController.class);

	// create category
	// fetch all categories
	// delete category
	// update category

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;

	@Autowired
	HttpSession session;

	@RequestMapping("/manage_category_add")
	public ModelAndView createCategory(@RequestParam("name") String name) {

		log.debug("Starting of the method manageCategories");
		category.setCategory_name(name);

		ModelAndView mv = new ModelAndView("Home");

		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		// Before calling save method, check whether the category id already
		// exist in db or not

		// if it is does not exist, then only call save method
		/*
		 * if (categorydAO.getCategoryByID(id) !=null) { //category already
		 * exist mv.addObject("message", "Category already exist with teh id "
		 * +id); return mv;
		 * 
		 * }
		 */

		categoryDAO.save(category);
		mv.addObject("message", "Category created successfuly ");

		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);

		log.debug("End of the method manageCategories");

		return mv;

	}

	// delete category

	@RequestMapping("/manage_category_delete/{category_id}")
	public ModelAndView deleteCategory(@PathVariable("category_id") long id) {

		log.debug("Starting of the method deleteCategory");
		log.debug("You are going to delete " + id);
		ModelAndView mv = new ModelAndView("redirect:/manageCategories");

		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");
		if (categoryDAO.deleteById(id)) {
			mv.addObject("message", "successfully deleted the category");
		} else {
			mv.addObject("message", "Not able to delete the category");
		}

		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);

		log.debug("Ending of the method deleteCategory");

		return mv;

	}

	// edit category
	@RequestMapping("/manage_category_edit/{id}")
	public ModelAndView editCategory(@PathVariable("id") long id) {
		//log.debug("Starting of method Edit Categories");

		System.out.println("Going to Edit the Category : " + id);

		category = categoryDAO.getCategoryByID(id);

		/*
		 * selected category details stored in another instance in ModelAndView
		 * instance
		 */

		ModelAndView mv = new ModelAndView("forward:/manageCategories");

		mv.addObject("selectedCategory", category);
		mv.addObject("isAdmin", "true");

		log.debug("Ending of the method Edit Category");

		return mv;
	}

	// category update

	@RequestMapping("/manage_category_edit/manage_category_update")
	public ModelAndView updateCategory(@RequestParam("id") long id, @RequestParam("name") String name) {
		log.debug("Starting of the method updateCategory");

		log.debug("Going to edit the category : " + id);

		category.setCategory_name(name);

		ModelAndView mv = new ModelAndView("redirect:/manageCategories");

		mv.addObject("isAdminClickedCategories", "true");
		mv.addObject("isAdmin", "true");

		/*
		 * Before calling the update method check whether id is exist in db or
		 * not if it is exist, then only call update method
		 */

		if (categoryDAO.getCategoryByID(id) == null) {
			log.debug("Category does not Exist with  in Database");

			mv.addObject("message", "Category does not Exist with the id " + id); // category
																					// does
																					// not
																					// exist
			return mv;
		} 
		else // actually else is not required if return statement is there in
				// if condition
		{
			categoryDAO.update(category);
			mv.addObject("message", "Category Updated Successfully ");
			log.debug("Category Updated Successfully");
		}

		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);

		log.debug("Ending of the method  updateCategory");

		return mv;
	}

}
