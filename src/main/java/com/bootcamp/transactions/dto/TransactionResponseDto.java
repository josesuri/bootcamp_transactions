package com.bootcamp.transactions.dto;

import com.bootcamp.transactions.entity.Transaction;
import lombok.Getter;
import lombok.Setter;

/**
 * Clase de transferencia de datos para la respuesta de Transacciones
 */
@Getter
@Setter
public class TransactionResponseDto {
	private Transaction transaction;
	private Message statusDto;
}
