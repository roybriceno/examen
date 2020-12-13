package ar.com.plug.examen.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.plug.examen.domain.dao.ITransactionStatusDao;
import ar.com.plug.examen.domain.entities.TransactionStatusEntity;
import ar.com.plug.examen.domain.service.ITransactionStatusService;

@Service
public class TransactionStatusImpl implements ITransactionStatusService {

	@Autowired
	private ITransactionStatusDao transactionStatusDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<TransactionStatusEntity> findAll() {
		return (List<TransactionStatusEntity>) transactionStatusDao.findAll() ;
	}

	@Override
	@Transactional(readOnly = true)
	public TransactionStatusEntity findById(Long id) {
		return transactionStatusDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public TransactionStatusEntity save(TransactionStatusEntity transactionStatus) {
		return transactionStatusDao.save(transactionStatus);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		transactionStatusDao.deleteById(id);
	}

}
