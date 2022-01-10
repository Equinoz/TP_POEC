package bll;

import java.util.List;

import bo.Client;
import dao.ClientDAOJDCImpl;

public class ClientManager {
	public static List<Client> selectAll() {
		return ClientDAOJDCImpl.selectAll();
	}

	public static Client selectById(int id) {
		return ClientDAOJDCImpl.selectById(id);
	}

	public static Client insert(Client clientToInsert) {
		return ClientDAOJDCImpl.insert(clientToInsert);
	}

	public static Client delete(Client selectById) {
		return ClientDAOJDCImpl.delete(selectById);
	}

	public static Client update(Client clientToUpdate) {
		return ClientDAOJDCImpl.update(clientToUpdate);
	}
}
