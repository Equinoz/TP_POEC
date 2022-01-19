package gestionCinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import gestionCinema.bll.ClientManager;
import gestionCinema.bo.Client;

@RestController
public class ClientREST {

	@Autowired
	ClientManager manager;

	@GetMapping("WS/client")
	public List<Client> getClient() {
		return manager.selectAll();
	}

	@GetMapping("WS/client/{id}")
	public Client getClientById(@PathVariable("id") int id) {
		return manager.selectById(id);
	}

	@PostMapping("WS/client")
	public Client insertClient(@RequestBody Client clientToInsert) {
		return manager.insert(clientToInsert);
	}

	@PutMapping("WS/client/{id}")
	public Client updateClient(@PathVariable("id") int id, @RequestBody Client clientToUpdate) {
		return manager.update(clientToUpdate);
	}

	@DeleteMapping("WS/client/{id}")
	public Client deleteClientById(@PathVariable("id") int id) {
		return manager.delete(manager.selectById(id));
	}
}
