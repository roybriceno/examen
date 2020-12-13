package ar.com.plug.examen.domain.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.plug.examen.domain.entities.CartEntity;

public interface ICartDao extends CrudRepository<CartEntity, Long>{

}
