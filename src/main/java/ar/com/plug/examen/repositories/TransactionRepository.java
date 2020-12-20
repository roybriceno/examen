package ar.com.plug.examen.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.com.plug.examen.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE transactions SET state_order = :state_order where id = :id", nativeQuery = true)
    int updateStateOrder(@Param("state_order") String state_order, @Param("id") Long id);

}