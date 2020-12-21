package ar.com.plug.examen.service.impl;

import ar.com.plug.examen.entities.ProductEntity;
import ar.com.plug.examen.repositories.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ProductServiceImpl implements ar.com.plug.examen.service.ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public int addingProduct(ProductEntity productEntity) {
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
    public int updatingProduct(ProductEntity productEntity) {
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
    public List<ProductEntity> getAllProducts() {
        List<ProductEntity> productEntity = productRepository.findAll();
        log.info("getAllProducts processed correctly");
        return productEntity;
    }
}
