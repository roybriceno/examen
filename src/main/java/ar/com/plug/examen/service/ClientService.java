package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.Client;
import ar.com.plug.examen.repositories.ClientRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    Logger logger = LoggerFactory.getLogger(ClientService.class);

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public int addingClient(Client client) {
        try {
        	clientRepository.save(client);
            logger.info("insertClient processed correctly");
            return 1;
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
            return 0;
        }
    }

    public int updatingClient(Client client) {
        try {
        	clientRepository.save(client);
            logger.info("updateClient processed correctly");
            return 1;
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
            return 0;
        }
    }

    public int deleteClient (Long id){
        try {
        	clientRepository.deleteById(id);
            logger.info("deleteClient processed correctly");
            return 1;
        } catch (Exception e) {
            logger.error("Error "+e.getMessage());
            return 0;
        }
    }

    public List<Client> getAllClient() {
        List<Client> users = clientRepository.findAll();
        logger.info("getAllClients processed correctly");
        return users;
    }
}
