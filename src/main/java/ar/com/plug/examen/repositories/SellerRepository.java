package ar.com.plug.examen.repositories;

import ar.com.plug.examen.entities.SellerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerRepository extends JpaRepository<SellerEntity, Long> {}