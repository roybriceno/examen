package ar.com.plug.examen.controllers;

import ar.com.plug.examen.entities.ClientEntity;
import ar.com.plug.examen.service.impl.ClientService;
import ar.com.plug.examen.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/clients")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addClient(@RequestBody ClientEntity clientEntity) {
        int response = clientService.addingClient(clientEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @GetMapping
    public List<ClientEntity> showProduct() {
        return clientService.getAllClient();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateClient(@RequestBody ClientEntity clientEntity) {
        int response = clientService.updatingClient(clientEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deletingClient(@PathVariable("id") Long id) {
        int response = clientService.deleteClient(id);
        return MessageResponse.getIntegerResponseEntity(response);
    }
}
