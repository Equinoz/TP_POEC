package gestionCinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionCinema.bll.SalleManager;
import gestionCinema.bo.Salle;

@RestController
@RequestMapping("/WS/salle")
public class SalleREST implements CrudREST<Salle> {
	@Autowired
	SalleManager manager;

	@Override
	public List<Salle> getAll() {
		return manager.selectAll();
	}

	@Override
	public Salle getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public Salle insert(Salle objectToInsert) {
		return manager.insert(objectToInsert);
	}

	@Override
	public Salle update(Integer id, Salle objectToUpdate) {
		return manager.update(objectToUpdate);
	}

	@Override
	public Salle deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

	
}
