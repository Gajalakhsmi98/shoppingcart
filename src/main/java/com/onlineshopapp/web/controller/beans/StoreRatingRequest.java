package com.onlineshopapp.web.controller.beans;

public class StoreRatingRequest {

	private Long storeId;
	private double rating;
	private int no_of_ratings;
	
	
	
	
	public int getNo_of_ratings() {
		return no_of_ratings;
	}
	public void setNo_of_ratings(int no_of_ratings) {
		this.no_of_ratings = no_of_ratings;
	}
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	
	public StoreRatingRequest( double rating) {
		this.rating = rating;
	}
	public StoreRatingRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
