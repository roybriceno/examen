package ar.com.plug.examen.service.impl;

import ar.com.plug.examen.entities.ClientEntity;
import ar.com.plug.examen.models.Client;
import ar.com.plug.examen.repositories.ClientRepository;
import ar.com.plug.examen.service.ClientService;
import ar.com.plug.examen.transformers.EntityTransformer;
import ar.com.plug.examen.transformers.ModelTransformer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public int addingClient(Client client) {
        ClientEntity clientEntity = ModelTransformer.toClientEntity(client);
        try {
            clientRepository.save(clientEntity);
            log.info("insertClient processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int updatingClient(Client client) {
        ClientEntity clientEntity = ModelTransformer.toClientEntity(client);
        try {
            clientRepository.save(clientEntity);
            log.info("updateClient processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int deleteClient(Long id) {
        try {
            clientRepository.deleteById(id);
            log.info("deleteClient processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    public List<Client> getAllClients() {
        List<ClientEntity> clientEntities = clientRepository.findAll();
        log.info("getAllClients processed correctly");
        return clientEntities.stream()
                .map(EntityTransformer::toClient)
                .collect(Collectors.toList());
    }
}
