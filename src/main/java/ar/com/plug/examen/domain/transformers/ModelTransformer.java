package ar.com.plug.examen.domain.transformers;

import ar.com.plug.examen.domain.entities.CartEntity;
import ar.com.plug.examen.domain.entities.CategoryEntity;
import ar.com.plug.examen.domain.entities.ClientEntity;
import ar.com.plug.examen.domain.entities.TransactionEntity;
import ar.com.plug.examen.domain.model.Cart;
import ar.com.plug.examen.domain.model.Category;
import ar.com.plug.examen.domain.model.Client;
import ar.com.plug.examen.domain.model.Transaction;

import java.util.Set;
import java.util.stream.Collectors;

/*
    Transform Models to Entities.
 */
public final class ModelTransformer {

    private ModelTransformer() {
        throw new UnsupportedOperationException("DTOTransformer can't be accessed or instantiate.");
    }

    public static CartEntity toCartEntity(Cart cart) {
        CartEntity cartEntity = new CartEntity();
        cartEntity.setId(cart.getId());
        cartEntity.setTransactions(toTransactionEntities(cart.getTransactions()));
        cartEntity.setUnitAmount(cart.getAmount());
        return cartEntity;
    }

    public static Set<TransactionEntity> toTransactionEntities(Set<Transaction> transactions) {
        return transactions.stream()
                .map(ModelTransformer::buildTransaction)
                .collect(Collectors.toSet());
    }

    public static TransactionEntity buildTransaction(Transaction transaction){
        TransactionEntity transactionEntity = new TransactionEntity();
        transactionEntity.setId(transaction.getId());
        transactionEntity.setAmount(transaction.getAmount());
        transactionEntity.setCartFK(toCartEntity(transaction.getCart()));
        return transactionEntity;
    }

    public static CategoryEntity toCategoryEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(category.getId());
        categoryEntity.setName(category.getName());
        categoryEntity.setTransactions(toTransactionEntities(category.getTransactions()));
        return categoryEntity;
    }

    public static ClientEntity toClientEntity(Client client) {
        return null;
    }
}
