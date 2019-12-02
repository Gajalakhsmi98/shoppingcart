package com.onlinenshopapp.model.service;

import java.util.List;

import com.onlinenshopapp.model.entity.Product;

public interface ProductService {
	public List<Product> findAllProducts();
	public Product findByProductId(Long productId);
	public Product findByProductName(String productName);
	
	public Product addProduct(Product product);
	public Product updateProduct(Product product,Long productId);
	public void deleteProduct(Long productId);
	
}
