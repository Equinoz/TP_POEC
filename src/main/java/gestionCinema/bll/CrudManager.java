package gestionCinema.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

public class CrudManager<O, D extends CrudRepository<O, Integer>> {

	@Autowired
	public D dao;

	@Transactional
	public List<O> selectAll() {
		return (List<O>) dao.findAll();
	}

	@Transactional
	public O selectById(int id) {
		return (O) dao.findById(id).orElse(null);
	}

	@Transactional
	public O insert(O objectToInsert) throws Exception {
		return dao.save(objectToInsert);
	}

	@Transactional
	public O delete(O objectToDelete) {
		dao.delete(objectToDelete);
		return objectToDelete;
	}

	@Transactional
	public O update(O objectToUpdate) throws Exception {
		return dao.save(objectToUpdate);
	}

}
