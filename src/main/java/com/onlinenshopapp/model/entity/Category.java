package com.onlinenshopapp.model.entity;

public enum Category {
	Fashion("Fashion"),Grocery("Grocery"),Electronics("Electronics");

	private String category;

	private Category(String category) {
	this.category = category;
	}
}
