package com.onlinenshopapp.model.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinenshopapp.model.entity.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{
	public Store findByStoreName(String storeName);
}
