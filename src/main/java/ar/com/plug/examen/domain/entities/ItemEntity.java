package ar.com.plug.examen.domain.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "T_ITEM")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
}
