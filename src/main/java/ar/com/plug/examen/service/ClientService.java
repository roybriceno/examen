package ar.com.plug.examen.service;

import java.util.List;
import java.util.Optional;

import ar.com.plug.examen.entities.ClientEntity;
import ar.com.plug.examen.models.Client;

/*
 * Service Interface in charge of manage the business operations
 */

public interface ClientService {
	ClientEntity addingClient(Client client);
	ClientEntity updatingClient(Client client);
    void deleteClient(Long id);
    List<Client> getAllClients();
    Optional<Client> findById(Long id);
}
