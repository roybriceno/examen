package ar.com.plug.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.com.plug.examen.entities.Client;
import ar.com.plug.examen.entities.Product;
import ar.com.plug.examen.service.ClientService;
import ar.com.plug.examen.utils.MessageResponse;

@RestController
@RequestMapping(path = "/api/clients")
public class ClientController {

	
    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }
    
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addClient(@RequestBody Client client){
        int response = clientService.addingClient(client);
        return MessageResponse.getIntegerResponseEntity(response);
     }

    @GetMapping
    public List<Client> showProduct(){
        return clientService.getAllClient();
     }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateClient(@RequestBody Client client){
        int response = clientService.updatingClient(client);
        return MessageResponse.getIntegerResponseEntity(response);
    }
    
    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deletingClient(@PathVariable("id") Long id){
        int response = clientService.deleteClient(id);
        return MessageResponse.getIntegerResponseEntity(response);
    }
}
