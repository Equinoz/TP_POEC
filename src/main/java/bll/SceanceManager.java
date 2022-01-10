package bll;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import bo.Sceance;
import dao.SceanceDAOJDBCImpl;

public class SceanceManager {
	public static List<Sceance> selectAll() {
		return SceanceDAOJDBCImpl.selectAll();
	}
	
	public static List<Sceance> getSceanceWithRemainigSeats() {
		List<Sceance> lst = new ArrayList<Sceance>();
		for(Sceance sc : selectAll()) {
			if(sc.getOccupation()<sc.getSalleAssociee().getCapacité()) {
				lst.add(sc);
			}
		}
		return lst;
	}

	public static int getRemainingSeatsBySceance(Sceance sc) {	
		return sc.getSalleAssociee().getCapacité()-sc.getOccupation();
	}

	public static LocalTime getTimePassedSceance(Sceance sc) {
		LocalDateTime dateTime = null;
		LocalTime time = null;
		//TODO Not yet implemented
		return time;
	}

	public static Sceance selectById(int id) {
		return SceanceDAOJDBCImpl.selectById(id);
	}

	public static Sceance insert(Sceance sceanceToInsert) {
		return SceanceDAOJDBCImpl.insert(sceanceToInsert);
	}

	public static Sceance delete(Sceance selectById) {
		return SceanceDAOJDBCImpl.delete(selectById);
	}

	public static Sceance update(Sceance sceanceToUpdate) {
		return SceanceDAOJDBCImpl.update(sceanceToUpdate);
	}

}
