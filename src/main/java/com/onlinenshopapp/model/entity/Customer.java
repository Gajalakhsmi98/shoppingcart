package com.onlinenshopapp.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="onlineshop_customer_table")
public class Customer {

	private static BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long cusId;
	private String custName;
	private String address;
	private String phone;
	@Column(unique=true)
	private String email;
	@JsonIgnore
	private String password;
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy="customer")
	private List<Order> order=new ArrayList<>();
	
	public Long getCusId() {
		return cusId;
	}
	public void setCusId(Long cusId) {
		this.cusId = cusId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = encoder.encode(password);
	}
	public Customer(String custName, String address, String phone,
			String email, String password) {
		super();
		this.custName = custName;
		this.address = address;
		this.phone = phone;
		this.email = email;
	    setPassword(password);
	}
	public Customer() {
		super();
	}
	public static BCryptPasswordEncoder getEncoder() {
		return encoder;
	}
	public static void setEncoder(BCryptPasswordEncoder encoder) {
		Customer.encoder = encoder;
	}
	
	public List<Order> getOrder() {
		return order;
	}
	public void setOrder(List<Order> order) {
		this.order = order;
	}
	@Override
	public String toString() {
		return "Customer [cusId=" + cusId + ", custName=" + custName + ", address=" + address + ", phone=" + phone
				+ ", email=" + email + ", password=" + password + ", order=" + order + "]";
	}
	
	
}
