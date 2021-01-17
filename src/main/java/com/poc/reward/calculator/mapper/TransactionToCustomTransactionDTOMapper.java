package com.poc.reward.calculator.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.poc.reward.calculator.dto.CustomerTransactionDTO;
import com.poc.reward.calculator.type.Transaction;

@Mapper(componentModel = "spring")
public interface TransactionToCustomTransactionDTOMapper {
	
	@Mappings({
		@Mapping(target="id", source = "entity.id"),
		@Mapping(target="firstName", source = "entity.customer.firstName"),
		@Mapping(target="lastName", source = "entity.customer.lastName"),
		@Mapping(target="amount", source = "entity.amount")
	})
	CustomerTransactionDTO transactionToCustomTransactionDTOMapper(Transaction entity);
}
