package ar.com.plug.examen.service;

import ar.com.plug.examen.entities.Transaction;
import ar.com.plug.examen.repositories.ProductRepository;
import ar.com.plug.examen.repositories.TransactionRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final ProductRepository productRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, ProductRepository productRepository) {
        this.transactionRepository = transactionRepository;
        this.productRepository = productRepository;
    }

    public int addingTransaction(Transaction transaction) {
        try {
            transactionRepository.save(transaction);
            log.info("createTransaction processed correctly");
            updateProductQuantity(transaction);
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int updateProductQuantity(Transaction transaction) {
        try {
            log.info("updateProductQuantity processed correctly");
            transaction.getTransactionsProducts().stream().forEach((t) -> {
                productRepository.updateQuantity(t.getId_product(), t.getQuantity());
            });
            return 1;
        } catch (Exception e) {
            log.error("Error " + e.getMessage());
            return 0;
        }
    }

    public int updateTransactionState(Long id, String stateOrder) {
        int result = transactionRepository.updateStateOrder(stateOrder, id);
        return result;
    }

    public List<Transaction> getAllSellers() {
        List<Transaction> transaction = transactionRepository.findAll();
        log.info("getAllSellers processed correctly");
        return transaction;
    }
}
