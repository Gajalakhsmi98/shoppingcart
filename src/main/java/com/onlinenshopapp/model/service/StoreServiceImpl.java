package com.onlinenshopapp.model.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.onlinenshopapp.model.entity.Store;
import com.onlinenshopapp.model.repository.StoreRepository;
import com.onlinenshopapp.web.controller.Exception.StoreNotFoundException;

@Service
@Transactional
public class StoreServiceImpl implements StoreService{
	
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Store findByStoreName(String storeName) {
		Store store=storeRepository.findByStoreName(storeName);
		return store;
	}

	@Override
	public List<Store> findAll() {
		List<Store> stores=storeRepository.findAll();
		return stores;
	}

	@Override
	public Store findByStoreId(Long storeId) {
		Store store=storeRepository.findById(storeId).orElseThrow(StoreNotFoundException::new);
		return store;
	}


	@Override
	public Store updateStore(Store store, Long storeId, double rating) {
		Store store2=storeRepository.findById(storeId)
				.orElseThrow(StoreNotFoundException::new);
		store2.setReview(store.getReview());
		return store2;
	}

}
