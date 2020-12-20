package ar.com.plug.examen.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ar.com.plug.examen.entities.Product;
import ar.com.plug.examen.entities.Seller;
import ar.com.plug.examen.entities.Client;
import ar.com.plug.examen.entities.Transaction;
import ar.com.plug.examen.entities.Venta;
import ar.com.plug.examen.repositories.ProductRepository;
import ar.com.plug.examen.repositories.SellerRepository;
import ar.com.plug.examen.service.SellerService;
import ar.com.plug.examen.utils.MessageResponse;
import ar.com.plug.examen.repositories.ClientRepository;

@RestController
@RequestMapping(path = "/api/seller")

public class SellerController {
    
	private final SellerService sellerService;

    @Autowired
    public SellerController(SellerService sellerService) {
        this.sellerService = sellerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addingSeller(@RequestBody Seller seller){
        int response = sellerService.addSeller(seller);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @GetMapping
    public List<Seller> showSellers(){
        return sellerService.getAllSellers();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateSeller(@RequestBody Seller seller){
        int response = sellerService.updateSeller(seller);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deletingSeller(@PathVariable("id") Long id){
        int response = sellerService.deleteSeller(id);
        return MessageResponse.getIntegerResponseEntity(response);
    }

}
