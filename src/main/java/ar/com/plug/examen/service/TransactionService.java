package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.TransactionEntity;

import java.util.List;

public interface TransactionService {
	int addingTransaction(TransactionEntity transactionEntity);
	int updateProductQuantity(TransactionEntity transactionEntity);
	int updateTransactionState(Long id, String stateOrder);
	List<TransactionEntity> getAllSellers();
}