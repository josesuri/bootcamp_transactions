package com.bootcamp.transactions.service.impl;

import com.bootcamp.transactions.dto.Message;
import com.bootcamp.transactions.dto.TransactionRequestDto;
import com.bootcamp.transactions.entity.Transaction;
import com.bootcamp.transactions.repository.TransactionsRepository;
import com.bootcamp.transactions.service.TransactionsService;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de implementación para la interfaz TransactionsService
 */
@Service
public class TransactionsServiceImpl implements TransactionsService {

	@Autowired
	private TransactionsRepository transactionsRepository;

	/**
	 * Método que devuelve todas las transacciones dentro el repositorio.
	 * @return Flux<Transaction>
	 */
	@Override
	public Flux<Transaction> getAll() {
		return transactionsRepository.findAll();
	}

	/**
	 * Devuelve una transacción dentro del repositorio según el id de la transacción.
	 * @param transactionId
	 * @return Mono<Transaction>
	 */
	@Override
	public Mono<Transaction> getTransactionById(String transactionId) {
		return transactionsRepository.findById(transactionId);
	}

	/**
	 * Devuelve todas las transacciones dentro del repositorio según el id del cliente.
	 * @param customerId
	 * @return Flux<Transaction>
	 */
	@Override
	public Flux<Transaction> getTransactionByCustomerId(String customerId) {
		return transactionsRepository.findByCustomerId(customerId);
	}

	/**
	 * Crea una transacción dentro del repositorio con los datos enviados en el body.
	 * @param transactionRequestDto
	 * @return Mono<Transaction>
	 */
	@Override
	public Mono<Transaction> createTransaction(TransactionRequestDto transactionRequestDto) {
		Transaction transaction = new Transaction(null,transactionRequestDto.getProductType(),
				transactionRequestDto.getProductId(),transactionRequestDto.getCustomerId()
				,transactionRequestDto.getTransactionType(),transactionRequestDto.getAmount(),
				LocalDateTime.now(), transactionRequestDto.getCustomerType(), transactionRequestDto.getBalance());
		return transactionsRepository.save(transaction);
	}

	/**
	 * Actualiza la transacción dentro del repositorio según los datos enviados en el body.
	 * @param transactionRequestDto
	 * @return Mono<Transaction>
	 */
	@Override
	public Mono<Transaction> updateTransaction(TransactionRequestDto transactionRequestDto) {
		return transactionsRepository.findById(transactionRequestDto.getId())
				.flatMap(uTransaction -> {
					uTransaction.setProductType(transactionRequestDto.getProductType());
					uTransaction.setProductId(transactionRequestDto.getProductId());
					uTransaction.setCustomerId(transactionRequestDto.getCustomerId());
					uTransaction.setTransactionType(transactionRequestDto.getTransactionType());
					uTransaction.setAmount(transactionRequestDto.getAmount());
					uTransaction.setTransactionDate(transactionRequestDto.getTransactionDate());
					uTransaction.setCustomerType(transactionRequestDto.getCustomerType());
					uTransaction.setBalance(transactionRequestDto.getBalance());
					return transactionsRepository.save(uTransaction);
				});
	}

	/**
	 * Elimina la transacción dentro del repositorio segun el id de la transacción
	 * @param transactionId
	 * @return Mono<Message>
	 */
	@Override
	public Mono<Message> deleteTransaction(String transactionId) {
		Message message = new Message("Transaction does not exist");
		return transactionsRepository.findById(transactionId)
				.flatMap(dTransaction -> {
					message.setMessage("Transaction deleted successfully");
					return transactionsRepository.deleteById(dTransaction.getId()).thenReturn(message);
				}).defaultIfEmpty(message);
	}

	/**
	 * Devuelve todas las transacciones dentro del repositorio según el id del producto
	 * @param productId
	 * @return Flux<Transaction>
	 */
	@Override
	public Flux<Transaction> getAllXProductId(String productId) {
		return transactionsRepository.findAll()
				.filter(t -> t.getProductId().equals(productId));
	}
}
