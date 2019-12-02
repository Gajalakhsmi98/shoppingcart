package com.onlinenshopapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinenshopapp.model.entity.Store;
import com.onlinenshopapp.model.repository.StoreRepository;
import com.onlinenshopapp.model.service.StoreService;
import com.onlineshopapp.web.controller.beans.StoreRatingRequest;

@RestController
@RequestMapping(path="api")
public class StoreController {
	
	@Autowired
	private StoreService storeService;

	@GetMapping(path="stores/{storeId}")
	public Store getStoreById(@PathVariable(value="storeId")Long storeId){
		Store store=storeService.findByStoreId(storeId);
		return store;
	}
	
	@GetMapping(path="stores")
	public List<Store> getAllStore(){
		List<Store> store1=storeService.findAll();
		return store1;
	}
	
	@GetMapping(path="stores/{storeName}")
	public Store getStoreByStoreName(@PathVariable(value="storeName")String storeName){
		Store store2=storeService.findByStoreName(storeName);
		return store2;
	}

	/*public Store updateStoreByRating(@RequestBody StoreRatingRequest storeRatingRequest
			,@PathVariable(value="rating")double rating,@PathVariable(value="storeId")Long storeId){
		Store store1=storeService.findByStoreId(storeId);
		store1.getReview(). 
				return null;
	
}*/
}
