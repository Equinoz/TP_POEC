package gestionCinema.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gestionCinema.bll.BlackListManager;
import gestionCinema.bo.BlackList;

@RestController
@RequestMapping("/WS/blacklist")
public class BlackListREST implements CrudREST<BlackList> {
	
	@Autowired
	BlackListManager manager;

	@Override
	public List<BlackList> getAll() {
		return manager.selectAll();
	}

	@Override
	public BlackList getById(Integer id) {
		return manager.selectById(id);
	}

	@Override
	public BlackList insert(BlackList objectToInsert) throws Exception {
		return manager.insert(objectToInsert);
	}

	@Override
	public BlackList update(Integer id, BlackList objectToUpdate) throws Exception {
		return manager.update(objectToUpdate);
	}

	@Override
	public BlackList deleteById(Integer id) {
		return manager.delete(manager.selectById(id));
	}

}
