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
public class ClientEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(columnDefinition = "varchar(255)")
    private String name;
    @Column(columnDefinition = "varchar(255)")
    private String lastName;
    @Column(columnDefinition = "integer")
    private long document;
    @Column(columnDefinition = "integer")
    private long phone;
    @Column(columnDefinition = "varchar(255)")
    private String address;
    @Column(columnDefinition = "boolean")
    private boolean state;
}
