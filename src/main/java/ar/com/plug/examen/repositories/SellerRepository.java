package ar.com.plug.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.plug.examen.entities.Seller;

public interface SellerRepository extends JpaRepository<Seller, Long> {

	 public Seller findByName(String name);
}