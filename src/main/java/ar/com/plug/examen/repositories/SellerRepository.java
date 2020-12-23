package ar.com.plug.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.plug.examen.entities.SellerEntity;


/**
 * Class to manage the queries to the DB, basic operations only
 */
@Repository
public interface SellerRepository extends JpaRepository<SellerEntity, Long> {}