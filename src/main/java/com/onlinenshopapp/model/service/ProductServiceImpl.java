package com.onlinenshopapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinenshopapp.model.entity.Product;
import com.onlinenshopapp.model.repository.ProductRepository;
import com.onlinenshopapp.web.controller.Exception.ProductNotFoundException;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public List<Product> findAllProducts() {
		 List<Product> products=productRepository.findAll();
		return products;
	}

	@Override
	public Product findByProductName(String productName) {
		Product product=productRepository.findByProductName(productName);
		return product;
	}

	@Override
	public Product findByProductId(Long productId) {
		Product product=productRepository.findById(productId).orElseThrow(ProductNotFoundException::new);
		return product;
	}

	@Override
	public Product addProduct(Product product) {
		Product product1 =productRepository.save(product);
		return product1;
	}

	

	@Override
	public void deleteProduct(Long productId) {
		productRepository.deleteById(productId);
	}

	@Override
	public Product updateProduct(Product product, Long productId) {
		Product product2=productRepository.findById(productId)
				.orElseThrow(ProductNotFoundException::new);
		product2.setProductDetails(product.getProductDetails());
		return productRepository.save(product2);
		
	}

	
	
}
