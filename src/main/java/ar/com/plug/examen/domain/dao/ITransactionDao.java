package ar.com.plug.examen.domain.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.plug.examen.domain.entities.TransactionEntity;

public interface ITransactionDao extends CrudRepository<TransactionEntity, Long>{

}
