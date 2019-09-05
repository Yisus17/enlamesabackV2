package com.enlamesa.back.service;

import java.util.List;

import com.enlamesa.back.model.Product;


public interface ProductService {

	Product createProduct (Product product);
	
	List<Product> getProducts();
	
	Product updateProduct(Product product);
	
	void deleteProduct(int idProduct);
}
