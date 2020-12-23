package ar.com.plug.examen.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.com.plug.examen.entities.TransactionEntity;


/**
 * Class to manage the queries to the DB, basic operations only
 */

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    
    @Transactional
    @Modifying
    @Query(value = "UPDATE transactions SET state_order = :state_order where id = :id", nativeQuery = true)
    int updateStateOrder(@Param("state_order") String state_order, @Param("id") Long id);
}