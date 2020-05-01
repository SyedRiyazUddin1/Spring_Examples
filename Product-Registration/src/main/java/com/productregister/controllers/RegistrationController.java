package com.productregister.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.productregister.api.Product;
import com.productregister.service.ProductService;

@Controller
public class RegistrationController {

	@Autowired
	ProductService productService;

	@RequestMapping("/register")
	public String addProduct(@ModelAttribute("userReg") Product product) {

		return "addProduct-page";
	}

	@RequestMapping("/registration-success")
	public String processUserRegistration(@ModelAttribute("userReg") Product product) {

		productService.addProduct(product);

		return "registration-success";
	}


	@RequestMapping("/viewProducts-page")
	public String viewProducts(Model model) {
		List<Product> list = productService.getProducts();
		model.addAttribute("list", list);
		return "viewProducts-page";

	}
	
	/* It displays object data into form for the given id.   
     * The @PathVariable puts URL data into variable.*/  
	
    @RequestMapping(value="/editProduct/{productId}")    
    public String edit(@PathVariable int productId, Model model){    
        Product product= productService.getProductById(productId);    
        model.addAttribute("command",product);  
        return "editProduct";    
    }    
	
	  /* It updates model object. */    
	@RequestMapping(value="/editProduct",method = RequestMethod.GET)    
    public String editProduct(@ModelAttribute("product") Product product){    
       productService.editProduct(product);   
        return "redirect:/viewProducts-page";    
    }
}
