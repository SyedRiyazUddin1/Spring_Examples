package com.myspringboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspringboot.exceptionhandling.ServiceException;
import com.myspringboot.model.Product;
import com.springboot.service.ExternalService;

@Controller
@RequestMapping("/myapp")
public class ExternalServiceController {

	@Autowired
	ExternalService externalService;

	// get All products
	@RequestMapping("/viewProducts-page")
	public String getAllProducts(Model model) {
		List<Product> list = externalService.getAllProducts();
		model.addAttribute("list", list);
		return "viewProducts-page";
	}

	// fetch the product by id
	@RequestMapping(value = "/products/{id}")
	public Product getProductById(@PathVariable String id) throws ServiceException {

		Product product = externalService.getProductById(id);

		if (product == null) {
			throw new ServiceException("Product details not found: " + id, HttpStatus.CONFLICT.value());
		} else {
			return product;
		}

	}

	/* It displays a page where we can add the products */

	@RequestMapping("/addProduct")
	public String addProduct(@ModelAttribute("userReg") Product product) {
		return "addProduct-page";
	}

	/* It adds the products into the database */
	@RequestMapping("/registration-success")
	public String processUserRegistration(@ModelAttribute("userReg") Product product) throws ServiceException {

		if (product.getName() == null || product.getName().isEmpty()) {
			throw new ServiceException("Product Name should not be empty or null", HttpStatus.BAD_REQUEST.value());
		}

		else {
			externalService.addProduct(product);
			return "registration-success";
		}
	}

	@RequestMapping(value = "/editProduct/{id}")
	public String edit(@PathVariable String id, Model model) {
		Product product = externalService.getProductById(id);
		model.addAttribute("command", product);
		return "editProduct";
	}

	/* It updates model object. */
	@RequestMapping(value = "/editProduct", method = RequestMethod.GET)
	public String updateProduct(@ModelAttribute("product") Product product) {
		externalService.updateProduct(product);
		return "redirect:/myapp/viewProducts-page";
	}

	/* It deletes record for the selected id and redirects to /viewProducts-page */
	@RequestMapping(value = "/deleteProduct/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable String id) {
		externalService.deleteProduct(id);
		return "redirect:/myapp/viewProducts-page";

	}

	/* It displays/fetch the updated database table without EDIT/DELETE option */
	@RequestMapping("/viewWithoutEdit")
	public String viewWithoutEdit(Model model) {
		List<Product> list = externalService.getAllProducts();
		model.addAttribute("list", list);
		return "viewWithoutEdit";

	}

}
