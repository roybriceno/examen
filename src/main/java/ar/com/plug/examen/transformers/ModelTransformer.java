package ar.com.plug.examen.transformers;

import ar.com.plug.examen.entities.*;
import ar.com.plug.examen.models.*;

import java.util.List;
import java.util.stream.Collectors;

public final class ModelTransformer {

    private ModelTransformer(){
        throw new UnsupportedOperationException("Not allowed to instantiate ModelTransformer.");
    }

    public static ClientEntity toClientEntity(Client in) {
        return ClientEntity.builder()
                .id(in.getId())
                .name(in.getName())
                .lastName(in.getLastName())
                .address(in.getAddress())
                .document(in.getDocument())
                .phone(in.getPhone())
                .state(in.isState())
                .build();
    }

    public static ProductEntity toProductEntity(Product in) {
        return ProductEntity.builder()
                .id(in.getId())
                .name(in.getName())
                .description(in.getDescription())
                .value(in.getValue())
                .quantity(in.getQuantity())
                .state(in.isState())
                .build();
    }

    public static SellerEntity toSellerEntity(Seller in) {
        return SellerEntity.builder()
                .id(in.getId())
                .name(in.getName())
                .lastname(in.getLastname())
                .document(in.getDocument())
                .phone(in.getPhone())
                .state(in.isState())
                .build();
    }

    public static TransactionEntity toTransactionEntity(Transaction in) {
        return TransactionEntity.builder()
                .id(in.getId())
                .stateOrder(in.getStateOrder())
                .dateOrder(in.getDateOrder())
                .idClient(in.getIdClient())
                .idSeller(in.getIdSeller())
                .transactionsProducts(toTransactionProductEntities(in.getTransactionProducts()))
                .build();
    }

    public static List<TransactionProductEntity> toTransactionProductEntities(List<TransactionProduct> in) {
        return in.stream()
                .map(ModelTransformer::toTransactionProductEntity)
                .collect(Collectors.toList());
    }

    public static TransactionProductEntity toTransactionProductEntity(TransactionProduct in) {
        return TransactionProductEntity.builder()
                .id(in.getId())
                .value(in.getValue())
                .idProduct(in.getIdProduct())
                .quantity(in.getQuantity())
                .build();
    }
}
