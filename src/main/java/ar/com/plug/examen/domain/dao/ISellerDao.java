package ar.com.plug.examen.domain.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.plug.examen.domain.entities.SellerEntity;

public interface ISellerDao extends CrudRepository<SellerEntity, Long> {

}
