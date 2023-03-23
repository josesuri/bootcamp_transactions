package com.bootcamp.transactions.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

/**
 * Clase de transferencia de datos para la solicitud de Transacciones
 */
@Data
public class TransactionRequestDto {
	private String id;
	@NotEmpty
	private String productType; //AHORRO, C_CORRIENTE, PLAZO_FIJO, CRE_PERSONAL, CRED_EMPRESARIAL, TAR_CRED_PERSONAL, TAR_CRED_EMPRESARIAL
	@NotEmpty
	private String productId;
	@NotEmpty
	private String customerId;
	@NotEmpty
	private String transactionType; //DEPOSITO, RETIRO, PAGO, CONSUMO
	@NotEmpty
	private Double amount;
	@NotEmpty
	private LocalDateTime transactionDate;
	
	private String customerType;
	
	private Double balance;
	
}
