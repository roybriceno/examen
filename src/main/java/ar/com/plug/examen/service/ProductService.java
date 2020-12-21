package ar.com.plug.examen.service;

import ar.com.plug.examen.models.Product;

import java.util.List;

public interface ProductService {
    int addingProduct(Product product);
    int updatingProduct(Product product);
    int deleteProduct(Long id);
    List<Product> getAllProducts();
}
