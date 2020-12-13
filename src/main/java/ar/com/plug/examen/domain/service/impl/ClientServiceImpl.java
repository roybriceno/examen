package ar.com.plug.examen.domain.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.com.plug.examen.domain.dao.IClientDao;
import ar.com.plug.examen.domain.entities.ClientEntity;
import ar.com.plug.examen.domain.service.IClientService;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private IClientDao clientDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<ClientEntity> findAll() {
		return (List<ClientEntity>) clientDao.findAll() ;
	}

	@Override
	@Transactional(readOnly = true)
	public ClientEntity findById(Long id) {
		return clientDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public ClientEntity save(ClientEntity client) {
		return clientDao.save(client);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clientDao.deleteById(id);
	}

}
