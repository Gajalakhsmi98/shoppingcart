package com.onlinenshopapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinenshopapp.model.entity.Product;
import com.onlinenshopapp.model.entity.Review;
import com.onlinenshopapp.model.entity.Store;
import com.onlinenshopapp.model.repository.ProductRepository;
import com.onlinenshopapp.model.repository.ReviewRepository;
import com.onlinenshopapp.model.repository.StoreRepository;
import com.onlinenshopapp.web.controller.Exception.ProductNotFoundException;
import com.onlinenshopapp.web.controller.Exception.ReviewNotFoundException;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService{
	
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public List<Review> findByRating(double rating) {
		List<Review> reviews=reviewRepository.findByRating(rating);
		return reviews;
	}

	@Override
	public Review findByReviewId(Long reviewId) {
		Review review=reviewRepository.findById(reviewId).orElseThrow(ReviewNotFoundException::new);
		return review;
	}

	

}