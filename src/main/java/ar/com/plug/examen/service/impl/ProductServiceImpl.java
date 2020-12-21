package ar.com.plug.examen.service.impl;

import ar.com.plug.examen.entities.ProductEntity;
import ar.com.plug.examen.models.Product;
import ar.com.plug.examen.repositories.ProductRepository;
import ar.com.plug.examen.service.ProductService;
import ar.com.plug.examen.transformers.EntityTransformer;
import ar.com.plug.examen.transformers.ModelTransformer;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public int addingProduct(Product product) {
        ProductEntity productEntity = ModelTransformer.toProductEntity(product);
        try {
            productRepository.save(productEntity);
            log.info("insertProduct processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int updatingProduct(Product product) {
        ProductEntity productEntity = ModelTransformer.toProductEntity(product);
        try {
            productRepository.save(productEntity);
            log.info("updateProduc processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    @Override
    public int deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            log.info("deleteProduct processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<ProductEntity> productEntities = productRepository.findAll();
        log.info("getAllProducts processed correctly");
        return productEntities.stream()
                .map(EntityTransformer::toProduct)
                .collect(Collectors.toList());
    }
}
