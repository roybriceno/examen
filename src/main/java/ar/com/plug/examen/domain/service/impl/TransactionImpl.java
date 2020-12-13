package ar.com.plug.examen.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.plug.examen.domain.dao.ITransactionDao;
import ar.com.plug.examen.domain.entities.TransactionEntity;
import ar.com.plug.examen.domain.service.ITransactionService;

@Service
public class TransactionImpl implements ITransactionService {

	@Autowired
	private ITransactionDao transactionDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<TransactionEntity> findAll() {
		return (List<TransactionEntity>) transactionDao.findAll() ;
	}

	@Override
	@Transactional(readOnly = true)
	public TransactionEntity findById(Long id) {
		return transactionDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public TransactionEntity save(TransactionEntity transaction) {
		return transactionDao.save(transaction);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		transactionDao.deleteById(id);
	}

}
