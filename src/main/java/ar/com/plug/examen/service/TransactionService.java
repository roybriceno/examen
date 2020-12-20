package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.Transaction;
import ar.com.plug.examen.repositories.ProductRepository;
import ar.com.plug.examen.repositories.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;
    Logger logger = LoggerFactory.getLogger(SellerService.class);

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, ProductRepository productRepository) {
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
    }

    public int addingTransaction(Transaction transaction) {
        try {
            transactionRepository.save(transaction);
            logger.info("createTransaction processed correctly");
            updateProductQuantity(transaction);
            return 1;
        } catch (Exception e) {
            logger.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int updateProductQuantity(Transaction transaction) {
        try {
            logger.info("updateProductQuantity processed correctly");
            transaction.getTransactionsProducts().stream().forEach((t) -> {
                productRepository.updateQuantity(t.getId_product(), t.getQuantity());
            });
            return 1;
        } catch (Exception e) {
            logger.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int updateTransactionState(Long id, String stateOrder) {
        int result = transactionRepository.updateStateOrder(stateOrder, id);
        return result;
    }

    public List<Transaction> getAllSellers() {
        List<Transaction> transaction = transactionRepository.findAll();
        logger.info("getAllSellers processed correctly");
        return transaction;
    }
}
