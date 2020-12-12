package ar.com.plug.examen.domain.transformers;

import ar.com.plug.examen.domain.entities.CartEntity;
import ar.com.plug.examen.domain.entities.TransactionEntity;
import ar.com.plug.examen.domain.model.Cart;
import ar.com.plug.examen.domain.model.Transaction;

import java.util.Set;
import java.util.stream.Collectors;

public final class ModelTransformer {

    private ModelTransformer() {
        throw new UnsupportedOperationException("DTOTransformer can't be accessed or instantiate.");
    }

    public static CartEntity toCartEntity(Cart cart) {
        return CartEntity.builder()
                .id(cart.getId())
                .transactions(asSetTransactionEntites(cart.getTransactions()))
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
