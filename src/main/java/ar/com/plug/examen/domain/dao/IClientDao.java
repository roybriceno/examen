package ar.com.plug.examen.domain.dao;

import org.springframework.data.repository.CrudRepository;

import ar.com.plug.examen.domain.entities.ClientEntity;

public interface IClientDao extends CrudRepository<ClientEntity, Long>{

}
