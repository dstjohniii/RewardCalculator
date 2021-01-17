package com.poc.reward.calculator.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerTransactionDTO {

	private Long id;
	private String firstName;
	private String lastName;
	private BigDecimal amount;
	
}
