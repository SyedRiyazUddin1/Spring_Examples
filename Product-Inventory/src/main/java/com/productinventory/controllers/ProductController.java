package com.productinventory.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.productinventory.model.Product;
import com.productinventory.service.ProductService;


@Controller
public class ProductController {

	@Autowired
	ProductService productService;

	
	/* It displays a page where we can add the products   */
	
	@RequestMapping("/addProduct")
	public String addProduct(@ModelAttribute("userReg") Product product) {

		return "addProduct-page";
	}

	/* It adds the products into the database with addition of tax in the finalPrice   */
	@RequestMapping("/registration-success")
	public String processUserRegistration(@ModelAttribute("userReg") Product product) {

		productService.addProduct(product);

		return "registration-success";
	}

	/* It displays/fetch the updated database table*/
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
	
	
	 /* It deletes record for the given id in URL and redirects to /viewProducts-page */    
    @RequestMapping(value="/deleteProduct/{productId}",method = RequestMethod.GET)    
    public String delete(@PathVariable int productId){    
       productService.deleteProduct(productId);   
        return "redirect:/viewProducts-page";    
 
        
    }
    
    
    /* It displays/fetch the updated database table without EDIT/DELETE option*/
	@RequestMapping("/viewWithoutEdit")
	public String viewWithoutEdit(Model model) {
		List<Product> list = productService.getProducts();
		model.addAttribute("list", list);
		return "viewWithoutEdit";

	}
}
