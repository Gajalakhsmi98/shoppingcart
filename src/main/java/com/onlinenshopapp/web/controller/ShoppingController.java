package com.onlinenshopapp.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinenshopapp.model.entity.Product;
import com.onlinenshopapp.model.entity.Review;
import com.onlinenshopapp.model.entity.Store;
import com.onlinenshopapp.model.service.ProductService;
import com.onlinenshopapp.model.service.ReviewService;
import com.onlinenshopapp.model.service.StoreService;

@RestController
@RequestMapping(path="api")
public class ShoppingController {
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping(path="products")
	public List<Product> getAllProducts(){
		List<Product> products=productService.findAllProducts();
		return products;
	}
	
	@GetMapping(path="product/{productName}")
	public Product getProductByName(@PathVariable(value="productName")String productName){
		Product product=productService.findByProductName(productName);
		return product;
	}
	
	@GetMapping(path="product/store/{rating}")
	public String getStoreByRating(@PathVariable(value="rating")double rating){
		List<Review> review=reviewService.findByRating(rating);
		Store store=((Review) review).getStore();
		return store.getStoreName();
	}
	
	@GetMapping(path="stores")
	public List<Store> getAllStores(){
		List<Store> stores=storeService.findAll();
		return stores;
	}
	
	/*@GetMapping(path="/product/{productName}",produces=MediaType.APPLICATION_JSON_VALUE)
	public Resource<Product> getAnProduct(@PathVariable(name="productName")String productName){
		
		Product product=productService.findByProductName(productName);
		
		Resource<Product> productResourse=new Resource<Product>(product);
		
		ControllerLinkBuilder link=linkTo(methodOn(this.getClass()).get)
		
		productResourse.add(link.withRel("all-productss"));
		return productResourse;
	}
	*/
	
}
