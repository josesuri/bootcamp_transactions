package com.bootcamp.transactions.controller;

import com.bootcamp.transactions.dto.Message;
import com.bootcamp.transactions.dto.TransactionRequestDto;
import com.bootcamp.transactions.entity.Transaction;
import com.bootcamp.transactions.service.TransactionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase Controller para transacciones
 */
@RestController
@RequestMapping("/transaction")
public class
TransactionsController {

	@Autowired
	private TransactionsService transactionsService;

	/**
	 * Devuelve todas las transacciones
	 * @return Flux<Transaction>
	 */
	@GetMapping
	public Flux<Transaction> getAll(){
		return transactionsService.getAll();
	}

	/**
	 * Devuelve una Transacción según el id de la transacción
	 * @param transactionId
	 * @return Mono<Transaction>
	 */
	@GetMapping("/{transactionId}")
	public Mono<Transaction> getTransactionById(@PathVariable String transactionId){
		return transactionsService.getTransactionById(transactionId);
	}

	/**
	 * Devuelve todas las transacciones según el id del cliente
	 * @param customerId
	 * @return Flux<Transaction>
	 */
	@GetMapping("/customer/{customerId}")
	public Flux<Transaction> getTransactionByCustomerId(@PathVariable String customerId){
		return transactionsService.getTransactionByCustomerId(customerId);
	}

	/**
	 * Crea una transacción con los datos enviados en el body
	 * @param transactionRequestDto
	 * @return Mono<Transaction>
	 */
	@PostMapping
	public Mono<Transaction> createTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
		return transactionsService.createTransaction(transactionRequestDto);
	}

	/**
	 * Actualiza la transacción según los datos enviados en el body
	 * @param transactionRequestDto
	 * @return Mono<Transaction>
	 */
	@PutMapping
	public Mono<Transaction> updateTransaction(@RequestBody TransactionRequestDto transactionRequestDto){
		return transactionsService.updateTransaction(transactionRequestDto);
	}

	/**
	 * Elimina la transacción segun el id de la transacción
	 * @param transactionId
	 * @return Mono<Message>
	 */
	@DeleteMapping("/{transactionId}")
	public Mono<Message> deleteTransaction(@PathVariable String transactionId){
		return transactionsService.deleteTransaction(transactionId);
	}

	/**
	 * Devuelve todas las transacciones según el id del producto
	 * @param productId
	 * @return Flux<Transaction>
	 */
	@GetMapping("/product/{productId}")
	public Flux<Transaction> getAllXProductId(@PathVariable String productId){
		return transactionsService.getAllXProductId(productId);
	}
}
