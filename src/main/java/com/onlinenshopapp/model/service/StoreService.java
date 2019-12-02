package com.onlinenshopapp.model.service;

import java.util.List;

import com.onlinenshopapp.model.entity.Store;

public interface StoreService {
	public Store findByStoreId(Long storeId);
	public Store findByStoreName(String storeName);
	public List<Store> findAll(); 
	public Store updateStore(Store store,Long storeId,double rating);
}
