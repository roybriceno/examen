package ar.com.plug.examen.controllers;

import ar.com.plug.examen.entities.ProductEntity;
import ar.com.plug.examen.service.impl.ProductServiceImpl;
import ar.com.plug.examen.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/productos")
public class ProductController {

    private final ProductServiceImpl productServiceImpl;

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productServiceImpl = productServiceImpl;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addProduct(@RequestBody ProductEntity productEntity) {
        int response = productServiceImpl.addingProduct(productEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @GetMapping
    public List<ProductEntity> showProduct() {
        return productServiceImpl.getAllProducts();
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> updateProduct(@RequestBody ProductEntity productEntity) {
        int response = productServiceImpl.updatingProduct(productEntity);
        return MessageResponse.getIntegerResponseEntity(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deletingProduct(@PathVariable("id") Long id) {
        int response = productServiceImpl.deleteProduct(id);
        return MessageResponse.getIntegerResponseEntity(response);
    }
}
