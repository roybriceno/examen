package ar.com.plug.examen.domain.service;

import java.util.List;

import ar.com.plug.examen.domain.entities.TransactionStatusEntity;

public interface ITransactionStatusService {

	public List<TransactionStatusEntity> findAll();
	
	public TransactionStatusEntity findById(Long id);
	
	public TransactionStatusEntity save(TransactionStatusEntity transactionstatus);
	
	public void delete(Long id);
}
