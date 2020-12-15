package ar.com.plug.examen.domain.service;

import java.util.List;

import ar.com.plug.examen.domain.entities.TransactionEntity;

public interface TransactionService {

	public List<TransactionEntity> findAll();
	
	public TransactionEntity findById(Long id);
	
	public TransactionEntity save(TransactionEntity transaction);
	
	public void delete(Long id);
}
