package ar.com.plug.examen.domain.entities;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Product {
    private long id;
    private long sellerFK;
    private int quantity;
    private String name;
    private String description;
    private String category;
    private BigDecimal amount;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
}
