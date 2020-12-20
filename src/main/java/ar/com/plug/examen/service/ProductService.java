package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.Product;
import ar.com.plug.examen.repositories.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    Logger logger = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public int addingProduct(Product product) {
        try {
            productRepository.save(product);
            logger.info("insertProduct processed correctly");
            return 1;
        } catch (Exception e) {
            logger.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int updatingProduct(Product product) {
        try {
            productRepository.save(product);
            logger.info("updateProduc processed correctly");
            return 1;
        } catch (Exception e) {
            logger.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int deleteProduct(Long id) {
        try {
            productRepository.deleteById(id);
            logger.info("deleteProduct processed correctly");
            return 1;
        } catch (Exception e) {
            logger.error("Error " + e.getMessage());
            return 0;
        }
    }

    public List<Product> getAllProducts() {
        List<Product> product = productRepository.findAll();
        logger.info("getAllProducts processed correctly");
        return product;
    }
}
