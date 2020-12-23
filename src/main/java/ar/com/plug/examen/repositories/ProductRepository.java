package ar.com.plug.examen.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.com.plug.examen.entities.ProductEntity;


/**
 * Class to manage the queries to the DB, basic operations only
 */

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE products p join products tp on p.id = tp.id SET p.quantity= (tp.quantity - :quantity) WHERE p.id = :id", nativeQuery = true)
    int updateQuantity(@Param("id") Long id, @Param("quantity") Long quantity);

}
