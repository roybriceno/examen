package ar.com.plug.examen.domain.entities;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Cart {
    private long id;
    private long productFK;
    private BigDecimal unitAmount;
}
