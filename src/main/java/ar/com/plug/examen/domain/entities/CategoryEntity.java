package ar.com.plug.examen.domain.entities;

import javax.persistence.*;

import lombok.Builder;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "T_CATEGORY")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Set<TransactionEntity> transactions;
}
