package com.onlinenshopapp.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.onlinenshopapp.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
