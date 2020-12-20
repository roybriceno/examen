package ar.com.plug.examen.controllers;

import ar.com.plug.examen.entities.SellerEntity;
import ar.com.plug.examen.service.SellerService;
import ar.com.plug.examen.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/seller")
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addingSeller(@RequestBody SellerEntity sellerEntity) {
        int response = sellerService.addSeller(sellerEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @GetMapping
    public List<SellerEntity> showSellers() {
        return sellerService.getAllSellers();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSeller(@RequestBody SellerEntity sellerEntity) {
        int response = sellerService.updateSeller(sellerEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deletingSeller(@PathVariable("id") Long id) {
        int response = sellerService.deleteSeller(id);
        return MessageResponse.getIntegerResponseEntity(response);
    }

}
