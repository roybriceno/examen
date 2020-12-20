package ar.com.plug.examen.repositories;

import ar.com.plug.examen.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client findByName(String name);
}
