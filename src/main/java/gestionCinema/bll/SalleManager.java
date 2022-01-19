package gestionCinema.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import gestionCinema.bo.Salle;
import gestionCinema.dao.SalleDAOJDBClmpl;

@Service
@Primary
public class SalleManager {

	@Autowired
	SalleDAOJDBClmpl dao;
	
	public  List<Salle> selectAll() {
		return (List<Salle>) dao.findAll();
	}
		
	public Salle selectById(int id) {
		return dao.findById(id).orElse(null);
	}

	public Salle insert(Salle salleToInsert) {
		return dao.save(salleToInsert);
	}

	public Salle delete(Salle selectById) {
		dao.delete(selectById);
		return selectById;
	}

	public Salle update(Salle salleToUpdate) {
		return dao.save(salleToUpdate);
	}
	
}
