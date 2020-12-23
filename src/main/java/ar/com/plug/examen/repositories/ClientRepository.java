package ar.com.plug.examen.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.plug.examen.entities.ClientEntity;
import ar.com.plug.examen.models.Client;

/**
 * Class to manage the queries to the DB, basic operations only
 */
@Repository
public interface ClientRepository extends JpaRepository<ClientEntity, Long> {

	void deleteById(Optional<Client> aClient);}
