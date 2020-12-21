package ar.com.plug.examen.service;

import ar.com.plug.examen.models.Transaction;

import java.util.List;

public interface TransactionService {
	int addingTransaction(Transaction transaction);
	int updateProductQuantity(Transaction transaction);
	int updateTransactionState(Long id, String stateOrder);
	List<Transaction> getAllSellers();
}