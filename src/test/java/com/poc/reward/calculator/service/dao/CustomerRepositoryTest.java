package com.poc.reward.calculator.service.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.reward.calculator.type.Customer;

@SpringBootTest
class CustomerRepositoryTest {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	void givenCustomer_whenSave_thenGetOk() {
		Customer customer = Customer.builder()
				.email("ham@gmail.com")
				.firstName("ham")
				.lastName("me")
				.password("spring2021")
				.rewardPoints(123L)
				.userName("hamme")
				.build();
		
		Customer savedCustomer = customerRepository.save(customer);
		assertNotNull(savedCustomer);
		
		Optional<Customer> foundCustomer = customerRepository.findById(savedCustomer.getId());
		if(foundCustomer.isEmpty()) {
			fail("No customer found.");
		}
		assertEquals(foundCustomer.get(), customer);
		
	}
}
