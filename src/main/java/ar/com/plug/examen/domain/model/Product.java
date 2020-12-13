package ar.com.plug.examen.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Builder
@ToString
@EqualsAndHashCode

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
