package com.bootcamp.transactions.entity;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Clase de entidad
 */
@Data
@AllArgsConstructor
@Document(collection="transaction")
public class Transaction {
	@Id
	private String id;
	@NotEmpty
	private String productType;
	@NotEmpty
	private String productId;
	@NotEmpty
	private String customerId;
	@NotEmpty
	private String transactionType;
	@NotEmpty
	private Double amount;
	@NotEmpty
	private LocalDateTime transactionDate;
	@NotEmpty
	private String customerType;
	
	private Double balance;
}
