package com.onlinenshopapp.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinenshopapp.model.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
	public Product findByProductName(String productName);

}
