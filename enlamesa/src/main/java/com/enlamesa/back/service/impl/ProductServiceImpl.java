package com.enlamesa.back.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enlamesa.back.model.Product;
import com.enlamesa.back.repository.ProductRepository;
import com.enlamesa.back.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public Product createProduct(Product product) {
		return productRepository.save(product);	
	}

	@Override
	public List<Product> getProducts() {
		return productRepository.findAll();
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProduct(int idProduct) {
		// TODO Auto-generated method stub
		
	}

	
}
