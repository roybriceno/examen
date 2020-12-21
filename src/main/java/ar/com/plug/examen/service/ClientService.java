package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.ClientEntity;

import java.util.List;

public interface ClientService {
    int addingClient(ClientEntity clientEntity);
    int updatingClient(ClientEntity clientEntity);
    int deleteClient(Long id);
    List<ClientEntity> getAllClient();
}
