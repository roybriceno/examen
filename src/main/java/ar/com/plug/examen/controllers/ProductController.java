package ar.com.plug.examen.controllers;

import ar.com.plug.examen.entities.ProductEntity;
import ar.com.plug.examen.service.impl.ProductService;
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
    public ResponseEntity<?> addProduct(@RequestBody ProductEntity productEntity) {
        int response = productService.addingProduct(productEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @GetMapping
    public List<ProductEntity> showProduct() {
        return productService.getAllProducts();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@RequestBody ProductEntity productEntity) {
        int response = productService.updatingProduct(productEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deletingProduct(@PathVariable("id") Long id) {
        int response = productService.deleteProduct(id);
        return MessageResponse.getIntegerResponseEntity(response);
    }
}
