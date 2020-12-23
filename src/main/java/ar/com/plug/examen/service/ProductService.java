package ar.com.plug.examen.service;

import java.util.List;

/*
 * Service Class in charge of manage the business operations
 */

import ar.com.plug.examen.entities.ProductEntity;
import ar.com.plug.examen.models.Product;

public interface ProductService {
	ProductEntity addProduct(Product product);
    ProductEntity updateProduct(Product product);
    void deleteProduct(Long id);
    List<Product> getAllProducts();
}
