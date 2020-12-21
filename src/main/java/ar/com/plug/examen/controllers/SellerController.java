package ar.com.plug.examen.controllers;

import ar.com.plug.examen.entities.SellerEntity;
import ar.com.plug.examen.service.impl.SellerServiceImpl;
import ar.com.plug.examen.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/seller")
public class SellerController {

    private final SellerServiceImpl sellerServiceImpl;

    @Autowired
    public SellerController(SellerServiceImpl sellerServiceImpl) {
        this.sellerServiceImpl = sellerServiceImpl;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addingSeller(@RequestBody SellerEntity sellerEntity) {
        int response = sellerServiceImpl.addSeller(sellerEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @GetMapping
    public List<SellerEntity> showSellers() {
        return sellerServiceImpl.getAllSellers();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSeller(@RequestBody SellerEntity sellerEntity) {
        int response = sellerServiceImpl.updateSeller(sellerEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deletingSeller(@PathVariable("id") Long id) {
        int response = sellerServiceImpl.deleteSeller(id);
        return MessageResponse.getIntegerResponseEntity(response);
    }

}
