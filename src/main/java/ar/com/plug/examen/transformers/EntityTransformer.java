package ar.com.plug.examen.transformers;

import java.util.List;
import java.util.stream.Collectors;

import ar.com.plug.examen.entities.ClientEntity;
import ar.com.plug.examen.entities.ProductEntity;
import ar.com.plug.examen.entities.SellerEntity;
import ar.com.plug.examen.entities.TransactionEntity;
import ar.com.plug.examen.entities.TransactionProductEntity;
import ar.com.plug.examen.models.Client;
import ar.com.plug.examen.models.Product;
import ar.com.plug.examen.models.Seller;
import ar.com.plug.examen.models.Transaction;
import ar.com.plug.examen.models.TransactionProduct;


/*
 * Transformers Class in charge of manage the data between the entities and model's
 */
public final class EntityTransformer {

    private EntityTransformer(){
        throw new UnsupportedOperationException("Not allowed to instantiate EntityTransformer.");
    }

    public static Client toClient(ClientEntity in) {
        return Client.builder()
                .id(in.getId())
                .name(in.getName())
                .lastName(in.getLastName())
                .address(in.getAddress())
                .document(in.getDocument())
                .phone(in.getPhone())
                .build();
    }

    public static Product toProduct(ProductEntity in) {
        return Product.builder()
                .id(in.getId())
                .name(in.getName())
                .description(in.getDescription())
                .value(in.getValue())
                .quantity(in.getQuantity())
                .build();
    }

    public static Seller toSeller(SellerEntity in) {
        return Seller.builder()
                .id(in.getId())
                .name(in.getName())
                .lastname(in.getLastname())
                .document(in.getDocument())
                .phone(in.getPhone())
                .build();
    }

    public static Transaction toTransaction(TransactionEntity in) {
        return Transaction.builder()
                .id(in.getId())
                .idClient(in.getIdClient())
                .idSeller(in.getIdSeller())
                .stateOrder(in.getStateOrder())
                .dateOrder(in.getDateOrder())
                .transactionProducts(toTransactionProducts(in.getTransactionsProducts()))
                .build();
    }

    public static List<TransactionProduct> toTransactionProducts(List<TransactionProductEntity> in) {
        return in.stream()
                .map(EntityTransformer::toTransactionProduct)
                .collect(Collectors.toList());
    }

    public static TransactionProduct toTransactionProduct(TransactionProductEntity in) {
        return TransactionProduct.builder()
                .id(in.getId())
                .idProduct(in.getIdProduct())
                .value(in.getValue())
                .quantity(in.getQuantity())
                .build();
    }
}
