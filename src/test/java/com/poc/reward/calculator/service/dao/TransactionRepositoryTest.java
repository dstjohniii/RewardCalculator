package com.poc.reward.calculator.service.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.reward.calculator.type.Customer;
import com.poc.reward.calculator.type.Transaction;

@SpringBootTest
@javax.transaction.Transactional
class TransactionRepositoryTest {

	@Autowired
	private TransactionRepository transactionRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Test
	void givenTransaction_whenSave_thenGetOk() {
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
		
		Transaction transaction = Transaction.builder()
				.amount(new BigDecimal(23.23))
				.description("Pencils")
				.customer(savedCustomer)
				.build();
		Transaction savedTransaction = transactionRepository.save(transaction);
		assertNotNull(savedTransaction);
		
		Optional<Transaction> foundTransaction = transactionRepository.findById(savedTransaction.getId());
		if(foundTransaction.isEmpty()) {
			fail("No transaction found.");
		}
		assertEquals(foundTransaction.get(), transaction);
		
	}
}
