package ar.com.plug.examen.domain.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.plug.examen.domain.entities.CategoryEntity;

public interface ICategoryDao extends CrudRepository<CategoryEntity, Long> {

}
