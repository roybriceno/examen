package ar.com.plug.examen.entities;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name="name",columnDefinition = "varchar(255)")
    private String name;
    @Column(name="description",columnDefinition = "varchar(255)")
    private String description;
    @Column(name="value",columnDefinition = "long")
    private long value;
    @Column(name="quantity",columnDefinition = "long")
    private long quantity;
}
