package com.onlinenshopapp.model.entity;

public enum Status {

	Ordered("Ordered"),Cancelled("Cancelled"),Delivered("Cancelled");

	private String status;

	private Status(String status) {
	this.status = status;
}
}