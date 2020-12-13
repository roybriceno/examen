package ar.com.plug.examen.domain.entities;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Data
@Builder
@Entity
@Table(name = "T_PRODUCT")
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private long sellerFK;
    private int quantity;
    private String name;
    private String description;
    private String category;
    private BigDecimal amount;
    private LocalDateTime startDate;
    private LocalDateTime dueDate;
}
