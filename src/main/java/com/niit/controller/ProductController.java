
package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;

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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.ShopBackEndd.Dao.CategoryDAO;
import com.niit.ShopBackEndd.Dao.ProductDAO;
import com.niit.ShopBackEndd.Domain.Category;
import com.niit.ShopBackEndd.Domain.Product;

@Controller
public class ProductController {

	// create product
	// update product
	// delete product
	// fetch all products
	// fetch all categories

	private static Logger log = LoggerFactory.getLogger(ProductController.class);

	@Autowired
	ProductDAO productDAO;

	@Autowired
	Product product;

	@Autowired
	CategoryDAO categoryDAO;

	@Autowired
	Category category;

	@Autowired
	HttpSession session;

	// create product

	@RequestMapping(value="/manage_product_add", method=RequestMethod.POST)
	public ModelAndView createProduct(@RequestParam("file") MultipartFile file, @RequestParam("brand") String brand,
			@RequestParam("name") String name, @RequestParam("price") double price,
			@RequestParam("description") String description, @RequestParam("category_id") long category_id) {
		log.debug("Starting of the method createProduct");
		category = categoryDAO.getCategoryByID(category_id);
		// category.setId(category_id);
		// product.setId(id);
		product.setProduct_Name(name);
		product.setPrice(price);
		product.setBrand(brand);
		product.setProduct_Description(description);

		product.setCategory(category);
		String path= "C://Users//monster//Documents//BeastNutrition//ShopFrontEnd//src//main//webapp//resources//img";
		//String path = session.getServletContext().getRealPath("/");
		
		String filename = name+".jpg";
		//String filename = file.getOriginalFilename();

		System.out.println(path + " " + filename);
		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(path + "/" + filename));
			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		ModelAndView mv = new ModelAndView("Home");

		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("isAdmin", "true");

		/*
		 * Before calling the save method check whether save method is exist in
		 * db or not if it is does not exist, then only call save method
		 */

		if (productDAO.getProductByName(name) != null) // check whether product
														// already exist or not
		{

			mv.addObject("message", "Product Already Exist with the name ");

			return mv;

		} else // actually else is not required if return statement is there in
				// if condition
		{

			productDAO.createProduct(product);
			mv.addObject("message", "Product Created Successfully");
		}

		session.setAttribute("categoryList", categoryDAO.list());
		session.setAttribute("category", category);
		session.setAttribute("productList", productDAO.list());
		session.setAttribute("product", product);

		return mv;
	}

	// delete product

	@RequestMapping("/manage_product_delete/{id}") // attached to url with path
													// variable
	public ModelAndView deleteProduct(@PathVariable("id") long id) {

		ModelAndView mv = new ModelAndView("redirect:/manageProducts");

		mv.addObject("message", "SuccessFully Deleted Product");
		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("isAdmin", "true");

		product = productDAO.get(id);

		if (productDAO.deleteProduct(product) == true) {
			mv.addObject("message", " Successfully deleted the product");
		} else {
			mv.addObject("message", "Not able to Delete the Product");
		}

		session.setAttribute("productList", productDAO.list());
		session.setAttribute("product", product);

		log.debug("Ending of the method delete Product");

		return mv;
	}

	/*------------------------------------Edit Product -----------------------------------*/

	@RequestMapping("/manage_product_edit/{id}")
	public ModelAndView editProduct(@PathVariable("id") long id) {
		log.debug("Starting of method Edit Products");

		log.debug("Going to Edit the Product : " + id);

		product = productDAO.get(id);

		/*
		 * selected product details stored in another instance in ModelAndView
		 * instance
		 */

		ModelAndView mv = new ModelAndView("forward:/manageProducts");

		mv.addObject("selectedProduct", product);
		mv.addObject("isAdmin", "true");

		log.debug("Ending of the method Edit Product");

		return mv;
	}

	/*-----------------------------------Update Product ------------------------------------------*/

	@RequestMapping("/manage_product_edit/manage_product_update")
	public ModelAndView updateProduct(@RequestParam("id") long id, @RequestParam("brand") String brand,
			@RequestParam("name") String name, @RequestParam("price") double price,
			@RequestParam("description") String description) {
		log.debug("Starting of the method updateProduct");

		log.debug("Going to edit the product : " + id);

		product.setProduct_Id(id);
		product.setProduct_Name(name);
		product.setBrand(brand);
		product.setPrice(price);
		product.setProduct_Description(description);

		ModelAndView mv = new ModelAndView("redirect:/manageProducts");

		mv.addObject("isAdminClickedProducts", "true");
		mv.addObject("isAdmin", "true");

		/*
		 * Before calling the update method check whether id is exist in db or
		 * not if it is exist, then only call update method
		 */

		if (productDAO.get(id) == null) {
			log.debug("Product does not Exist with  in Database");

			mv.addObject("message", "Product does not Exist with the id " + id); // product
																					// does
																					// not
																					// exist
			return mv;
		} else // actually else is not required if return statement is there in
				// if condition
		{
			productDAO.updateProduct(product);
			mv.addObject("message", "Product Updated Successfully with id :" + id);
			log.debug("Product Updated Successfully");
		}

		session.setAttribute("productList", productDAO.list());
		session.setAttribute("product", product);

		log.debug("Ending of the method  updateProduct");

		return mv;
	}


	@RequestMapping(value="/select_category", method=RequestMethod.GET)
	public ModelAndView selectCategory(@RequestParam("category_id") long id)
	{
		System.out.println("inside category selection");
		category=categoryDAO.getCategoryByID(id);
		System.out.println("1111inside category selection2");
		ModelAndView mv1=new ModelAndView("Home");
		session.setAttribute("categorisedPlist", productDAO.getProductsByCategory(category));
		session.setAttribute("product", product);
		mv1.addObject("isUserSelectedCategory","true");
		System.out.println("2222inside category selection2");

		return mv1;		
	}
	
	
	@RequestMapping("category_selection/{category_id}")
	public ModelAndView categorySelection(@PathVariable("category_id") long id)
	{
		System.out.println("inside category selection..id="+id);
		category=categoryDAO.getCategoryByID(id);
		System.out.println("1111inside category selection2");
		ModelAndView mv1=new ModelAndView("Home");
		session.setAttribute("categorisedPlist", productDAO.getProductsByCategory(category));
		session.setAttribute("product", product);
		mv1.addObject("isUserSelectedCategory","true");
		System.out.println("2222inside category selection2");

		return mv1;		
	}
	
/*	@RequestMapping("/product_details")
	public ModelAndView productDetails(@RequestParam("id") long id)
	{
		ModelAndView mv=new ModelAndView("Home");
		System.out.println("inside product details "+id);
		product=productDAO.get(id);
		session.setAttribute("selectedProduct",product);
		mv.addObject("isProductDetails", "true");
		return mv;
	}
	*/
	
	@RequestMapping("/Product_detail/{id}")
	public ModelAndView productDetails(@PathVariable("id") long id)
	{
		ModelAndView mv=new ModelAndView("redirect:/Home");
		System.out.println("inside product details "+id);
		product=productDAO.get(id);
		session.setAttribute("selectedProduct",product);
		mv.addObject("isProductDetails", "true");
		return mv;
	}
}