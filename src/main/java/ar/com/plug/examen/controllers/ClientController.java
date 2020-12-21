package ar.com.plug.examen.controllers;

import ar.com.plug.examen.helpers.ResponseHelper;
import ar.com.plug.examen.models.Client;
import ar.com.plug.examen.service.ClientService;
import ar.com.plug.examen.service.impl.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/clients",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientServiceImpl clientServiceImpl) {
        this.clientService = clientServiceImpl;
    }

    @GetMapping
    public List<Client> getAll() {
        return clientService.getAllClients();
    }

    @PostMapping
    public ResponseEntity<?> addClient(@RequestBody Client client) {
        int response = clientService.addingClient(client);
        return ResponseHelper.getHttpStatusResponse(response);
    }

    @PutMapping
    public ResponseEntity<?> updateClient(@RequestBody Client client) {
        int response = clientService.updatingClient(client);
        return ResponseHelper.getHttpStatusResponse(response);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deletingClient(@PathVariable("id") Long id) {
        int response = clientService.deleteClient(id);
        return ResponseHelper.getHttpStatusResponse(response);
    }
}
