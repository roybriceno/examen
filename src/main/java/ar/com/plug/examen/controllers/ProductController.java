package ar.com.plug.examen.controllers;

import ar.com.plug.examen.helpers.ResponseHelper;
import ar.com.plug.examen.models.Product;
import ar.com.plug.examen.service.ProductService;
import ar.com.plug.examen.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/productos",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE)
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productService = productServiceImpl;
    }

    @GetMapping
    public List<Product> showProduct() {
        return productService.getAllProducts();
    }

    @PostMapping
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
        int response = productService.addingProduct(product);
        return ResponseHelper.getHttpStatusResponse(response);
    }

    @PutMapping
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
        int response = productService.updatingProduct(product);
        return ResponseHelper.getHttpStatusResponse(response);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> deletingProduct(@PathVariable("id") Long id) {
        int response = productService.deleteProduct(id);
        return ResponseHelper.getHttpStatusResponse(response);
    }
}
