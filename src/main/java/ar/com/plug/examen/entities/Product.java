package ar.com.plug.examen.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
public class Product {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(columnDefinition = "varchar(255)")
    private  String name;
    @Column(columnDefinition = "varchar(255)")
    private  String description;
    @Column(columnDefinition = "long")
    private  Long value;
    @Column(columnDefinition = "long")
    private  Long quantity;
    @Column(columnDefinition = "boolean")
    private  Boolean state;

    public Product(@JsonProperty("name")  String name,
                    @JsonProperty("description") String description,
                    @JsonProperty("value") Long value,
                    @JsonProperty("quantity") Long quantity,
                    @JsonProperty("state") Boolean state) {

			        this.name = name;
			        this.description = description;
			        this.value = value;
			        this.quantity = quantity;
			        this.state = state;
    }

    public Product() {

    }
}
