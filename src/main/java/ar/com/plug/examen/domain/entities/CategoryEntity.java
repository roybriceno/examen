package ar.com.plug.examen.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "T_CATEGORY")
public class CategoryEntity {
    private long id;
    private String name;
}
