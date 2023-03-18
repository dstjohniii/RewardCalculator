package com.poc.reward.calculator.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

@Value
@Builder
public class CustomerTransactionDTO {

	Long id;
	String firstName;
	String lastName;
	BigDecimal amount;
}
