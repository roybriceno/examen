package ar.com.plug.examen.domain.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.plug.examen.domain.entities.TransactionStatusEntity;


public interface ITransactionStatusDao extends CrudRepository<TransactionStatusEntity, Long>{

}
