package ar.com.plug.examen.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.plug.examen.entities.TransactionEntity;
import ar.com.plug.examen.models.Transaction;
import ar.com.plug.examen.service.TransactionService;
import ar.com.plug.examen.service.impl.TransactionServiceImpl;

/**
 * Class to manage the business logic of the app
 */

@RestController
@EnableAutoConfiguration
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionServiceImpl transactionServiceImpl) {
        this.transactionService = transactionServiceImpl;
    }

    @GetMapping("/transaction/get")
    public List<Transaction> showTransaction() {
        return transactionService.getAllSellers();
    }

    @PostMapping("/transaction/post")
    public ResponseEntity<?> addTransaction(@RequestBody Transaction transaction) {
    	TransactionEntity aTransaction = this.transactionService.addTransaction(transaction);
    	return ResponseEntity.ok().body(aTransaction);
        }
}
