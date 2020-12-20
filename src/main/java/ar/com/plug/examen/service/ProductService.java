package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.Product;
import ar.com.plug.examen.repositories.ProductRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public int addingProduct(Product product) {
        try {
            productRepository.save(product);
            log.info("insertProduct processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int updatingProduct(Product product) {
        try {
            productRepository.save(product);
            log.info("updateProduc processed correctly");
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

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

    public List<Product> getAllProducts() {
        List<Product> product = productRepository.findAll();
        log.info("getAllProducts processed correctly");
        return product;
    }
}
