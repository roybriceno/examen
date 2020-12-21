package ar.com.plug.examen.controllers;

import ar.com.plug.examen.entities.ClientEntity;
import ar.com.plug.examen.service.impl.ClientServiceImpl;
import ar.com.plug.examen.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/clients")
public class ClientController {

    private final ClientServiceImpl clientServiceImpl;

    @Autowired
    public ClientController(ClientServiceImpl clientServiceImpl) {
        this.clientServiceImpl = clientServiceImpl;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addClient(@RequestBody ClientEntity clientEntity) {
        int response = clientServiceImpl.addingClient(clientEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @GetMapping
    public List<ClientEntity> showProduct() {
        return clientServiceImpl.getAllClient();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateClient(@RequestBody ClientEntity clientEntity) {
        int response = clientServiceImpl.updatingClient(clientEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deletingClient(@PathVariable("id") Long id) {
        int response = clientServiceImpl.deleteClient(id);
        return MessageResponse.getIntegerResponseEntity(response);
    }
}
