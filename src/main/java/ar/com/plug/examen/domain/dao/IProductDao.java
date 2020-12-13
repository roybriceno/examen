package ar.com.plug.examen.domain.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.plug.examen.domain.entities.ProductEntity;

public interface IProductDao extends CrudRepository<ProductEntity, Long>{

}
