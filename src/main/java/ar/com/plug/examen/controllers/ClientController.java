package ar.com.plug.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.plug.examen.entities.ClientEntity;
import ar.com.plug.examen.models.Client;
import ar.com.plug.examen.service.ClientService;
import ar.com.plug.examen.service.impl.ClientServiceImpl;


/**
 * Class to manage the business logic of the app
 */

@RestController 
@EnableAutoConfiguration
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientServiceImpl clientServiceImpl) {
        this.clientService = clientServiceImpl;
    }

    @GetMapping("client/get")
    public List<Client> getAll() {
        return clientService.getAllClients();
    }

    @PostMapping("client/post")
    public ResponseEntity<?> addingClient(@RequestBody Client client) {
    	ClientEntity aClient  = this.clientService.addingClient(client);
        return ResponseEntity.ok().body(aClient);
        
    }

    @PutMapping("client/put")
    public ResponseEntity<?> updatingClient(@RequestBody Client client) {
    	try {
          ClientEntity aClient = this.clientService.updatingClient(client);
          return ResponseEntity.ok().body(aClient);
    	} catch (Error e) {
            return new ResponseEntity<>("El Cliente no existe", HttpStatus.NOT_FOUND);
        }
    }
    

    @DeleteMapping("client/delete/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable("id") Long id) {
        this.clientService.deleteClient(id);
        return ResponseEntity.ok().build();
    }
}
