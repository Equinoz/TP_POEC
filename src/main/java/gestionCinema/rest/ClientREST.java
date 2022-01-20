package gestionCinema.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionCinema.bll.ClientManager;
import gestionCinema.bo.Client;

@RestController
@RequestMapping("/WS/client")
public class ClientREST implements CrudREST<Client> {

	@Autowired
	ClientManager manager;
	
	@Override
	public List<Client> getAll() {
		return manager.selectAll();
	}

	@Override
	public Client getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public Client insert(Client objectToInsert) {
		return manager.insert(objectToInsert);
	}

	@Override
	public Client update(Integer id, Client objectToUpdate) {
		return manager.update(objectToUpdate);
	}

	@Override
	public Client deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

}
