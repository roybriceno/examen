package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.Client;
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

    public int addingClient(Client client) {
        try {
            clientRepository.save(client);
            log.info("insertClient processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int updatingClient(Client client) {
        try {
            clientRepository.save(client);
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

    public List<Client> getAllClient() {
        List<Client> users = clientRepository.findAll();
        log.info("getAllClients processed correctly");
        return users;
    }
}
