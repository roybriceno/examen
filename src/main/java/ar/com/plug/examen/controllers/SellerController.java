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

import ar.com.plug.examen.entities.SellerEntity;
import ar.com.plug.examen.models.Seller;
import ar.com.plug.examen.service.SellerService;
import ar.com.plug.examen.service.impl.SellerServiceImpl;

/**
 * Class to manage the business logic of the app
 */

@RestController
@EnableAutoConfiguration

public class SellerController {

    private final SellerService sellerService;

    @Autowired
    public SellerController(SellerServiceImpl sellerService) {
        this.sellerService = sellerService;
    }

    @GetMapping(value = "/showSellers")
    public List<Seller> getAllSellers() {
        return sellerService.getAllSellers();
    }

    @PostMapping(value = "/addSellers")
    public ResponseEntity<?> addSeller(@RequestBody Seller seller) {
    	SellerEntity aSeller = this.sellerService.addSeller(seller);
    	return ResponseEntity.ok().body(aSeller);
    }

    @PutMapping("/seller/update")
    public ResponseEntity<?> updateSeller(@RequestBody Seller seller) {
    	
    	try {
    	SellerEntity aSeller = this.sellerService.updateSeller(seller);
    	return ResponseEntity.ok().body(aSeller);
    	
    	} catch (Error e) {
            return new ResponseEntity<>("El Vendedor no existe", HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteSeller(@PathVariable("id") Long id) {
        this.sellerService.deleteSeller(id);
        return ResponseEntity.ok().build();
}
}
