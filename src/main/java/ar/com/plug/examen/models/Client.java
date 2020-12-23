package ar.com.plug.examen.models;

/*
 * Model Class
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonRootName("client")
public class Client {
    @JsonProperty("id")
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("document")
    private Long document;
    @JsonProperty("phone")
    private Long phone;
    @JsonProperty("address")
    private String address;
	
    public Client(Long id, String name, String lastName, Long document, Long phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.document = document;
		this.phone = phone;
		this.address = address;
	}
    
    
}
