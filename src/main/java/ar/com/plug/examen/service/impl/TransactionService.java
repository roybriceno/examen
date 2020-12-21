package ar.com.plug.examen.service.impl;

import ar.com.plug.examen.entities.TransactionEntity;
import ar.com.plug.examen.repositories.ProductRepository;
import ar.com.plug.examen.repositories.TransactionRepository;
import ar.com.plug.examen.service.TransactionServiceImpl;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class TransactionService implements TransactionServiceImpl {

    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, ProductRepository productRepository) {
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
    }

    @Override
	public int addingTransaction(TransactionEntity transactionEntity) {
        try {
            transactionRepository.save(transactionEntity);
            log.info("createTransaction processed correctly");
            updateProductQuantity(transactionEntity);
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    @Override
	public int updateProductQuantity(TransactionEntity transactionEntity) {
        try {
            log.info("updateProductQuantity processed correctly");
            transactionEntity.getTransactionsProducts().stream().forEach((t) -> {
                productRepository.updateQuantity(t.getIdProduct(), t.getQuantity());
            });
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    @Override
	public int updateTransactionState(Long id, String stateOrder) {
        int result = transactionRepository.updateStateOrder(stateOrder, id);
        return result;
    }

    @Override
	public List<TransactionEntity> getAllSellers() {
        List<TransactionEntity> transactionEntity = transactionRepository.findAll();
        log.info("getAllSellers processed correctly");
        return transactionEntity;
    }
}
