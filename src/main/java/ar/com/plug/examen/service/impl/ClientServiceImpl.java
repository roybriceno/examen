package ar.com.plug.examen.service.impl;

/*
 * Service Class in charge of manage the business operations
 */

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.plug.examen.entities.ClientEntity;
import ar.com.plug.examen.models.Client;
import ar.com.plug.examen.repositories.ClientRepository;
import ar.com.plug.examen.service.ClientService;
import ar.com.plug.examen.transformers.EntityTransformer;
import ar.com.plug.examen.transformers.ModelTransformer;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientEntity addingClient(Client client) {
        ClientEntity clientEntity = ModelTransformer.toClientEntity(client);
        try {
            return clientRepository.save(clientEntity);     
        } catch (Exception e) {
            log.error(e);
            throw e;
        }
    }

    public ClientEntity updatingClient(Client client) {
        ClientEntity clientEntity = ModelTransformer.toClientEntity(client);
        try {
        	log.info("updateClient processed correctly");
        	return clientRepository.save(clientEntity);
            
            
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return null;
        }	
    }

    public void deleteClient(Long id) {
    	Optional<Client> aClient = null;
        try {
            aClient = this.findById(id);
        } catch (Error e) {
            //e.printStackTrace();
        }
        this.clientRepository.deleteById(aClient);
        }
        
     

    public List<Client> getAllClients() {
        List<ClientEntity> clientEntities = clientRepository.findAll();
        log.info("getAllClients processed correctly");
        return clientEntities.stream()
                .map(EntityTransformer::toClient)
                .collect(Collectors.toList());
    }



	@Override
	public Optional<Client> findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}