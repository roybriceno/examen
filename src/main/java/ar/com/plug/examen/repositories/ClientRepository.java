package ar.com.plug.examen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.plug.examen.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long>  {

	public Client findByName(String name);
}
