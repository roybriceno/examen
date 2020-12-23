package ar.com.plug.examen.service;

/*
 * Service Interface in charge of manage the business operations
 */

import java.util.List;

import ar.com.plug.examen.entities.TransactionEntity;
import ar.com.plug.examen.models.Transaction;

public interface TransactionService {
	TransactionEntity addTransaction(Transaction transaction);
	void updateProductQuantity(Transaction transaction);
	void updateTransactionState(Long id, String stateOrder);
	List<Transaction> getAllSellers();
}