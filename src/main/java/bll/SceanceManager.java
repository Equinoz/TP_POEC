package bll;

import java.util.List;

import bo.Sceance;
import dao.SceanceDAOJDBCImpl;

public class SceanceManager {
	public static List<Sceance> allSceance() {

		return SceanceDAOJDBCImpl.selectAll();

	}
	public static List<Sceance> allSF(){
		return SceanceDAOJDBCImpl.selectAllWithSF();
		
	}
}
