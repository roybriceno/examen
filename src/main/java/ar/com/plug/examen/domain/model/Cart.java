package ar.com.plug.examen.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Set;

@Builder
@ToString
@EqualsAndHashCode
public class Cart {
    private long id;
    private Set<Transaction> transactions;
    private BigDecimal amount;
}
