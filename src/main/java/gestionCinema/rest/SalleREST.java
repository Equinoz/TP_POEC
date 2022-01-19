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

import gestionCinema.bll.SalleManager;
import gestionCinema.bo.Salle;

@RestController
public class SalleREST {
	@Autowired
	SalleManager manager;

	@GetMapping("WS/salle")
	public List<Salle> getClient() {
		return manager.selectAll();
	}

	@GetMapping("WS/salle/{id}")
	public Salle getClientById(@PathVariable("id") int id) {
		return manager.selectById(id);
	}

	@PostMapping("WS/salle")
	public Salle insertClient(@RequestBody Salle clientToInsert) {
		return manager.insert(clientToInsert);
	}

	@PutMapping("WS/salle/{id}")
	public Salle updateClient(@PathVariable("id") int id, @RequestBody Salle clientToUpdate) {
		return manager.update(clientToUpdate);
	}

	@DeleteMapping("WS/salle/{id}")
	public Salle deleteClientById(@PathVariable("id") int id) {
		return manager.delete(manager.selectById(id));
	}
}
