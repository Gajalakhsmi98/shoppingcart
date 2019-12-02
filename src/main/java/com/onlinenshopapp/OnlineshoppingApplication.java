package com.onlinenshopapp;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.onlinenshopapp.model.entity.Category;
import com.onlinenshopapp.model.entity.Customer;
import com.onlinenshopapp.model.entity.Order;
import com.onlinenshopapp.model.entity.Product;
import com.onlinenshopapp.model.entity.ProductDetails;
import com.onlinenshopapp.model.entity.Review;
import com.onlinenshopapp.model.entity.Store;
import com.onlinenshopapp.model.repository.CustomerRepository;
import com.onlinenshopapp.model.repository.OrderRepository;
import com.onlinenshopapp.model.repository.ProductRepository;
import com.onlinenshopapp.model.repository.ReviewRepository;
import com.onlinenshopapp.model.repository.StoreRepository;

@SpringBootApplication
public class OnlineshoppingApplication implements CommandLineRunner{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private ReviewRepository reviewRepository;

	public static void main(String[] args) {
		SpringApplication.run(OnlineshoppingApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {

		Customer cust1=new Customer("preethy", "bangalore", "9578648699", "p@p.com", "pree");
		Customer cust2=new Customer("aarthy", "chennai", "9575678699", "a@a.com", "aar");
		Customer cust3=new Customer("presy", "madurai", "8976523543", "p@r.com", "presy");
		
		Review review1=new Review("better", 4);
		Review review2=new Review("best", 5);
		Review review3=new Review("good", 3);

		Store store1=new Store("Srb stores", "8912345678", "srb@gmail.com");
		Store store2=new Store("ishu stores", "2345167892", "ishu@gmail.com");
		Store store3=new Store("ragu stores", "9812345678", "ragu@gmail.com");
		
		Product product1=new Product("shirt",new ProductDetails(500.0, "white collar", Category.Fashion));
		Product product2=new Product("dhal",new ProductDetails(200.0, "bengal gram", Category.Grocery));
		Product product3=new Product("headset",new ProductDetails(1500.0, "skull candy", Category.Electronics));

		Order order1=new Order(LocalDateTime.now(), "chennai", 10000);
		Order order2=new Order(LocalDateTime.now(), "chennai", 50000);
		Order order3=new Order(LocalDateTime.now(), "coimbatore", 5000);
		
		
		store1.getProduct().add(product1);
		store1.getProduct().add(product2);
		store1.getProduct().add(product3);
		
		store2.getProduct().add(product1);
		store2.getProduct().add(product2);
		
		store3.getProduct().add(product1);
		store3.getProduct().add(product3);
		
		
		product1.getStore().add(store1);
		product1.getStore().add(store2);
		product1.getStore().add(store3);
		
		product2.getStore().add(store1);
		product2.getStore().add(store2);
		
		product3.getStore().add(store3);
		product3.getStore().add(store1);
			
		productRepository.save(product1);
		productRepository.save(product2);
		productRepository.save(product3);
		
		customerRepository.save(cust1);
		customerRepository.save(cust2);
		customerRepository.save(cust3);
		

		storeRepository.save(store1);
		storeRepository.save(store2);
		storeRepository.save(store3);	
		
		store1.getReview().add(review1);
		store1.getReview().add(review2);
		store1.getReview().add(review3);
		
		store2.getReview().add(review1);
		store2.getReview().add(review2);
		store2.getReview().add(review3);
		
		store3.getReview().add(review1);
		store3.getReview().add(review2);
		store3.getReview().add(review3);
		
		review1.setStore(store1);
		review1.setStore(store2);
		review1.setStore(store3);

		review2.setStore(store1);
		review2.setStore(store2);
		review2.setStore(store3);

		review3.setStore(store1);
		review3.setStore(store2);
		review3.setStore(store3);

		storeRepository.save(store1);
		storeRepository.save(store2);
		storeRepository.save(store3);
		
		reviewRepository.save(review1);
		reviewRepository.save(review2);
		reviewRepository.save(review3);
		
		orderRepository.save(order1);
		orderRepository.save(order2);
		orderRepository.save(order3);


	}

}
