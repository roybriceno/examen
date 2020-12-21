package ar.com.plug.examen.repositories;

import ar.com.plug.examen.entities.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientEntity, Long> {}
