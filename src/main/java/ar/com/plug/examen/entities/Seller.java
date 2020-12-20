package ar.com.plug.examen.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Data
@ToString
public class Seller {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "varchar(255)")
    private String name;
    @Column(columnDefinition = "varchar(255)")
    private String lastname;
    @Column(columnDefinition = "long")
    private Long document;
    @Column(columnDefinition = "long")
    private Long phone;
    @Column(columnDefinition = "boolean")
    private Boolean state;

    public Seller(@JsonProperty("name") String name,
                  @JsonProperty("lastname") String lastname,
                  @JsonProperty("document") Long document,
                  @JsonProperty("phone") Long phone,
                  @JsonProperty("state") Boolean state) {

        this.name = name;
        this.lastname = lastname;
        this.document = document;
        this.phone = phone;
        this.state = state;
    }

    public Seller() {

    }
}
