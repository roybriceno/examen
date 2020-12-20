package ar.com.plug.examen.repositories;

import ar.com.plug.examen.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<Seller, Long> {

    public Seller findByName(String name);
}