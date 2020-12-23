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

import ar.com.plug.examen.entities.ProductEntity;
import ar.com.plug.examen.models.Product;
import ar.com.plug.examen.service.ProductService;
import ar.com.plug.examen.service.impl.ProductServiceImpl;

/**
 * Class to manage the business logic of the app
 */
@RestController
@EnableAutoConfiguration
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductServiceImpl productServiceImpl) {
        this.productService = productServiceImpl;
    }

    @GetMapping("/product/get")
    public List<Product> showProduct() {
        return productService.getAllProducts();
    }

    @PostMapping("/product/post")
    public ResponseEntity<?> addProduct(@RequestBody Product product) {
    	ProductEntity aProduct = this.productService.addProduct(product);
    	return ResponseEntity.ok().body(aProduct);
            
    }

    @PutMapping("/product/put")
    public ResponseEntity<?> updateProduct(@RequestBody Product product) {
    	
    	try {
            ProductEntity aProduct = this.productService.updateProduct(product);
            return ResponseEntity.ok().body(aProduct);
        } catch (Error e) {
            return new ResponseEntity<>("El Producto no existe", HttpStatus.NOT_FOUND);
        }
        
        
    }

    @DeleteMapping(path = "/product/{id}")
    public ResponseEntity<?> deletingProduct(@PathVariable("id") Long id) {
        this.productService.deleteProduct(id);
        return ResponseEntity.ok().build();
    }
}
