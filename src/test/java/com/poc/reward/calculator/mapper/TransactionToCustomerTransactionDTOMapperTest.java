package com.poc.reward.calculator.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.poc.reward.calculator.dto.CustomerTransactionDTO;
import com.poc.reward.calculator.type.Customer;
import com.poc.reward.calculator.type.Transaction;

@SpringBootTest
class TransactionToCustomerTransactionDTOMapperTest {
	
	@Autowired
	private TransactionToCustomTransactionDTOMapper transactionToCustomTransactionDTOMapper;

	@Test
	void givenTransactionToCustomerTransactionDTOMapper_whenMaps_thenCorrect() {
		Transaction transaction = Transaction.builder()
				.id(1L)
				.amount(new BigDecimal(250.15))
				.customer(Customer.builder()
						.firstName("John")
						.lastName("Jones")
						.build())
				.build();
		
		CustomerTransactionDTO dto = 
				transactionToCustomTransactionDTOMapper.transactionToCustomTransactionDTOMapper(transaction);
		
		assertEquals(transaction.getId(), dto.getId());
		assertEquals(transaction.getAmount(), dto.getAmount());
	    assertEquals(transaction.getCustomer().getFirstName(), dto.getFirstName());
	    assertEquals(transaction.getCustomer().getLastName(), dto.getLastName());
		
	}
}
