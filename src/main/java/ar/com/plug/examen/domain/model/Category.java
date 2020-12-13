package ar.com.plug.examen.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@Builder
@ToString
@EqualsAndHashCode
public class Category {
	private long id;
    private String name;
    private Set<Transaction> transactions;
}


