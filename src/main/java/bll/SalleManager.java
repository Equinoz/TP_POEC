package bll;

import java.util.List;

import bo.Salle;
import dao.SalleDAOJDBClmpl;

public class SalleManager {

	public static List<Salle> selectAll() {
		return SalleDAOJDBClmpl.selectAll();
	}
		
	public static Salle selectById(int id) {
		return SalleDAOJDBClmpl.selectById(id);
	}

	public static Salle insert(Salle salleToInsert) {
		return SalleDAOJDBClmpl.insert(salleToInsert);
	}

	public static Salle delete(Salle selectById) {
		return SalleDAOJDBClmpl.delete(selectById);
	}

	public static Salle update(Salle salleToUpdate) {
		return SalleDAOJDBClmpl.update(salleToUpdate);
	}
	
}
