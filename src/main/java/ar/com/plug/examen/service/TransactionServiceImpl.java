package ar.com.plug.examen.service;

import java.util.List;

import ar.com.plug.examen.entities.TransactionEntity;

public interface TransactionServiceImpl {

	int addingTransaction(TransactionEntity transactionEntity);
	int updateProductQuantity(TransactionEntity transactionEntity);
	int updateTransactionState(Long id, String stateOrder);
	List<TransactionEntity> getAllSellers();

}