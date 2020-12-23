package ar.com.plug.examen.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * Service Class in charge of manage the business operations
 */

import ar.com.plug.examen.entities.ProductEntity;
import ar.com.plug.examen.models.Product;
import ar.com.plug.examen.repositories.ProductRepository;
import ar.com.plug.examen.service.ProductService;
import ar.com.plug.examen.transformers.EntityTransformer;
import ar.com.plug.examen.transformers.ModelTransformer;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductEntity addProduct(Product product) {
        ProductEntity productEntity = ModelTransformer.toProductEntity(product);
        try {
        	log.info("insertSeller processed correctly");
        	return productRepository.save(productEntity);
            
            
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return null;
        }
        }

    @Override
    public ProductEntity updateProduct(Product product) {
        ProductEntity productEntity = ModelTransformer.toProductEntity(product);
        try {
            log.info("updateProduc processed correctly");
            return productRepository.save(productEntity);
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return null;
        }
    }

    @Override
    public void deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            log.info("deleteProduct processed correctly");
            
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            
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