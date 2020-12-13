package ar.com.plug.examen.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import ar.com.plug.examen.domain.entities.TransactionEntity;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Item {
    private long id;
    private Set<TransactionEntity> transactions;
    private String name;
    private String lastname;
    private String dni;
    private String address;
    private String telephone;
    private LocalDate birthday;
}
