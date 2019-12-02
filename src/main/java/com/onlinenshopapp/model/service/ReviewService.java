package com.onlinenshopapp.model.service;

import java.util.List;

import com.onlinenshopapp.model.entity.Review;

public interface ReviewService {
	public Review findByReviewId(Long reviewId);
	public List<Review> findByRating(double rating);
}