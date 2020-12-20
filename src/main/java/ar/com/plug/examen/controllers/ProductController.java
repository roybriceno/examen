package ar.com.plug.examen.controllers;

import ar.com.plug.examen.entities.Product;
import ar.com.plug.examen.service.ProductService;
import ar.com.plug.examen.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/productos")
public class ProductController {


    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        int response = productService.addingProduct(product);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @GetMapping
    public List<Product> showProduct() {
        return productService.getAllProducts();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        int response = productService.updatingProduct(product);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deletingProduct(@PathVariable("id") Long id) {
        int response = productService.deleteProduct(id);
        return MessageResponse.getIntegerResponseEntity(response);
    }
}
