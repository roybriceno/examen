package ar.com.plug.examen.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.ToString;

@Entity
@Data
@ToString
public class Client {
    
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
    @Column(columnDefinition = "varchar(255)")
    private  String name;
    @Column(columnDefinition = "varchar(255)")
    private  String lastName;
    @Column(columnDefinition = "integer")
    private  Long document;
    @Column(columnDefinition = "integer")
    private  Long phone;
    @Column(columnDefinition = "varchar(255)")
    private  String address;
    @Column(columnDefinition = "boolean")
    private  Boolean state;

    public Client(@JsonProperty("name") String name,
                   @JsonProperty("lastName") String lastName,
                   @JsonProperty("document") Long document,
                   @JsonProperty("phone") Long phone,
                   @JsonProperty("address") String address,
                   @JsonProperty("state") Boolean state) {
			       this.name = name;
			       this.lastName = lastName;
			       this.document = document;
			       this.phone = phone;
			       this.address = address;
			       this.state = state;
    	}
    
    public Client() {

    }
    
	}
