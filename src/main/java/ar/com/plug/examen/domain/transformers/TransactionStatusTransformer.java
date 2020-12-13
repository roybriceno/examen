package ar.com.plug.examen.domain.transformers;

import java.util.Set;
import java.util.stream.Collectors;

import ar.com.plug.examen.domain.model.Category;
import ar.com.plug.examen.domain.model.Transaction;
import ar.com.plug.examen.domain.entities.CategoryEntity;
import ar.com.plug.examen.domain.entities.TransactionEntity;
public final class TransactionStatusTransformer {

    private TransactionStatusTransformer() {
        throw new UnsupportedOperationException("EntityTransformer can't be accessed or instantiate.");
    }

    public static TransactionStatusEntity toTransactionStatusEntity(TransactionStatusTransformer transactionstatus) {
        return TransactionStatusTransformer.builder()
                .id(transactionstatus.getId())
                .transactions(asSetTransactionEntites(transactionstatus.getTransactions()))
                .build();
    }

    public static Set<TransactionEntity> asSetTransactionEntites(Set<Transaction> transactions) {
        return transactions.stream()
                .map(t -> TransactionEntity.builder()
                        .id(t.getId())
                        .build())
                .collect(Collectors.toSet());
    }

}
