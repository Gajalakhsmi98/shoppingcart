package com.onlinenshopapp.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="onlineshop_store_table")
public class Store {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long storeId;
	private String storeName;
	private String contactNum;
	private String storeemail;
	
	@JsonIgnore
	@JoinTable(name="store_product_jt",
	joinColumns=@JoinColumn(name="productId_fk"),
	inverseJoinColumns=@JoinColumn(name="storeId_fk"))
	@ManyToMany
	private List<Product> product=new ArrayList<>();
	
	@JsonIgnore
	@OneToMany(mappedBy="store",fetch=FetchType.LAZY)
	private List<Review> review =new ArrayList<Review>();

	

	public Store(String storeName, String contactNum, String storeemail) {
		super();
		this.storeName = storeName;
		this.contactNum = contactNum;
		this.storeemail = storeemail;
	}


	public Store() {
		super();
	}

	
	public List<Review> getReview() {
		return review;
	}

	public void setReview(List<Review> review) {
		this.review = review;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	

	public String getStoreName() {
		return storeName;
	}


	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public String getContactNum() {
		return contactNum;
	}

	public void setContactNum(String contactNum) {
		this.contactNum = contactNum;
	}

	public String getStoreemail() {
		return storeemail;
	}

	public void setStoreemail(String storeemail) {
		this.storeemail = storeemail;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "Store [storeId=" + storeId + ", storeName=" + storeName
				+ ", contactNum=" + contactNum + ", storeemail=" + storeemail
				+ ", product=" + product + ", review=" + review + "]";
	}
	
	
}
