package ar.com.plug.examen.controllers;

import ar.com.plug.examen.helpers.ResponseHelper;
import ar.com.plug.examen.models.Seller;
import ar.com.plug.examen.service.SellerService;
import ar.com.plug.examen.service.impl.SellerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/seller",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerServiceImpl sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping
    public List<Seller> showSellers() {
        return sellerService.getAllSellers();
    }

    @PostMapping
    public ResponseEntity<?> addingSeller(@RequestBody Seller seller) {
        int response = sellerService.addSeller(seller);
        return ResponseHelper.getHttpStatusResponse(response);
    }

    @PutMapping
    public ResponseEntity<?> updateSeller(@RequestBody Seller seller) {
        int response = sellerService.updateSeller(seller);
        return ResponseHelper.getHttpStatusResponse(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deletingSeller(@PathVariable("id") Long id) {
        int response = sellerService.deleteSeller(id);
        return ResponseHelper.getHttpStatusResponse(response);
    }
}
