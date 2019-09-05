package com.enlamesa.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.enlamesa.back.model.Product;
import com.enlamesa.back.service.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController {

	
	@Autowired
	private ProductService productService;
	
	
	@RequestMapping(method= RequestMethod.GET)
	public List<Product> getProducts(){
		return productService.getProducts();
	}
	
	@RequestMapping(method= RequestMethod.POST)
	public Product addProduct(@RequestBody Product product) throws Exception {
		return productService.createProduct(product);
	}
	
	
	@RequestMapping(method= RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product) {
		return productService.updateProduct(product);
	}
	
	
	@RequestMapping(value = "/{id}", method= RequestMethod.DELETE)
	public void deleteProduct(@PathVariable("id")Integer id) {
		productService.deleteProduct(id);
	}
	
	
}
