package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.ProductEntity;

import java.util.List;

public interface ProductService {
    int addingProduct(ProductEntity productEntity);
    int updatingProduct(ProductEntity productEntity);
    int deleteProduct(Long id);
    List<ProductEntity> getAllProducts();
}
