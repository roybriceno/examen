package ar.com.plug.examen.domain.model;

import java.util.Set;

import ar.com.plug.examen.domain.entities.TransactionEntity;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class TransactionStatus {
    private long id;
    private Set<Transaction> transactions;
    private String status;
}


