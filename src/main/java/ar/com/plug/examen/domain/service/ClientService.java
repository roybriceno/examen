package ar.com.plug.examen.domain.service;

import java.util.List;

import ar.com.plug.examen.domain.entities.ClientEntity;

public interface ClientService {

	public List<ClientEntity> findAll();
	
	public ClientEntity findById(Long id);
	
	public ClientEntity save(ClientEntity client);
	
	public void delete(Long id);
}
