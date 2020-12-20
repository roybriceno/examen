package ar.com.plug.examen.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ar.com.plug.examen.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

	 @Transactional
	 @Modifying
	 @Query(value = "UPDATE products p join products tp on p.id = tp.id SET p.quantity= (tp.quantity - :quantity) WHERE p.id = :id", nativeQuery = true)
	 int updateQuantity(@Param("id") Long id, @Param("quantity") Long quantity );
    
	public Product findByName(String name);
}
