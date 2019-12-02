package com.onlinenshopapp.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinenshopapp.model.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{
	public List<Review> findByRating(double rating);

}
