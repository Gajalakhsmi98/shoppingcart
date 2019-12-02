package com.onlinenshopapp.model.entity;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
public class ProductDetails {

	private double price;
	private String description;
	@Enumerated(EnumType.STRING)
	private Category category;
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public ProductDetails(double price, String description, Category category) {
		super();
		this.price = price;
		this.description = description;
		this.category = category;
	}
	public ProductDetails() {
		super();
	}
	
	
	
}
