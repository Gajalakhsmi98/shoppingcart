package com.onlinenshopapp.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="onlineshop_review_table")
public class Review {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long reviewId;
	private String comments;
	private double rating;
	
	
	@JsonIgnore
	@ManyToOne
	private Store store;

	public Review(String comments, double rating) {
		super();
		this.comments = comments;
		this.rating = rating;
	}

	public Review() {
		super();
	}
	

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
	}

	public Long getReviewId() {
		return reviewId;
	}

	public void setReviewId(Long reviewId) {
		this.reviewId = reviewId;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	

	public void add(Review review1) {
		// TODO Auto-generated method stub
		review1.add(review1);
	}

	@Override
	public String toString() {
		return "Review [reviewId=" + reviewId + ", comments=" + comments + ", rating=" + rating + ", store=" + store
				+ "]";
	}

	
	
}
