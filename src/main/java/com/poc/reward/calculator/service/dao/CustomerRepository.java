package com.poc.reward.calculator.service.dao;

import org.springframework.data.repository.CrudRepository;

import com.poc.reward.calculator.type.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{

}
