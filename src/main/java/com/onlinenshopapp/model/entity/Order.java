      package com.onlinenshopapp.model.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="onlineshop_order_table")
public class Order {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long orderId;
	private LocalDateTime timestamp;
	private String orderAddress;
	private double amount;
	
	@JsonIgnore
	@JoinColumn(name="custId")
	@ManyToOne
	private Customer customer;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getOrderAddress() {
		return orderAddress;
	}

	public void setOrderAddress(String orderAddress) {
		this.orderAddress = orderAddress;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Order(LocalDateTime timestamp, String orderAddress, double amount) {
		super();
		this.timestamp = timestamp;
		this.orderAddress = orderAddress;
		this.amount = amount;
	}

	public Order() {
		super();
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", timestamp=" + timestamp
				+ ", orderAddress=" + orderAddress + ", amount=" + amount
				+ ", customer=" + customer + "]";
	}

	
	
	
}
