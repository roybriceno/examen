package ar.com.plug.examen.service;

import ar.com.plug.examen.models.Client;

import java.util.List;

public interface ClientService {
    int addingClient(Client client);
    int updatingClient(Client client);
    int deleteClient(Long id);
    List<Client> getAllClients();
}
