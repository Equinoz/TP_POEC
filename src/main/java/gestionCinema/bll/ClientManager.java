package gestionCinema.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import gestionCinema.bo.Client;
import gestionCinema.dao.ClientDAOJDCImpl;

@Service
@Primary
public class ClientManager {

	@Autowired
	ClientDAOJDCImpl dao;

	public List<Client> selectAll() {
		return (List<Client>) dao.findAll();
	}

	public Client selectById(int id) {
		return dao.findById(id).orElse(null);
	}

	public Client insert(Client clientToInsert) {
		return dao.save(clientToInsert);
	}

	public Client delete(Client selectById) {
		dao.delete(selectById);
		return selectById;
	}

	public Client update(Client clientToUpdate) {
		return dao.save(clientToUpdate);
	}
}
