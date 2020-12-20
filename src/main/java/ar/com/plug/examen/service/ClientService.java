package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.ClientEntity;
import ar.com.plug.examen.repositories.ClientRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public int addingClient(ClientEntity clientEntity) {
        try {
            clientRepository.save(clientEntity);
            log.info("insertClient processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int updatingClient(ClientEntity clientEntity) {
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

    public List<ClientEntity> getAllClient() {
        List<ClientEntity> users = clientRepository.findAll();
        log.info("getAllClients processed correctly");
        return users;
    }
}
